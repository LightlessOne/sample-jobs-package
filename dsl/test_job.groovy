pipelineJob("test_job") {
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
                        url("https://github.com/LightlessOne/sample-jobs-package")
                    }
                    branch("ready_for_built_in_dsl_processor")
                }
            }
            scriptPath('dsl/scripts/test_job.Jenkinsfile')
        }
    }
}
