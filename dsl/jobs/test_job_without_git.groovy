pipelineJob("${PROJECT_NAME}/jobs/test_job_without_git") {
    logRotator {
        numToKeep(10)
    }
    description('Test job from Sample Jobs Package')

    parameters {
        choiceParam("DEPLOY_TYPE", ["Argo", "GroovyV3", "AutoSelect"], "Type of the deployer to use. Can be 'Argo', 'GroovyV3' or 'AutoSelect'")
        textParam("CUSTOM_TEXT", "qwe", "List of custom parameters to pass to helm charts in format KEY=VALUE, separated by semicolon ';'. E.g. - 'KEY1=VALUE1;KEY2=VALUE2'")
    }
    definition {
        cps {
            sandbox(true)
            script(readFileFromWorkspace('dsl/scripts/no_imports_job.Jenkinsfile'))
        }
    }
}
