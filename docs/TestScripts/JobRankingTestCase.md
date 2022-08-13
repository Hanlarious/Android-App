## Test Case ID - view_compare_job_offer

### Test Case Description

Verify a user can view list of job offer with title and company information, ranking from best to worst.

User needs to be authenticated and logged in.

### Test Steps

Navigate to the JobManager Home Page.
Select the "COMPARE JOB" button.
Observe the listed job offers of the user.

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

Job Offer Object3 {
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

Assume Object1 score > Object2 score > Object3 score

### Expected Result

The User should see 3 Job Offers with their title and companey information in the list with the rank of Object1, Object2, Object3.

### Actual Result

The User sees 3 Job Offers in the list, the data shown is the titles and company of the job offers 
First line: "Test Job1" , "Test Company1"
Second line:  "Test Job2" , "Test Company2"
Third line:  "Test Job3" , "Test Company3"

### Status

PASSED




## Test Case ID - view_compare_two_job_offer

### Test Case Description

Verify a user can successfully click "COMPARE" button and view detailed information of two job offers selected from view_compare_offer.

### Pre-Conditions

User needs to be authenticated and logged in.

### Test Steps

Navigate to the JobManager Home Page.
Select the "COMPARE JOB" button.
Select two job from the list
Select the "COMPARE" button.
Observe the Compare Two Job Offer Form.

### Test Data

the same with test case ID - view_compare_job_offer. The user choose the first two (Object1 and Object2) for testing.

### Expected Result

The User should be redirected from CompareJobOffer page to the CompareTwoJobOffer page after clicking 'COMPARE' button. They should then see the detailed information of two Job Offer in the
this page.

### Actual Result

In first column(Job A): "Test Job1"; "Test Company1"; "Test Location1"; "Test Yearly Salary1"; "Test Yearly Bonus1"; "Test Retirement Benefit1"; "Test Relocation Stipend1"; "Test Restricted Stock1";
In second column(Job B): "Test Job2"; "Test Company2"; "Test Location1"; "Test Yearly Salary2"; "Test Yearly Bonus2"; "Test Retirement Benefit2"; "Test Relocation Stipend2"; "Test Restricted Stock2";

### Status

PASSED


## Test Case ID - compare_more_button

### Test Case Description

Verify a user can compare more job offer from view_compare_two_job_offer.

### Pre-Conditions

User needs to be authenticated and logged in and user already in the page of view_compare_two_job_offer.

### Test Steps

Navigate to the Compare Job Offer Page.
Select the "COMPARE  MORE" button.
Observe the Compare Job offer.

### Test Data

the same with test case ID - view_compare_job_offer. 

### Expected Result

The User should be redirected to the CompareJobOffer page after clicking 'COMPARE MORE' button. They should then see the detailed information of three Job Offer in the
this page.

### Actual Result

The User sees 3 Job Offers in the list, the data shown is the titles and company of the job offers 
First line: "Test Job1" , "Test Company1"
Second line:  "Test Job2" , "Test Company2"
Third line:  "Test Job3" , "Test Company3"

### Status

PASSED

## Test Case ID - return_button_in_view_compare_two_job_offer

### Test Case Description

Verify a user can return to the main page from view_compare_two_job_offer.

### Pre-Conditions

User needs to be authenticated and logged in and user already in the page of view_compare_two_job_offer.

### Test Steps

Navigate to the Compare Job Offer Page.
Select the "RETURN" button.
Observe the Job Manager Page.

### Test Data

the same with test case ID - view_compare_job_offer. 

### Expected Result

The User should be redirected to the JobManager page after clicking 'RETURN' button. They should then see the Main Menu page.

### Actual Result

The User sees Main Menu page with "CURRENT JOB" button, "JOB OFFER" button, "COMPARISION SETTINGS" button, and "COMPARE JOBs" button. 

### Status

PASSED




## Test Case ID - cancel_button_in_view_compare_job_offer

### Test Case Description

Verify a user can cacel the selection from view_compare_job_offer.

### Pre-Conditions

User needs to be authenticated and logged in and user already in the page of view_compare_job_offer.

### Test Steps

Navigate to the Compare Job Offer Page.
Select the "CANCEL" button.
Observe the Compare Job Offer Page.

### Test Data

the same with test case ID - view_compare_job_offer. 

### Expected Result

The selection in checkbox should be unchecked after clicking 'CANCEL' button. 

### Actual Result

All checkbox are become unchecked.
The User sees 3 Job Offers in the list, the data shown is the titles and company of the job offers 
First line: "Test Job1" , "Test Company1"
Second line:  "Test Job2" , "Test Company2"
Third line:  "Test Job3" , "Test Company3"


### Status

PASSED
