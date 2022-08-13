package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import edu.gatech.seclass.jobcompare6300.database.JobDetailHelper;
import edu.gatech.seclass.jobcompare6300.database.model.Weights;

public class ComparisonSettingActivity extends AppCompatActivity {

    private EditText YearlySalaryW;
    private EditText YearlyBonusW;
    private EditText RetirementBenefitW;
    private EditText RelocationStipendW;
    private EditText RestrictedStockW;
    JobDetailHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparison_setting);
        db = new JobDetailHelper(this);
        Weights wt = db.getWeights();

        YearlySalaryW = (EditText) findViewById(R.id.YearlySalaryID);
        YearlySalaryW.setText(String.valueOf(wt.getSalary()));
        YearlyBonusW = (EditText) findViewById(R.id.YearlyBonusID);
        YearlyBonusW.setText(String.valueOf(wt.getBonus()));
        RetirementBenefitW = (EditText) findViewById(R.id.RetirementBenefitID);
        RetirementBenefitW.setText(String.valueOf(wt.getBenefit()));
        RelocationStipendW = (EditText) findViewById(R.id.RelocationStipendID);
        RelocationStipendW.setText(String.valueOf(wt.getStipend()));
        RestrictedStockW = (EditText) findViewById(R.id.RestrictedStockID);
        RestrictedStockW.setText(String.valueOf(wt.getStock()));
    }


    public void handleCancelClick(View view)
    {
        // TODO Auto-generated method stub
        Intent i = new Intent(getApplicationContext(),JobManagementActivity.class);
        startActivity(i);
    }

    public void saveweight(View view) {

        boolean is_valid = false;

        is_valid = CheckValue(Integer.valueOf(YearlySalaryW.getText().toString()));
        if(!is_valid)
        {
            YearlySalaryW.setError("Yearly Salary weight value should be between 1..10");
            return;
        }

        is_valid = CheckValue(Integer.valueOf(YearlyBonusW.getText().toString()));
        if(!is_valid)
        {
            YearlyBonusW.setError("Yearly Bonus weight value should be between 1..10");
            return;
        }

        is_valid = CheckValue(Integer.valueOf(RetirementBenefitW.getText().toString()));
        if(!is_valid)
        {
            RetirementBenefitW.setError("Retirement benefit weight value should be between 1..10");
            return;
        }

        is_valid = CheckValue(Integer.valueOf(RelocationStipendW.getText().toString()));
        if(!is_valid)
        {
            RelocationStipendW.setError("Relocation Stipend weight value should be between 1..10");
            return;
        }

        is_valid =  CheckValue(Integer.valueOf(RestrictedStockW.getText().toString()));
        if(!is_valid)
        {
            RestrictedStockW.setError("Restricted Stock weight value should be between 1..10");
            return;
        }

        if(is_valid) {
            db.updateWeights(Integer.valueOf(YearlySalaryW.getText().toString()), Integer.valueOf(YearlyBonusW.getText().toString()),
                    Integer.valueOf(RetirementBenefitW.getText().toString()), Integer.valueOf(RelocationStipendW.getText().toString()),
                    Integer.valueOf(RestrictedStockW.getText().toString()));

            Toast.makeText(this, "Comparison Settings has been saved ", Toast.LENGTH_SHORT).show();
        }

    }

    private boolean CheckValue(Integer value){
        if(value >= 1 && value <=10){
            return true;
        }

        return false;
    }
}