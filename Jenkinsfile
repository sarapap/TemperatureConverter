
pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/sarapap/ProgrammingProjectExercises1.git'
            }
        }

        stage('Build') {
            steps {
                withEnv(["PATH+EXTRA=/usr/local/opt/maven/bin:/bin:/usr/bin"]) {
                    sh 'mvn clean install'
                }
            }
        }

        stage('Test') {
            steps {
                withEnv(["PATH+EXTRA=/usr/local/opt/maven/bin:/bin:/usr/bin"]) {
                    sh 'mvn test'
                }
            }
        }

        stage('Code Coverage') {
            steps {
                jacoco execPattern: '**/target/jacoco.exec'
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
            jacoco execPattern: '**/target/jacoco.exec'
        }
    }
}
