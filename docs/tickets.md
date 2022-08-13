## JS-1
### User Login

Create the view and controller for the user login page

### Acceptance Criteria
- User is presented with a login screen
- User can enter their login credentials (can be test data/hardcoded db)
- If credentials are correct, user is taken to Job Manager screen (placeholder if job screen not created)
- If credentials are incorrect, deny access and show errors

## JS-2
### Job Manager Home page

Job manager home page shows the users current job, maybe some profile information (username), list of job offers

### Acceptance Criteria
- An authenticated User can view the Job manager page
- Can view current job on page
- Can view job offers on page
- Can view profile information (maybe)

## JS-3
### Current Job Form

The user needs to be able to add their current job information
NOTE: field names are specified in requirements and should be validated accordingly

### Acceptance Criteria
- User is able to add and save a current job that persists through login
- User can edit the current job
- User can delete the current job
- User can view the current job on the Job Manager Home page (JS-2)

## JS-4
### Job Offer Form

The user needs to be able to add as many job offers as they want.
NOTE: field names are specified in requirements and should be validated accordingly

### Acceptance Criteria
- User is able to add, edit, and delete multiple job offer
- Form should include a save, cancel, and save/add another offer

## JS-5
### Adjust Comparison Settings

The user should be able to access and adjust settings used for the job comparison

### Acceptance Criteria
- Comparison Settings page UI exists
- User can adjust settings defined in requirements (fields must be validated)

## JS-6
### Compare Jobs

The user should be able to compare jobs with each other with the comparison settings applied (JS-5)

### Acceptance Criteria
- Add Comparison Page/button exists
- Users can select a Job based on rankings (blocked by JS-7)
- User can compare job offers with each other, or a job offer with the current job
- If <1 jobs are associated with the user, job comparison functionality does not work

## JS-7
### Job Ranking

Jobs can be ranked from best to worst based on defined weights and parameters (defined in requirements)

### Acceptance Criteria
- View/UI exists where users can view ranked jobs
- When adding a comparison (JS-6) users can select jobs from this ranking list
