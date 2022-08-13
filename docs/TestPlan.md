# Test Plan

**Author**: Team 082

## 1 Testing Strategy

### 1.1 Overall strategy

The Unit testing, Integration testing, System testing, as well as Regression testing will be implemented manually, Unfortunately, since we do not have a real customer, we will not able to do the Acceptance testing.

* Unit testing
    - each class and each function in the classes will be tested individually;
    - test cases will be developed based on the specific requirement for each function;
    - corner cases should be tested;
    - any unit problem should be fixed before moving into the integration phase.

* Integration testing
    - the purpose of the integration testing is to ensure that the interactions between related units do not contain any fault or error;
    - ideally, the testing should cover all interations, but we do not want to combine too many components at a time.

* System testing
    - basically, in this phase, we want to test whether the system meets the requirements, including functional and non-functional requirements;
    - we also want to test if the system is stable and smooth;
    - specifically, we would give a set of inputs and exam the expected outputs manually to test the system as a whole.

* Regression testing
    - this is to ensure that the system can still run properly after revision;
    - specifically, we want to make sure that after making modifications in the integration testing and system testing phases, each class and function can still run properly. Therefore, we would do the unit testing again in this phase.

### 1.2 Test Selection
White-box testing will be adopted in the Unit testing and Integration phase to make sure that each function works as expected and the interaction between functions are proper.In the System testing phase, black-box testing will be selected to test the end-to-end performance.

### 1.3 Adequacy Criterion

We need to cover as many corner cases as we can think of, including some invalid types of inputs, null cases, and input out of boundaries. 

### 1.4 Bug Tracking

A Bug report will be generated and filled in everytime when a bug occurs. The report contains the details, including the trigger, the content, the intented solution, the adopted solution, and the result. 

### 1.5 Technology

Tests will be carried out manually.

## 2 Test Cases

| Case | Purpose              |Steps             |Expected result  |Actual result  |Pass/Fail|
|:-----|:---------------------|:-----------------|:----------------|:--------------|:--------|
|1| User is able to enter current job details| 1. Title, Company, Location, Cost of living, Yearly salary, Yearly bonus, Retirement benefits, Relocation stippend, Stock award should be entered; <br> 2. Try the input type of string, large number, negative number, floats, symbol, and space for all inputs.| User is able to enter all the details in the user interface; <br> User cannot enter invalid input; <br> inputs can be successfully saved after click "SAVE" button; <br> Return to Main page after click "CANCEL" button |1. User successfully enter "Edit Current Job Detail" Page. <br> 2. Error message poped out if enter invalid input, for example "Enter Title" error, "Enter Company" error is poped out if user type in space<br> 3. "Current Job Detail has been uploaded" message poped out after user click "SAVE" button. <br> 4. User return to "Main Menu" Page after click "CANCEL" button| PASS
|2| User is able to edit current job details| 1. Try editing current job details when there is not a record of current job; <br> 2. Try editing all the listed information using the input type of string, large number, negative number, floats, symbol, and space. | The function should be invalid when there is not a record of current job; <br>the previous information should be overwritten by the new inputs; <br> error messages should be shown when invalid input types were inserted. | 1. If no current job in record, all the input box is empty <br> 2. previous information is overwritten after change information <br> 3.Error message poped out if enter invalid input, for example "Enter Title" error, "Enter Company" error is poped out if user type in space | PASS
|3| User is able to either save the current job details or cancel and exit without saving (either case should return to the main menu)| 1. Try saving the detail when generating a current job; <br> 2. Check the current job details to see if information has been saved successfully; <br> 3. Try canceling and exit without saving in the generating new case scenario; <br> 4. Check the current job details to see if there's any information saved; <br> 5. Try saving the detail when editing current job details; <br> 6. Check the current job details to see if information has been overwritten successfully; <br> 7. Try canceling and exit without saving in the editing scenario; <br> 8. Check the current job details to see if any previous information has been overwritten.| Information should be successfully saved/overwritten when the user chooses to save, the screen should return to the main menu after the action; <br> information should be abandoned when the user chooses to exit without saving, the screen should return to the main menu after the action; <br> if canceled when generating a current job, current job details should show an empty page. | 1. "Current Job Detail has been uploaded" message poped out after user click "SAVE" button. <br> 2. User return to "Main Menu" Page after click "CANCEL" button <br> 3. If user click "CANCEL" button without clicking "SAVE" button, nothing will be stored in the app. The user will be redirected to "Main Menu" Page<br> | PASS
|4| User is able to enter job offers| 1. Title, Company, Location, Cost of living, Yearly salary, Yearly bonus, Retirement benefits, Relocation stippend, Stock award should be inserted; <br> 2. Try the input type of string, large number, negative number, floats, symbol, and space for all inputs.| User interface should allow the user to enter all the details; <br> inputs should be successfully saved, error messages should be shown when invalid input types were entered. <br> User can return main page after clicking "CANCEL" button. <br> User can enter another offer after finishing currrrent one. <br> User can compare this offer to current job to show detail information about this two offers. <br> User can delete the job offer in the app. <br> User can select existing offer to edit. | 1. User successfully enter "Edit Current Job Offer" Page. <br> 2. Error message poped out if enter invalid input, for example "Enter Title" error, "Enter Company" error is poped out if user type in space. <br> 3. User is redirected to a  new "Edit Current Job Offer" page after clicking "ENTER ANOTHER OFFER" button. <br> 4. User is redirected to "Job Comparison Results" after clicking "COMPARE THIS OFFER" button. This new page shows the detailed job information of selseted job offer and current job offer. <br> 5. The job offer is deleted after click "DELETE THIS JOB" button. <br> 6. User can switch and select existing offers by using drop down menu.| PASS
|5| User is able to adjust comparison settings| 1. Assign weights to yearly salary, yearly bonus, retirement benefits, relocation stipend, stock award, click "CANCEL"; <br> 2. Assign weights to yearly salary, yearly bonus, retirement benefits, relocation stipend, stock award, click "SAVE";<br> 3. Edit weights again and click "CANCEL"; <br> 4. Edit weights again and click "SAVE"; <br> 5. Try the input type of string, large number, negative number, floats, symbol, and space | If no weights are assigned, the attributes should have an equal initial number of 1; <br> weights should be successfully saved or updated; <br> error messages should be shown when invalid input types were entered. | 1. Weights are still "1" by default, returned to the main menu; <br> 2. New weights are saved and shown in the page; <br> 3. Weights are not updated, returned to the main menu, and the previous weights are still in use; <br>4. Weights are updated and shown in the page; <br> 5. Only numbers can be accepted, other forms of input cannot be entered.| PASS
|6| User is able to compare job offers| 1. Compare a job offer with current job when no current job record; <br> 2. Compare a job offer with current job when there is a current job; <br> 3. Compare two job offers; <br> 4. Try starting a new comparison; <br> 5. Try returning to the main menu.| User should be shown a list of job offers, ranking from best to worst, listing the title and company in the UI; <br> the UI should clearly show if there's a current job; <br> the comparison should only be triggered when two elements are selected (either two job offers or one job offer and current job); <br> title, company, location, adjusted yearly salary, adjusted yearly bonus, retirement benefits, relocation stipend, and stock award should be displayed for each element; <br>after comparison, the user should have the option of either to start a new comparison or go back to the main menu.| 1. Cannot compare without a current job record; <br> 2. Comparison can be carried out successfully; <br>3. Comparison can be carried out successfully; <br> 4. starting a new comparison can be carried out successfully by clicking "COMPARE MORE" button; <br> 5. returned to the main menu by clicking the "RETURN" button.|PASS |7| Compare function is baned when no job offers has been entered| 1. Try the compare function when no job offer has been entered and no record of current job; <br> 2. Try the compare function when no job offer has been entered and there's a record of current job; <br> 3. Try the compare function when one job offer has been entered without a record of current job; <br> 4. Try the compare function when one job offer has been entered with a record of current job.  | The compare function should be baned for the first three scenarios.| 1. The comparison page cannot be entered; <br>2. The comparison page cannot be entered; <br>3. The comparison page cannot be entered; <br> 4. The comparison page can be entered.|PASS
|8| Jobs can be ranked correctly| 1. Create a excel to calculate scores for each job offer and rank them; <br> 2. run the comparison function and compare the results, including the rank and scores. <br> 3. change the weights for both excel and the project, and compare the results again | The rank of the job offers and their scores should be the same as the results from the excel.| 1. Got a rank with scores; <br> 2. the results match each other, including the sequence and the scores; <br> 3. the results still match each other after changing the weights.|PASS  
|9| Login page is correctly shown| Try signing in with the dummy user's username and password. | Should be able to log in and take further actions.| logged in successfully. | PASS


