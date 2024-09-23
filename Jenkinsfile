pipeline {
    agent any

    environment {
        DOCKERHUB_CREDENTIALS_ID = 'sarapap'
        DOCKERHUB_REPO = 'sarapap/temperatureconverter'
        DOCKER_IMAGE_TAG = 'latest'
        PATH = "/usr/local/opt/maven/bin:/usr/local/opt/maven/bin:$PATH"
        PATH+EXTRA = "/path/to/docker"  // Korvaa oikealla Dockerin polulla
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from the GitHub repository
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
                    // Push the Docker image to Docker Hub
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
