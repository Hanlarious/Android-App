package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import edu.gatech.seclass.jobcompare6300.database.JobDetailHelper;


public class JobManagementActivity extends AppCompatActivity {

    Button comparejob;
    JobDetailHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_management);
        db = new JobDetailHelper(this);

        comparejob = findViewById(R.id.compare_job);
        if(db.getJobCount() > 1) {
            comparejob.setClickable(true);
        }
        else {
            comparejob.setAlpha(.2f);
            comparejob.setClickable(false);
        }
    }

    public void handleClick_CurrentJob(View view)
    {
        Intent i = new Intent(getApplicationContext(),CurrentJobActivity.class);
        startActivity(i);
    }

    public void handleClick_JobOffer(View view)
    {
        Intent i = new Intent(getApplicationContext(), JobOfferActivity.class);
        startActivity(i);
    }

    public void handleClick_ComparisonSettings(View view)
    {
        Intent i = new Intent(getApplicationContext(),ComparisonSettingActivity.class);
        startActivity(i);
    }

    public void handleClick_CompareJobs(View view)
    {
        Intent i = new Intent(getApplicationContext(),CompareJobActivity.class);
        startActivity(i);
    }
}