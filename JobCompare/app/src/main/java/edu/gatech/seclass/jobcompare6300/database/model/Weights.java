package edu.gatech.seclass.jobcompare6300.database.model;


public class Weights {
    public static final String TABLE_NAME = "JobWeight";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_YEARLY_SALARY_WEIGHT = "salary";
    public static final String COLUMN_YEARLY_BONUS_WEIGHT = "bonus";
    public static final String COLUMN_RETIREMENT_BENEFIT_WEIGHT = "benefit";
    public static final String COLUMN_RELOCATION_STIPEND_WEIGHT = "stipend";
    public static final String COLUMN_RESTRICTED_STOCK_WEIGHT = "stock";
    public static final String COLUMN_TIMESTAMP = "timestamp";


    private int id;
    private int salary;
    private int bonus;
    private int benefit;
    private int stipend;
    private int stock;
    private String timestamp;


    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_YEARLY_SALARY_WEIGHT + " INT,"
                    + COLUMN_YEARLY_BONUS_WEIGHT + " INT,"
                    + COLUMN_RETIREMENT_BENEFIT_WEIGHT + " INT,"
                    + COLUMN_RELOCATION_STIPEND_WEIGHT + " INT,"
                    + COLUMN_RESTRICTED_STOCK_WEIGHT + " INT,"
                    + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                    + ")";

    // Create table SQL query
    public static final String CREATE_TABLE_IF_NOT_EXISTS =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_YEARLY_SALARY_WEIGHT + " INT,"
                    + COLUMN_YEARLY_BONUS_WEIGHT + " INT,"
                    + COLUMN_RETIREMENT_BENEFIT_WEIGHT + " INT,"
                    + COLUMN_RELOCATION_STIPEND_WEIGHT + " INT,"
                    + COLUMN_RESTRICTED_STOCK_WEIGHT + " INT,"
                    + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                    + ")";

    public static final String INSERT_TABLE =
            "INSERT INTO " + TABLE_NAME + " ("
                    + COLUMN_YEARLY_SALARY_WEIGHT + " ,"
                    + COLUMN_YEARLY_BONUS_WEIGHT + " ,"
                    + COLUMN_RETIREMENT_BENEFIT_WEIGHT + " ,"
                    + COLUMN_RELOCATION_STIPEND_WEIGHT + " ,"
                    + COLUMN_RESTRICTED_STOCK_WEIGHT + " "
                    + ") VALUES (1,1,1,1,1) ";


    public Weights() {
    }

    public Weights(int id, int salary, int bonus, int benefit,
                   int stipend, int stock, String timestamp) {
        this.id = id;
        this.setSalary(salary);
        this.setBonus(bonus);
        this.setBenefit(benefit);
        this.setStipend(stipend);
        this.setStock(stock);
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getBenefit() {
        return benefit;
    }

    public void setBenefit(int benefit) {
        this.benefit = benefit;
    }

    public int getStipend() {
        return stipend;
    }

    public void setStipend(int stipend) {
        this.stipend = stipend;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}