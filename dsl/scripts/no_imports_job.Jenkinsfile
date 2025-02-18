pipeline {
    agent any
    stages {
        stage('Test Stage 1') {
            steps {
                script {
                    echo("DSL Params:" +
                        "\n    \u001B[35mDEPLOY_TYPE=${DEPLOY_TYPE}\u001B[0m" +
                        "\n    CUSTOM_TEXT=${CUSTOM_TEXT}")
                    echo("context: nope")
                }
            }
        }
    }
}
