package edu.gatech.seclass.jobcompare6300;

import static java.util.Collections.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TableLayout;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import edu.gatech.seclass.jobcompare6300.database.JobDetailHelper;
import edu.gatech.seclass.jobcompare6300.database.model.JobDetail;
import edu.gatech.seclass.jobcompare6300.database.model.Weights;

public class CompareJobActivity extends AppCompatActivity {
    JobDetailHelper db;
    List<JobDetail> jobList;
    int[] choosenId;
    TableLayout table;
    List<Integer> checkBoxList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_job);
        checkBoxList = Arrays.asList(new Integer[2]);
        db = new JobDetailHelper(this);
        jobList = db.getJobDetailArray();
        Weights wt = db.getWeights();

        for(JobDetail job : jobList){
            db.calculateScore(job, wt);
        }
        Collections.sort(jobList, (a, b) -> (int) (b.getScore() - a.getScore()));
        table =  (TableLayout) findViewById(R.id.table);
        shownList(jobList);
        //resetCheckBox();
    }

    //click "compare" button and redirect to "compareTwoJob" page
    public void handleClick_compareTwoJob(View view) {
        Intent i = new Intent(getApplicationContext(), JobRankingActivity.class);
        Integer size_check = SizeCheck();
        if(size_check != 2){
            Toast.makeText(this, "Select 2 jobs to compare ", Toast.LENGTH_SHORT).show();
            return;
        }
        int z = 0;
        for(Integer item: checkBoxList) {
            if(z ==0) {
                i.putExtra("jobA_id", item);
            }
            else {
                i.putExtra("jobB_id", item);
            }
            ++z;
        }
        startActivity(i);
    }

    public void handleCancelClick(View view)
    {
        Intent i = new Intent(getApplicationContext(),JobManagementActivity.class);
        startActivity(i);
    }

    //initialize all checkbox
    public void resetCheckBox(){
        for(int i = 0; i < jobList.size(); i++){
            int checkboxId = getResources().getIdentifier("checkBox" + (i + 1), "id", getPackageName());
            CheckBox checkbox = (CheckBox) findViewById(checkboxId);
            if(checkbox.isChecked()){
                checkbox.setSelected(false);
            }
        }
    }


    // shown sorted lists in panel
    public void shownList(List<JobDetail> jobList ){
        for(int i = 0; i < jobList.size(); i++){
            TableRow row= new TableRow(this);
            row.setMinimumHeight(80);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);
            row.setBackgroundResource(R.drawable.table_border);
            CheckBox checkBox = new CheckBox(this);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                      if (isChecked) {
                          SetCheckBox(buttonView.getId());
                   } else {
                          UnsetCheckBox(buttonView.getId());
                    }
                }
            });
            TextView title = new TextView(this);
            title.setLayoutParams(new
                    TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
            title.setTextColor(Color.BLACK);
            TextView company = new TextView(this);
            company.setTextColor(Color.BLACK);
            company.setLayoutParams(new
                    TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
            checkBox.setId(jobList.get(i).getId());
            View divider = new View(this);
            divider.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, 2));
            divider.setBackgroundColor(Color.GREEN);
            title.setText(jobList.get(i).getTitle());
            company.setText(jobList.get(i).getCompany());
            row.addView(checkBox);
            row.addView(title);
            row.addView(company);
            row.addView(divider);
            table.addView(row,i);
        }
    }

    private Integer SizeCheck(){
        Integer size_check = 0;
        for (Integer ids: checkBoxList) {
            if(ids != null){
                ++size_check;
            }
        }
        return size_check;
    }

    public void SetCheckBox(Integer id)
    {
        Integer size_check = SizeCheck();
        if(size_check == 2){
            CheckBox chk = (CheckBox)findViewById(checkBoxList.get(0));
            if(chk != null)
            {
                chk.setChecked(false);
            }
            checkBoxList.set(0, id);
        }
        else {
            checkBoxList.set(size_check, id);
        }
    }

    public void UnsetCheckBox(Integer id)
    {
        if(checkBoxList.contains(id)) {
            checkBoxList.set(checkBoxList.indexOf(id), null);
        }
    }
}