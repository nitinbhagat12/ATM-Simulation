pipeline {
    agent any

    environment {
        MAVEN_HOME = tool name: 'Maven 3', type: 'maven'
        JAVA_HOME = tool name: 'JDK 11', type: 'jdk'
        PATH = "${JAVA_HOME}/bin:${MAVEN_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/nitinbhagat12/ATM-Simulation.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }

        stage('Archive') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }

        failure {
            mail to: 'your-email@example.com',
                 subject: "Build failed: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: "Check the Jenkins console for more info: ${env.BUILD_URL}"
        }
    }
}
