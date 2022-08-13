package edu.gatech.seclass.jobcompare6300;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import edu.gatech.seclass.jobcompare6300.database.JobDetailHelper;
import edu.gatech.seclass.jobcompare6300.database.model.JobDetail;
import edu.gatech.seclass.jobcompare6300.database.model.Weights;

public class JobRankingActivity extends AppCompatActivity {

    JobDetailHelper db;

    Integer jobA_id = 0;
    Integer jobB_id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_ranking);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            jobA_id = extras.getInt("jobA_id");
            jobB_id = extras.getInt("jobB_id");
        }
        System.out.println("jobA_id=" + jobA_id);
        System.out.println("jobB_id=" + jobB_id);
        db = new JobDetailHelper(this);
        Weights wt = db.getWeights();
        JobDetail jobA = db.getJobDetail(jobA_id);
        JobDetail jobB = db.getJobDetail(jobB_id);
        db.calculateScore(jobA, wt);
        db.calculateScore(jobB, wt);
        shownCompare(jobA, jobB);
    }

    // shown result in panel
    public void shownCompare(JobDetail jobA, JobDetail jobB){
        TextView titleA = (TextView) findViewById(R.id.titleA);
        TextView titleB = (TextView) findViewById(R.id.titleB);
        titleA.setText(jobA.getTitle());
        titleB.setText(jobB.getTitle());

        TextView companyA = (TextView) findViewById(R.id.companyA);
        TextView companyB = (TextView) findViewById(R.id.companyB);
        companyA.setText(jobA.getCompany());
        companyB.setText(jobB.getCompany());

        TextView cityA = (TextView) findViewById(R.id.cityA);
        TextView cityB = (TextView) findViewById(R.id.cityB);
        cityA.setText(jobA.getCity());
        cityB.setText(jobB.getCity());

        TextView stateA = (TextView) findViewById(R.id.stateA);
        TextView stateB = (TextView) findViewById(R.id.stateB);
        stateA.setText(jobA.getState());
        stateB.setText(jobB.getState());

        TextView salaryA = (TextView) findViewById(R.id.salaryA);
        TextView salaryB = (TextView) findViewById(R.id.salaryB);
        salaryA.setText(String.valueOf(jobA.getYearly_salary()));
        salaryB.setText(String.valueOf(jobB.getYearly_salary()));

        TextView bonusA = (TextView) findViewById(R.id.bonusA);
        TextView bonusB = (TextView) findViewById(R.id.bonusB);
        bonusA.setText(String.valueOf(jobA.getYearly_bonus()));
        bonusB.setText(String.valueOf(jobB.getYearly_bonus()));

        TextView benefitA = (TextView) findViewById(R.id.retirementA);
        TextView benefitB = (TextView) findViewById(R.id.retirementB);
        benefitA.setText(String.valueOf(jobA.getRetirement_benefit()));
        benefitB.setText(String.valueOf(jobB.getRetirement_benefit()));

        TextView stipendA = (TextView) findViewById(R.id.stipendA);
        TextView stipendB = (TextView) findViewById(R.id.stipendB);
        stipendA.setText(String.valueOf(jobA.getRelocation_stipend()));
        stipendB.setText(String.valueOf(jobB.getRelocation_stipend()));

        TextView stockA = (TextView) findViewById(R.id.stockA);
        TextView stockB = (TextView) findViewById(R.id.stockB);
        stockA.setText(String.valueOf(jobA.getRestricted_stock()));
        stockB.setText(String.valueOf(jobB.getRestricted_stock()));

        TextView scoreA = (TextView) findViewById(R.id.scoreA);
        TextView scoreB = (TextView) findViewById(R.id.scoreB);
        scoreA.setTextColor(Color.BLUE);
        scoreA.setText(String.valueOf(jobA.getScore()));
        scoreB.setText(String.valueOf(jobB.getScore()));
        scoreB.setTextColor(Color.BLUE);
    }


    public void handleOnClick_CompareMore(View view)
    {
        Intent i = new Intent(getApplicationContext(),CompareJobActivity.class);
        startActivity(i);
    }

    public void handleCancelClick(View view)
    {
        // TODO Auto-generated method stub
        Intent i = new Intent(getApplicationContext(),JobManagementActivity.class);
        startActivity(i);
    }
}
