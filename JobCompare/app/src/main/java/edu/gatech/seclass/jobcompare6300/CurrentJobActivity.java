package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.EditText;
import android.util.Log;
import android.widget.Toast;

import java.util.HashMap;

import java.io.Console;

import edu.gatech.seclass.jobcompare6300.database.JobDetailHelper;
import edu.gatech.seclass.jobcompare6300.database.model.JobDetail;

public class CurrentJobActivity extends AppCompatActivity {

    Spinner states;
    EditText col;
    Integer job_id;
    JobDetailHelper db;
    Boolean update = false;
    ArrayAdapter adapter;
    HashMap<String, String> state_costndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_job);
        db = new JobDetailHelper(this);
        job_id = db.getCurrenntJobId();
        state_costndex = new HashMap<String, String>();
        states = (Spinner)findViewById(R.id.state);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, db.getStates());
        states.setAdapter(adapter);
        if(job_id > 0){
            populateForm(db.getJobDetail(job_id));
        }

        states.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(String.valueOf(states.getSelectedItemPosition()), "debug msg");
                if(states.getSelectedItemPosition() > 0) {
                    col = findViewById(R.id.cost_of_living);
                    if(!state_costndex.containsKey(states.getSelectedItem().toString())) {
                        state_costndex.put(states.getSelectedItem().toString(), String.valueOf((int) (Math.random() * (193 - 83)) + 83));
                    }
                    col.setText(state_costndex.get(states.getSelectedItem().toString()));
                }
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });
    }


    public void handleCancelClick(View view)
    {
        // TODO Auto-generated method stub
        Intent i = new Intent(getApplicationContext(),JobManagementActivity.class);
        startActivity(i);
    }

    public void createJob(View view) {
        EditText EditText1 = (EditText) findViewById(R.id.title);

        if(IsEmpty(EditText1)){
            EditText1.setError("Enter title");
            EditText1.requestFocus();
            return;
        }

        String title = EditText1.getText().toString();


        EditText EditText2 = (EditText) findViewById(R.id.company);
        if(IsEmpty(EditText2)){
            EditText2.setError("Enter company");
            EditText2.requestFocus();
            return;
        }


        String company = EditText2.getText().toString();
        EditText EditText3 = (EditText) findViewById(R.id.city);

        if(IsEmpty(EditText3)){
            EditText3.setError("Enter city");
            EditText3.requestFocus();
            return;
        }

        String city = EditText3.getText().toString();
        String state = states.getSelectedItem().toString();

        if(state == "Select"){
            //states.setPrompt("Enter state");
            Toast.makeText(this, "Enter state ", Toast.LENGTH_SHORT).show();
            states.requestFocus();
            return;
        }

        EditText EditText4 = (EditText) findViewById(R.id.cost_of_living);
        if(IsEmpty(EditText4)){
            EditText4.setError("Enter cost of living");
            EditText4.requestFocus();
            return;
        }

        String cost_of_living = EditText4.getText().toString();
        EditText EditText5 = (EditText) findViewById(R.id.yearly_salary);
        if(IsEmpty(EditText5)){
            EditText5.setError("Enter yearly salary");
            EditText5.requestFocus();
            return;
        }

        String yearly_salary = EditText5.getText().toString();
        EditText EditText6 = (EditText) findViewById(R.id.retirement_benefit);

        if(IsEmpty(EditText6)){
            EditText6.setError("Enter retirement benefit");
            EditText6.requestFocus();
            return;
        }

        String retirement_benefit = EditText6.getText().toString();
        EditText EditText7 = (EditText) findViewById(R.id.relocation_stipend);
        if(IsEmpty(EditText7)){
            EditText7.setError("Enter relocation stipend");
            EditText7.requestFocus();
            return;
        }

        String relocation_stipend = EditText7.getText().toString();
        EditText EditText8 = (EditText) findViewById(R.id.retirement_stock);
        if(IsEmpty(EditText8)){
            EditText8.setError("Enter retirement stock");
            EditText8.requestFocus();
            return;
        }

        String restricted_stock = EditText8.getText().toString();
        EditText EditText9 = (EditText) findViewById(R.id.yearly_bonus);
        if(IsEmpty(EditText9)){
            EditText9.setError("Enter yearly bonus");
            EditText9.requestFocus();
            return;
        }

        String yearly_bonus = EditText9.getText().toString();

        if(!CheckDouble(yearly_salary)){
            EditText5.setError("Error in Yearly Salary");
            EditText5.requestFocus();
            return;
        }

        if(!CheckDouble(retirement_benefit)){
            EditText6.setError("Error in Retirement Benefit");
            EditText6.requestFocus();
            return;
        }

        if(!CheckDouble(restricted_stock)){
            EditText8.setError("Error in Restricted Stock");
            EditText8.requestFocus();
            return;
        }

        if(!CheckDouble(yearly_bonus)){
            EditText9.setError("Error in Yearly Bonus");
            EditText9.requestFocus();
            return;
        }

        if (update) {
            db.updateJobDetail(job_id, title, company, city, state, Integer.valueOf(cost_of_living), Double.valueOf(yearly_salary), Double.valueOf(yearly_bonus), Integer.valueOf(retirement_benefit), Double.valueOf(relocation_stipend), Double.valueOf(restricted_stock), 1);
            Toast.makeText(this, "Current Job detail has been updated ", Toast.LENGTH_SHORT).show();
        }
        else {
            db.insertJobDetail(title, company, city, state, Integer.valueOf(cost_of_living), Double.valueOf(yearly_salary), Double.valueOf(yearly_bonus), Integer.valueOf(retirement_benefit), Double.valueOf(relocation_stipend), Double.valueOf(restricted_stock), 1);
            Toast.makeText(this, "Current Job detail has been saved ", Toast.LENGTH_SHORT).show();
        }
        finish();
        Intent i = new Intent(getApplicationContext(), CurrentJobActivity.class);
        startActivity(i);
    }

    private boolean CheckDouble(String text){
        if(text.length() - text.replace(".", "").length() > 1){
            return false;
        }
        return true;
    }

    private boolean IsEmpty(EditText editText) {
        if (editText.getText().toString().trim().length() > 0)
            return false;

        return true;
    }

    public void populateForm(JobDetail job) {
        update = true;
        EditText EditText1 = (EditText) findViewById(R.id.title);
        EditText1.setText(job.getTitle());
        EditText EditText2 = (EditText) findViewById(R.id.company);
        EditText2.setText(job.getCompany());
        EditText EditText3 = (EditText) findViewById(R.id.city);
        EditText3.setText(job.getCity());
        states.setSelection(adapter.getPosition(job.getState()));
        EditText EditText4 = (EditText) findViewById(R.id.cost_of_living);
        EditText4.setText(String.valueOf(job.getCost_of_living()));
        System.out.println("getCost_of_living=" + job.getCost_of_living());
        state_costndex.put(job.getState(), String.valueOf(job.getCost_of_living()));
        EditText EditText5 = (EditText) findViewById(R.id.yearly_salary);
        EditText5.setText(String.valueOf(job.getYearly_salary()));
        EditText EditText6 = (EditText) findViewById(R.id.retirement_benefit);
        EditText6.setText(String.valueOf(job.getRetirement_benefit()));
        EditText EditText7 = (EditText) findViewById(R.id.relocation_stipend);
        EditText7.setText(String.valueOf(job.getRelocation_stipend()));
        EditText EditText8 = (EditText) findViewById(R.id.retirement_stock);
        EditText8.setText(String.valueOf(job.getRestricted_stock()));
        EditText EditText9 = (EditText) findViewById(R.id.yearly_bonus);
        EditText9.setText(String.valueOf(job.getYearly_bonus()));
    }
}