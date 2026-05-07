pipeline {
    agent any

    tools {
        maven 'Maven-3'
        jdk   'JDK-11'
    }

    environment {
        APP_NAME = 'calculator-app'
        REPO_URL = 'https://github.com/hasnaa02ahmed/CI-CD-Task.git'
        BRANCH   = 'main'
    }

    options {
        timestamps()
        timeout(time: 15, unit: 'MINUTES')
        buildDiscarder(logRotator(numToKeepStr: '10'))
    }

    stages {

        stage('Clone Repository') {
            steps {
                echo "Cloning branch '${BRANCH}' from ${REPO_URL}"
                git branch: "${BRANCH}", url: "${REPO_URL}"
            }
        }

        stage('Build') {
            steps {
                echo "Building ${APP_NAME} with Maven..."
                bat 'mvn clean compile -B'
            }
        }

        stage('Run Unit Tests') {
            steps {
                echo "Running JUnit 5 unit tests..."
                bat 'mvn test -B'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                    echo "Test report published."
                }
                success {
                    echo "All tests passed!"
                }
                failure {
                    echo "One or more tests failed."
                }
            }
        }

        stage('Package') {
            steps {
                echo "Packaging application..."
                bat 'mvn package -DskipTests -B'
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }

    post {
        success { echo "Pipeline completed successfully for ${APP_NAME}!" }
        failure { echo "Pipeline FAILED. Review the logs for details." }
        always  { cleanWs() }
    }
}