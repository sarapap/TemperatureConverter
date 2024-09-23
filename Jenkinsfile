pipeline {
    agent any

    environment {
        DOCKERHUB_CREDENTIALS_ID = 'sarapap'
        DOCKERHUB_REPO = 'sarapap/temperatureconverter'
        DOCKER_IMAGE_TAG = 'latest'
        PATH = "/usr/local/bin:/usr/bin:/bin:/usr/local/opt/maven/bin:$PATH"
    }

    stages {
    stage('Debug Path') {
        steps {
            script {
                sh 'echo $PATH'
                sh 'ls -l /usr/local/bin/docker'
            }
        }
    }

        stage('Checkout') {
            steps {
                git 'https://github.com/sarapap/TemperatureConverter.git'
            }
        }

        stage('Check Docker Version') {
            steps {
                script {
                    // Check Docker version with updated PATH
                    sh 'export PATH=$PATH:/usr/local/bin && docker --version'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    // Build the Docker image
                    def image = sh(script: 'docker build -t ${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG} .', returnStdout: true).trim()
                    echo "Built image: ${image}"
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
