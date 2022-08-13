package edu.gatech.seclass.jobcompare6300.database.model;

public class JobDetail {
    public static final String TABLE_NAME = "AllJobs";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_COMPANY = "company";
    public static final String COLUMN_CITY = "city";
    public static final String COLUMN_STATE = "state";
    public static final String COLUMN_COST_OF_LIVING = "cost_of_living";
    public static final String COLUMN_YEARLY_SALARY = "yearly_salary";
    public static final String COLUMN_YEARLY_BONUS = "yearly_bonus";
    public static final String COLUMN_RETIREMENT_BENEFIT = "retirement_benefit";
    public static final String COLUMN_RELOCATION_STIPEND = "relocation_stipend";
    public static final String COLUMN_RESTRICTED_STOCK = "restricted_stock";
    public static final String COLUMN_IS_CURRENT = "is_current";
    public static final String COLUMN_TIMESTAMP = "timestamp";

    private int id;
    private String title;
    private String company;
    private String city;
    private String state;
    private int cost_of_living;
    private double yearly_salary;
    private double yearly_bonus;
    private int retirement_benefit;
    private double relocation_stipend;
    private double restricted_stock;
    protected int is_current = 1;
    private String timestamp;
    private double score;

    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_TITLE + " TEXT,"
                    + COLUMN_COMPANY + " TEXT,"
                    + COLUMN_CITY + " TEXT,"
                    + COLUMN_STATE + " TEXT,"
                    + COLUMN_COST_OF_LIVING + " INT,"
                    + COLUMN_YEARLY_SALARY + " DOUBLE,"
                    + COLUMN_YEARLY_BONUS + " DOUBLE,"
                    + COLUMN_RETIREMENT_BENEFIT + " INT,"
                    + COLUMN_RELOCATION_STIPEND + " DOUBLE,"
                    + COLUMN_RESTRICTED_STOCK + " DOUBLE,"
                    + COLUMN_IS_CURRENT + " INT DEFAULT 0,"
                    + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                    + ")";

    public static final String CREATE_TABLE_IF_NOT_EXISTS =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_TITLE + " TEXT,"
                    + COLUMN_COMPANY + " TEXT,"
                    + COLUMN_CITY + " TEXT,"
                    + COLUMN_STATE + " TEXT,"
                    + COLUMN_COST_OF_LIVING + " INT,"
                    + COLUMN_YEARLY_SALARY + " DOUBLE,"
                    + COLUMN_YEARLY_BONUS + " DOUBLE,"
                    + COLUMN_RETIREMENT_BENEFIT + " INT,"
                    + COLUMN_RELOCATION_STIPEND + " DOUBLE,"
                    + COLUMN_RESTRICTED_STOCK + " DOUBLE,"
                    + COLUMN_IS_CURRENT + " INT DEFAULT 0,"
                    + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                    + ")";

    public JobDetail() {
    }

    public JobDetail(int id, String title, String company, String city,  String state, int cost_of_living, double yearly_salary,
                     double yearly_bonus, int retirement_benefit, double relocation_stipend, double restricted_stock, int is_current,
                     String timestamp) {
        this.id = id;
        this.setTitle(title);
        this.setCompany(company);
        this.setCity(city);
        this.setState(state);
        this.setCost_of_living(cost_of_living);
        this.setYearly_salary(yearly_salary);
        this.setYearly_bonus(yearly_bonus);
        this.setRetirement_benefit(retirement_benefit);
        this.setRelocation_stipend(relocation_stipend);
        this.setRestricted_stock(restricted_stock);
        this.setIs_current(is_current);
        this.timestamp = timestamp;
    }

    public int getId() {
        return this.id;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCity() {
        return this.city;
    }

    public String getState() {
        return this.state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getCost_of_living() {
        return this.cost_of_living;
    }

    public void setCost_of_living(int cost_of_living) {
        this.cost_of_living = cost_of_living;
    }

    public double getYearly_salary() {
        return this.yearly_salary;
    }

    public void setYearly_salary(double yearly_salary) {
        this.yearly_salary = yearly_salary;
    }

    public double getYearly_bonus() {
        return this.yearly_bonus;
    }

    public void setYearly_bonus(double yearly_bonus) {
        this.yearly_bonus = yearly_bonus;
    }

    public int getRetirement_benefit() {
        return this.retirement_benefit;
    }

    public void setRetirement_benefit(int retirement_benefit) {
        this.retirement_benefit = retirement_benefit;
    }

    public double getRelocation_stipend() {
        return this.relocation_stipend;
    }

    public void setRelocation_stipend(double relocation_stipend) {
        this.relocation_stipend = relocation_stipend;
    }

    public double getRestricted_stock() {
        return this.restricted_stock;
    }

    public void setRestricted_stock(double restricted_stock) {
        this.restricted_stock = restricted_stock;
    }


    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }


    public int getIs_current() {
        return this.is_current;
    }

    public void setIs_current(int is_current) {
        this.is_current = is_current;
    }

}