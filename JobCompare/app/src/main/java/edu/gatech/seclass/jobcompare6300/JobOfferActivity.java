package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.EditText;
import android.util.Log;
import android.widget.Toast;

import java.util.HashMap;


import java.io.Console;

import edu.gatech.seclass.jobcompare6300.database.JobDetailHelper;
import edu.gatech.seclass.jobcompare6300.database.model.JobDetail;

public class JobOfferActivity extends AppCompatActivity {

    Spinner states;
    Spinner existingoffer;
    EditText col;
    Integer job_id = 0;
    Integer current_job_id = 0;
    JobDetailHelper db;
    Boolean update = false;
    ArrayAdapter adapter;
    ArrayAdapter adapter1;
    HashMap<String, String> state_costndex;
    Button compareTheOffer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_offer);
        db = new JobDetailHelper(this);
        compareTheOffer = findViewById(R.id.comparetheoffer);
        current_job_id = db.getCurrenntJobId();
        state_costndex = new HashMap<String, String>();
        states = (Spinner)findViewById(R.id.state);
        existingoffer = (Spinner)findViewById(R.id.existingoffer);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, db.getStates());
        states.setAdapter(adapter);
        HashMap<Integer,String> offers = db.getJobOffers();
        String[] spinnerArray = new String[offers.size()];
        int i = 0;
        for (HashMap.Entry<Integer, String> entry : offers.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());
            spinnerArray[i] = entry.getValue();
            ++i;
        }
        adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, spinnerArray);
        existingoffer.setAdapter(adapter1);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Integer new_job_id = extras.getInt("job_id");
            if(new_job_id > 0){
                populateForm(db.getJobDetail(new_job_id));
                job_id = new_job_id;
            }
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

        findViewById(R.id.delete).setVisibility(View.GONE);
        compareTheOffer.setClickable(false);
        compareTheOffer.setAlpha(.2f);
        existingoffer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Integer selected_id = existingoffer.getSelectedItemPosition();
                if(selected_id != job_id) {
                    for (int key : offers.keySet())
                    {
                        if (offers.get(key).equals(existingoffer.getSelectedItem().toString()))
                        {
                            selected_id = key;
                        }
                    }
                    if (offers.size() > 0) {
                        Log.d("selected_id=" + selected_id, "debug msg");
                        if (selected_id > 0) {
                            populateForm(db.getJobDetail(selected_id));
                            findViewById(R.id.delete).setBackgroundColor(Color.RED);
                            findViewById(R.id.delete).setVisibility(View.VISIBLE);
                            if(current_job_id > 0) {
                                compareTheOffer.setClickable(true);
                                compareTheOffer.setEnabled(true);
                                compareTheOffer.setAlpha(1f);
                            }
                        } else {
                            finish();
                            startActivity(new Intent(getApplicationContext(), JobOfferActivity.class));;
                        }
                        job_id = selected_id;
                    }
                }
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        findViewById(R.id.delete).setBackgroundColor(Color.RED);
    }

    public void handleCancelClick(View view)
    {
        // TODO Auto-generated method stub
        Intent i = new Intent(getApplicationContext(),JobManagementActivity.class);
        startActivity(i);
    }

    public void compareTheOffer(View view)
    {
        Intent i = new Intent(getApplicationContext(),JobRankingActivity.class);
        i.putExtra("jobA_id", current_job_id);
        i.putExtra("jobB_id", job_id);
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
            Toast.makeText(this, "Enter state ", Toast.LENGTH_SHORT).show();
            //states.setPrompt("Enter state");
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
            db.updateJobDetail(job_id, title, company, city, state, Integer.valueOf(cost_of_living), Double.valueOf(yearly_salary), Double.valueOf(yearly_bonus), Integer.valueOf(retirement_benefit), Double.valueOf(relocation_stipend), Double.valueOf(restricted_stock), 0);
            Toast.makeText(this, "Current Job offer has been updated ", Toast.LENGTH_SHORT).show();
        }
        else {
            job_id =  (int)db.insertJobDetail(title, company, city, state, Integer.valueOf(cost_of_living), Double.valueOf(yearly_salary), Double.valueOf(yearly_bonus), Integer.valueOf(retirement_benefit), Double.valueOf(relocation_stipend), Double.valueOf(restricted_stock), 0);
            Toast.makeText(this, "Current Job offer has been saved ", Toast.LENGTH_SHORT).show();
        }
        finish();
        Intent i = new Intent(getApplicationContext(), JobOfferActivity.class);
        i.putExtra("job_id", job_id);
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

    public void deleteJob(View view) {
        db.deleteJob(job_id);
        Toast.makeText(getApplicationContext(), "Current Job offer has been deleted ", Toast.LENGTH_SHORT).show();
        finish();
        restartJob(view);

        /*
        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
        builder.setMessage("Are you sure you want to delete this contact?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        db.deleteJob(job_id);
                        Toast.makeText(getApplicationContext(), "Current Job offer has been deleted ", Toast.LENGTH_SHORT).show();
                        finish();
                        restartJob(view);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        finish();
                    }
                });

         */

    }

    public void restartJob(View view) {
        finish();
        Intent i = new Intent(getApplicationContext(), JobOfferActivity.class);
        startActivity(i);
    }
}