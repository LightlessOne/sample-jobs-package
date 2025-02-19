## sample-jobs-package

Sample package to install as an artifact into Jenkins

### Required Jenkins plugins:

- [Pipeline](https://plugins.jenkins.io/workflow-aggregator/)
- [Git](https://plugins.jenkins.io/git/) (version 5 or higher recommended)
- [Job DSL](https://plugins.jenkins.io/job-dsl/) (1.49 or higher)

### Setup:

- Need to disable "Enable script security for Job DSL scripts" (uncheck checkbox in YOUR_JENKINS_URL/manage/configureSecurity) (otherwise you'll have to manually approve each script installed via Seed Job)
- Generate API Token for your user (User -> Security -> API Token)
- If you plan on using provided workflows, set generated API token as "JENKINS_TOKEN" secret in GitHub parameters

This repo has the following workflows:

- **Create SeedJob in Jenkins** - uploads seed_job.xml to Jenkins instance via jenkins-cli tool
- **Trigger SeedJob in Jenkins** - triggers SeedJob to install Jenkins DSL jobs from specified repo

### DSL configuration tips:

- For "Job DSL" plugin to correctly process your DSL scripts, script names may only contain letters, digits and
  underscores, but may not start with a digit (so it should be a valid Java variable name)  
  e.g. _test-job-with-dashes.groovy_ will result in error during processing

- Current repo example shows how you may initialize your Jenkins folder structure:  
  All DSL files are processed in alphanumeric order, and if a Job is contained inside a folder, that folder should be
  created beforehand  
  That's why there is a separate `_folders.groovy` (starting with underscore, so it's processed first) that creates all
  the required folders
- All the jobs need to have full path (relative to install dir, `PROJECT_NAME` - folder is passed as a variable from
  `trigger_seed_job` action)  
  e.g. `pipelineJob("${PROJECT_NAME}/jobs/test_job_inside_folder")`  
  It will not automatically create all the sub-folders, you need to do it as a separate DSL command
