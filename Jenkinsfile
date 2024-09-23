pipeline {
    agent any

    environment {
        DOCKERHUB_CREDENTIALS_ID = 'sarapap'   // DockerHub credentials ID
        DOCKERHUB_REPO = 'sarapap/TemperatureConverter' // Your DockerHub repo
        DOCKER_IMAGE_TAG = 'latest'  // Tag for the Docker image
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout code from GitHub
                git 'https://github.com/sarapap/TemperatureConverter.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    // Build the Docker image
                    def image = docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}")
                }
            }
        }

        stage('Push Docker Image to Docker Hub') {
            steps {
                script {
                    // Log in to Docker Hub and push the image
                    docker.withRegistry('https://index.docker.io/v1/', DOCKERHUB_CREDENTIALS_ID) {
                        def image = docker.image("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}")
                        image.push()
                    }
                }
            }
        }
    }

    post {
        success {
            echo 'Docker image built and pushed successfully!'
        }
        failure {
            echo 'Something went wrong. Check the logs!'
        }
    }
}
