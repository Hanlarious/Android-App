package edu.gatech.seclass.jobcompare6300.database;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;


import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import edu.gatech.seclass.jobcompare6300.database.model.JobDetail;
import edu.gatech.seclass.jobcompare6300.database.model.JobOffer;
import edu.gatech.seclass.jobcompare6300.database.model.Weights;
import edu.gatech.seclass.jobcompare6300.database.model.Login;


public class JobDetailHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "jobs_db";


    public JobDetailHelper(Context context)  {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(JobDetail.CREATE_TABLE);
        db.execSQL(Weights.CREATE_TABLE);
        db.execSQL(Weights.INSERT_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + JobDetail.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + Weights.TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    public Login getLoginDetail(){
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL(JobDetail.CREATE_TABLE_IF_NOT_EXISTS);
        db.execSQL(Weights.CREATE_TABLE_IF_NOT_EXISTS);
        db.execSQL(Weights.INSERT_TABLE);
        db.close();
        return new Login();
    }

    @SuppressWarnings("unchecked")
    public long getJobCount()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        long jobCount = DatabaseUtils.queryNumEntries(db, JobDetail.TABLE_NAME);
        db.close();
        return jobCount;
    }

    public String[] getStates(){
        return new String[] {"Select", "Alabama", "Alaska", "American Samoa", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "District of Columbia", "Florida", "Georgia", "Guam", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Minor Outlying Islands", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Northern Mariana Islands", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Puerto Rico", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "U.S. Virgin Islands", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"};
    }

    @SuppressWarnings("unchecked")
    public long deleteJob(Integer _id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        long id =  db.delete(JobDetail.TABLE_NAME, "id = ? and is_current = 0 ", new String[]{String.valueOf(_id)});
        db.close();
        return id;
    }

    @SuppressWarnings("unchecked")
    public Integer getCurrenntJobId()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Integer currentjobid=0;
        Cursor cursor = db.rawQuery(
                "select id from " + JobDetail.TABLE_NAME + " where is_current=1" , null);
        if (cursor != null && cursor.getCount()>0)
        {
            cursor.moveToFirst();
            currentjobid=cursor.getInt(0);
            cursor.close();
        }
        return currentjobid;
    }

    @SuppressWarnings("unchecked")
    public long insertJobDetail(String title, String company, String city,  String state, int cost_of_living, double yearly_salary,
                                double yearly_bonus, int retirement_benefit, double relocation_stipend, double restricted_stock, int is_current) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();
        JobDetail job;

        ContentValues values = new ContentValues();
        if(is_current == 1){
            job = new JobDetail();
        }
        else
        {
            job = new JobOffer();
        }

        values.put(job.COLUMN_TITLE, title);
        values.put(job.COLUMN_COMPANY, company);
        values.put(job.COLUMN_CITY, city);
        values.put(job.COLUMN_STATE, state);
        values.put(job.COLUMN_COST_OF_LIVING, cost_of_living);
        values.put(job.COLUMN_YEARLY_SALARY, yearly_salary);
        values.put(job.COLUMN_YEARLY_BONUS, yearly_bonus);
        values.put(job.COLUMN_RETIREMENT_BENEFIT, retirement_benefit);
        values.put(job.COLUMN_RELOCATION_STIPEND, relocation_stipend);
        values.put(job.COLUMN_RESTRICTED_STOCK, restricted_stock);
        values.put(job.COLUMN_IS_CURRENT, is_current);
        // insert row
        long id = db.insert(JobDetail.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    @SuppressWarnings("unchecked")
    public long updateJobDetail(Integer _ID, String title, String company, String city,  String state, int cost_of_living, double yearly_salary,
                                double yearly_bonus, int retirement_benefit, double relocation_stipend, double restricted_stock, int is_current) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(JobDetail.COLUMN_TITLE, title);
        values.put(JobDetail.COLUMN_COMPANY, company);
        values.put(JobDetail.COLUMN_CITY, city);
        values.put(JobDetail.COLUMN_STATE, state);
        values.put(JobDetail.COLUMN_COST_OF_LIVING, cost_of_living);
        values.put(JobDetail.COLUMN_YEARLY_SALARY, yearly_salary);
        values.put(JobDetail.COLUMN_YEARLY_BONUS, yearly_bonus);
        values.put(JobDetail.COLUMN_RETIREMENT_BENEFIT, retirement_benefit);
        values.put(JobDetail.COLUMN_RELOCATION_STIPEND, relocation_stipend);
        values.put(JobDetail.COLUMN_RESTRICTED_STOCK, restricted_stock);
        values.put(JobDetail.COLUMN_IS_CURRENT, is_current);
        // insert row
        long id = db.update(JobDetail.TABLE_NAME, values, "id = ?", new String[]{String.valueOf(_ID)});

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    @SuppressWarnings("unchecked")
    // Returns a single job detail object
    public JobDetail getJobDetail(Integer id) {
        // get readable database
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor=null;
        JobDetail jobDetail = null;
        cursor =  db.rawQuery("select * from " + JobDetail.TABLE_NAME + " where id=" + id  , null);
        if (cursor != null && cursor.getCount()>0)
        {
            if (cursor.moveToFirst())
            {
                jobDetail=new JobDetail();
                jobDetail.setId(id);
                jobDetail.setTitle(cursor.getString(cursor.getColumnIndex(JobDetail.COLUMN_TITLE)));
                jobDetail.setCompany(cursor.getString(cursor.getColumnIndex(JobDetail.COLUMN_COMPANY)));
                jobDetail.setCity(cursor.getString(cursor.getColumnIndex(JobDetail.COLUMN_CITY)));
                jobDetail.setState(cursor.getString(cursor.getColumnIndex(JobDetail.COLUMN_STATE)));
                jobDetail.setCost_of_living(cursor.getInt(cursor.getColumnIndex(JobDetail.COLUMN_COST_OF_LIVING)));
                jobDetail.setYearly_salary(cursor.getDouble(cursor.getColumnIndex(JobDetail.COLUMN_YEARLY_SALARY)));
                jobDetail.setYearly_bonus(cursor.getDouble(cursor.getColumnIndex(JobDetail.COLUMN_YEARLY_BONUS)));
                jobDetail.setRetirement_benefit(cursor.getInt(cursor.getColumnIndex(JobDetail.COLUMN_RETIREMENT_BENEFIT)));
                jobDetail.setRelocation_stipend(cursor.getDouble(cursor.getColumnIndex(JobDetail.COLUMN_RELOCATION_STIPEND)));
                jobDetail.setRestricted_stock(cursor.getDouble(cursor.getColumnIndex(JobDetail.COLUMN_RESTRICTED_STOCK)));
            }
            cursor.close();
        }
        System.out.println("jobDetail getState= " + jobDetail.getState());

        return jobDetail;
    }

    public HashMap<Integer,String> getJobOffers() {
        // get readable database
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor=null;

        HashMap<Integer,String> jobOffers = new HashMap<Integer,String>();
        cursor =  db.rawQuery("select * from " + JobDetail.TABLE_NAME + " where is_current=0" , null);
        jobOffers.put(0, " Select ");
        if (cursor != null && cursor.getCount()>0)
        {
            while (cursor.moveToNext()) {
                jobOffers.put(cursor.getInt(cursor.getColumnIndex(JobDetail.COLUMN_ID)), cursor.getString(cursor.getColumnIndex(JobDetail.COLUMN_TITLE))+ "-" + cursor.getString(cursor.getColumnIndex(JobDetail.COLUMN_COMPANY)));
          }
            cursor.close();
        }
        System.out.println("jobOffers.size= " + jobOffers.size());

        return jobOffers;
    }


    @SuppressWarnings("unchecked")
    // Returns a single job detail object
    public ArrayList<JobDetail> getJobDetailArray() {
        // get readable database
        ArrayList<JobDetail> data = new ArrayList<JobDetail>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor =  db.rawQuery("select * from " + JobDetail.TABLE_NAME , null);

        if(cursor != null && cursor.getCount()>0) {
            while (cursor.moveToNext()) {
                JobDetail jobDetail = new JobDetail(
                        cursor.getInt(cursor.getColumnIndex(JobDetail.COLUMN_ID)),
                        cursor.getString(cursor.getColumnIndex(JobDetail.COLUMN_TITLE)),
                        cursor.getString(cursor.getColumnIndex(JobDetail.COLUMN_COMPANY)),
                        cursor.getString(cursor.getColumnIndex(JobDetail.COLUMN_CITY)),
                        cursor.getString(cursor.getColumnIndex(JobDetail.COLUMN_STATE)),
                        cursor.getInt(cursor.getColumnIndex(JobDetail.COLUMN_COST_OF_LIVING)),
                        cursor.getDouble(cursor.getColumnIndex(JobDetail.COLUMN_YEARLY_SALARY)),
                        cursor.getDouble(cursor.getColumnIndex(JobDetail.COLUMN_YEARLY_BONUS)),
                        cursor.getInt(cursor.getColumnIndex(JobDetail.COLUMN_RETIREMENT_BENEFIT)),
                        cursor.getDouble(cursor.getColumnIndex(JobDetail.COLUMN_RELOCATION_STIPEND)),
                        cursor.getDouble(cursor.getColumnIndex(JobDetail.COLUMN_RESTRICTED_STOCK)),
                        cursor.getInt(cursor.getColumnIndex(JobDetail.COLUMN_IS_CURRENT)),
                        cursor.getString(cursor.getColumnIndex(JobDetail.COLUMN_TIMESTAMP)));
                data.add(jobDetail);
            }
            // close the db connection
            cursor.close();
        }

        return data;
    }


    public long updateWeights(int salary, int bonus, int benefit,
                              int stipend, int stock) {

        // get writable database as we want to write data
        SQLiteDatabase db_w = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Weights.COLUMN_YEARLY_SALARY_WEIGHT, salary);
        values.put(Weights.COLUMN_YEARLY_BONUS_WEIGHT, bonus);
        values.put(Weights.COLUMN_RETIREMENT_BENEFIT_WEIGHT, benefit);
        values.put(Weights.COLUMN_RELOCATION_STIPEND_WEIGHT, stipend);
        values.put(Weights.COLUMN_RESTRICTED_STOCK_WEIGHT, stock);

        // insert row
        long id = db_w.update(Weights.TABLE_NAME, values, null, null);

        // close db connection
        db_w.close();

        // return newly inserted row id
        return id;
    }

    @SuppressWarnings("unchecked")
    // Returns a single job detail object
    public Weights getWeights() {
        // get readable database
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor=null;
        Weights weights = null;
        cursor =  db.rawQuery("select * from " + Weights.TABLE_NAME   , null);
        if (cursor != null && cursor.getCount()>0)
        {
            if (cursor.moveToFirst())
            {
                weights=new Weights();
                weights.setSalary(cursor.getInt(cursor.getColumnIndex(Weights.COLUMN_YEARLY_SALARY_WEIGHT)));
                weights.setBonus(cursor.getInt(cursor.getColumnIndex(Weights.COLUMN_YEARLY_BONUS_WEIGHT)));
                weights.setBenefit(cursor.getInt(cursor.getColumnIndex(Weights.COLUMN_RETIREMENT_BENEFIT_WEIGHT)));
                weights.setStipend(cursor.getInt(cursor.getColumnIndex(Weights.COLUMN_RELOCATION_STIPEND_WEIGHT)));
                weights.setStock(cursor.getInt(cursor.getColumnIndex(Weights.COLUMN_RESTRICTED_STOCK_WEIGHT)));
            }
            cursor.close();
        }

        return weights;
    }


    public void calculateScore (JobDetail job, Weights weights){
        int salaryW = weights.getSalary();
        int bonusW = weights.getBonus();
        int benefitW = weights.getBenefit();
        int stipendW = weights.getStipend();
        int stockW = weights.getStock();

        float total = salaryW + bonusW + benefitW + stipendW + stockW;

        float weight_salary = salaryW / total;
        float weight_bonus = bonusW / total;
        float weight_benefit = benefitW / total;
        float weight_stipend = stipendW / total;
        float weight_stock = stockW / total;

        double AYS = job.getYearly_salary()*100/job.getCost_of_living();
        double AYB = job.getYearly_bonus()*100/job.getCost_of_living();
        double RS = job.getRelocation_stipend();
        float RPB = job.getRetirement_benefit();
        double RSUA = job.getRestricted_stock();

        double score = weight_salary*AYS +
                weight_bonus*AYB +
                weight_stipend*RS +
                weight_benefit*(RPB * AYS / 100) +
                weight_stock*(RSUA / 4);
        job.setScore(Double.valueOf(new DecimalFormat("#.###").format(score)));
    }

}