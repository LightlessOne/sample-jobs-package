//local_lib = library identifier: "sm@${scm.getBranches()[0].toString()}", retriever: modernSCM([
//        $class: 'GitSCMSource',
//        remote: scm.getUserRemoteConfigs()[0].getUrl().toString(),
//        credentialsId: env.GLOBAL_GIT_CRED
//])

def context

pipeline {
    agent any
    stages {
        stage('Test Stage 1') {
            steps {
                script {
                    echo("DSL Params:" +
                        "\n    \u001B[35mDEPLOY_TYPE=${DEPLOY_TYPE}\u001B[0m" +
                        "\n    CUSTOM_TEXT=${CUSTOM_TEXT}")
                    context = context.getContext(this)
                    echo(context)
                }
            }
        }
    }
}
