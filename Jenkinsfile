pipeline {
    agent any

    environment {
        JAVA_HOME = tool name: 'JDK 11', type: 'jdk'
        PATH = "${JAVA_HOME}\\bin;${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/nitinbhagat12/ATM-Simulation.git'
            }
        }

        stage('Compile') {
            steps {
                bat '''
                if not exist out mkdir out
                javac -d out *.java
                '''
            }
        }

        stage('Run Application') {
            steps {
                bat 'java -cp out Main'
            }
        }

        stage('Archive Classes') {
            steps {
                archiveArtifacts artifacts: 'out\\**\\*.class', fingerprint: true
            }
        }
    }

    post {
        success {
            echo '✅ Build and execution succeeded.'
        }
        failure {
            echo '❌ Build or execution failed.'
        }
    }
}
