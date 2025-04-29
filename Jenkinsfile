pipeline {
    agent any

    environment {
        JAVA_HOME = tool name: 'JDK 11', type: 'jdk'
        PATH = "${JAVA_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/nitinbhagat12/ATM-Simulation.git'
            }
        }

        stage('Compile') {
            steps {
                sh '''
                    mkdir -p out
                    javac -d out $(find . -name "*.java")
                '''
            }
        }

        stage('Run Main Class') {
            steps {
                // Replace 'MainClass' with your actual main class (e.g., ATMMain, ATMApp, etc.)
                sh 'java -cp out MainClass'
            }
        }

        stage('Archive Classes') {
            steps {
                archiveArtifacts artifacts: 'out/**/*.class', fingerprint: true
            }
        }
    }

    post {
        failure {
            echo 'Build failed!'
        }
    }
}

