pipeline {
    agent any

    stages {
        stage('Clone Repository') {
            steps {
                git branch: 'main', url: "https://github.com/nimohlee/glomo"
            }
        }

        stage('Build Project') {
            steps {
                sh 'chmod +x ./gradlew'
            }
            steps {
                sh './gradlew clean build'
            }
        }

        stage('Docker login') {
            steps {
                sh 'echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t nimohlee/glomo:latest'
            }
        }

        stage('Push Docker Image') {
            steps {
                sh 'docker push nimohlee/glomo:latest'
            }
        }
    }
}