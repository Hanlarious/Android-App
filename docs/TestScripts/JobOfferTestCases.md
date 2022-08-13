## Test Case ID - view_offer

### Test Case Description

Verify a user can view a list of job offers.

### Pre-Conditions

User needs to be authenticated and logged in.

### Test Steps

Navigate to the JobManager Home Page.
Select the "JOB OFFERS" button.

### Test Data

Job Offer Object1 {
    id = 1;
    title = "Test Job";
    company = "Test Company";
    location = "Test Location";
    cost_of_living = "Test Cost of Living";
    yearly_salary = "Test Yearly Salary";
    yearly_bonus = "Test Yearly Bonus";
    retirement_benefit = "Test Retirement Benefit";
    relocation_stipend = "Test Relocation Stipend";
    restricted_stock = "Test Restricted Stock";
}

Job Offer Object2 {
    id = 2;
    title = "Test Job2";
    company = "Test Company2";
    location = "Test Location2";
    cost_of_living = "Test Cost of Living2";
    yearly_salary = "Test Yearly Salary2";
    yearly_bonus = "Test Yearly Bonus2";
    retirement_benefit = "Test Retirement Benefit2";
    relocation_stipend = "Test Relocation Stipend2";
    restricted_stock = "Test Restricted Stock2";
}

### Expected Result

The User should see 2 Job Offers in the list.

### Actual Result

The User sees 2 Job Offers in the list, the data shown is the titles of the job offers - "Test Job" and "Test Job2"

### Status

PASSED

## Test Case ID - add_offer

### Test Case Description

Verify a user can add a job offer.

### Pre-Conditions

User needs to be authenticated and logged in.

### Test Steps

Navigate to the JobManager Home Page.
Select the "JOB OFFERS" button.
Observe the listed job offers of the user.
Select the "ADD OFFER" button.
Observe the Job Offer Form.
Enter the required fields.
Select the "SUBMIT BUTTON".

### Test Data

Job Offer Object {
    id = 3;
    title = "Test Job3";
    company = "Test Company3";
    location = "Test Location3";
    cost_of_living = "Test Cost of Living3";
    yearly_salary = "Test Yearly Salary3";
    yearly_bonus = "Test Yearly Bonus3";
    retirement_benefit = "Test Retirement Benefit3";
    relocation_stipend = "Test Relocation Stipend3";
    restricted_stock = "Test Restricted Stock3";
}

### Expected Result

The User should be redirected to the HomePage after Saving the Job Offer. They should then see the Job Offer in the
JobOffer list page, the title - "Test Job3" will be displayed.

### Actual Result

The User sees the Test Job3 job offer displayed in the job offer list.

### Status

PASSED