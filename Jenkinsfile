pipeline {
    agent any
    stages {
        stage('Git Checkout') {
           steps{
                bat 'echo Git Checkout'
                git branch: 'main', url: 'https://nozellamila/desafioselenium.git'
            }
        }
        stage('Build Stage') {
            steps{
                bat 'echo build'
                mvn build
            }
        }
        stage('Test Execution Stage') {
            steps{
                bat 'echo Test Execution Started'
                mvn test
            }
        }
    }
}