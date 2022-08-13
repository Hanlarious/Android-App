package edu.gatech.seclass.jobcompare6300.database.model;

public class JobOffer extends JobDetail {
    protected int is_current = 0;

    public JobOffer() {
    }

    public JobOffer(int id, String title, String company, String city,  String state, int cost_of_living, double yearly_salary,
                    double yearly_bonus, int retirement_benefit, double relocation_stipend, double restricted_stock, int is_current,
                    String timestamp) {
        super( id,  title,  company,  city,   state,  cost_of_living,  yearly_salary,
         yearly_bonus,  retirement_benefit,  relocation_stipend,  restricted_stock,  0,
         timestamp);
    }

    @Override
    public int getIs_current() {
        return this.is_current;
    }

    @Override
    public void setIs_current(int is_current) {
        this.is_current = is_current;
    }
}
