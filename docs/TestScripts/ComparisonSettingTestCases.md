## Test Case ID - modify_comparison_settings

### Test Case Description

Verify a user can modify the weights of each salary/bonus/benefit/stipend/stock and use the assigned weights to do the calculations and rank the job offers accordingly.

User needs to be authenticated and logged in.

### Test Steps

Navigate to the Comparison Setting Page.
Set value of each category
Select the "CANCEL" button.
Run Comparison function and observe the ranking.
Navigate to the Comparison Setting Page again.
Set value of each category
Select the "SAVE" button.
Run Comparison function and observe the ranking again.


### Test Data

Comparison Setting1 {
    id = 3;
    yearly_salary_weight = "";
    yearly_bonus_weight = "";
    retirement_benefit_weight = "";
    relocation_stipend_weight = "";
    restricted_stock_weight = "";
    
    botton pressed = "SAVE"

Comparison Setting2 {
    id = 1;
    yearly_salary_weight = "2";
    yearly_bonus_weight = "3";
    retirement_benefit_weight = "4";
    relocation_stipend_weight = "5";
    restricted_stock_weight = "6";
    
    botton pressed = "CANCEL"
}

Comparison Setting3 {
    id = 2;
    yearly_salary_weight = "2";
    yearly_bonus_weight = "3";
    retirement_benefit_weight = "4";
    relocation_stipend_weight = "5";
    restricted_stock_weight = "6";
    
    botton pressed = "SAVE"
}



### Expected Result

Comparison Setting1: no value was assigned, weights should be 1 for all categories;
Comparison Setting2: no weight should be changed;
Comparison Setting3: weights should be assigned to the new values;


### Actual Result

Comparison Setting1: weights are 1 for all categories;
Comparison Setting2: no weight saved, the screen is back to the main menu;
Comparison Setting3: weights are assigned to the new values;

### Status

PASSED




