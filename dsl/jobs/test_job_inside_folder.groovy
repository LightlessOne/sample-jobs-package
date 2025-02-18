pipelineJob("${PROJECT_NAME}/jobs/test_job_inside_folder") {
    logRotator {
        numToKeep(10)
    }
    description('Test job from Sample Jobs Package')

    parameters {
        choiceParam("DEPLOY_TYPE", ["Argo", "GroovyV3", "AutoSelect"], "Type of the deployer to use. Can be 'Argo', 'GroovyV3' or 'AutoSelect'")
        textParam("CUSTOM_TEXT", "qwe", "List of custom parameters to pass to helm charts in format KEY=VALUE, separated by semicolon ';'. E.g. - 'KEY1=VALUE1;KEY2=VALUE2'")
    }
    definition {
        cpsScm {
            lightweight(true)
            scm {
                git {
                    remote {
                        url(GIT_REPO_URL)
                        credentials(GIT_REPO_CREDENTIALS)
                    }
                    branch(GIT_REPO_BRANCH)
                }
            }
            scriptPath('dsl/scripts/test_job.Jenkinsfile')
        }
    }
}
