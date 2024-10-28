pipeline {
    agent any

    environment {
        DOCKERHUB_REPO = 'sarapap/temperatureconverter'
        DOCKER_IMAGE_TAG = 'latest'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/sarapap/TemperatureConverter.git'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    // Adding Docker's path to the environment
                    withEnv(["PATH+EXTRA=/usr/local/bin:/bin"]) {
                        docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}")
                    }
                }
            }
        }
        stage('Push Docker Image to Docker Hub') {
            steps {
                script {
                    withEnv(["PATH+EXTRA=/usr/local/bin:/bin"]) {
                        withCredentials([usernamePassword(credentialsId: 'docker_creds',
                                                         usernameVariable: 'DOCKER_USER',
                                                         passwordVariable: 'DOCKER_PASS')]) {
                            sh """
                                docker login -u ${DOCKER_USER} -p ${DOCKER_PASS}
                                docker build -t ${DOCKER_USER}/temperatureconverter:latest .
                                docker push ${DOCKER_USER}/temperatureconverter:latest
                                docker logout
                            """
                        }
                    }
                }
            }
        }
    }
}
