pipeline {
    agent any

    environment {
        DOCKERHUB_CREDENTIALS_ID = 'dockerhub-credentials'
        DOCKERHUB_REPO = 'nikome1/tripcost'
        DOCKER_IMAGE_TAG = 'ver1'
        //PATH = %PATH%';C:\\Program Files\\apache-maven-3.9.9\\bin'
        PATH = 'C:\Program Files\Common Files\Oracle\Java\javapath;C:\Windows\system32;C:\Windows;C:\Windows\System32\Wbem;C:\Windows\System32\WindowsPowerShell\v1.0\;C:\Windows\System32\OpenSSH\;C:\Program Files\VSCodium\bin;C:\Program Files\nodejs\;C:\Program Files\Kubernetes\Minikube;C:\Program Files\PuTTY\;C:\Program Files\Docker\Docker\resources\bin;C:\Program Files\Git\cmd;C:\Users\mutum\AppData\Local\Programs\Python\Python39\Scripts\;C:\Users\mutum\AppData\Local\Programs\Python\Python39\;C:\Users\mutum\AppData\Local\Microsoft\WindowsApps;C:\Users\mutum\AppData\Local\Programs\Microsoft VS Code\bin;C:\Users\mutum\AppData\Roaming\npm;C:\Program Files\apache-maven-3.9.9\bin;'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/nikomeril/TripCost.git'
            }
        }
        stage('Run Tests') {
            steps {
                // Run the tests first to generate data for Jacoco and JUnit
                bat 'echo %PATH%'
                bat 'mvn clean test' // For Windows agents
                // sh 'mvn clean test' // Uncomment if on a Linux agent
            }
        }
        stage('Code Coverage') {
            steps {
                // Generate Jacoco report after the tests have run
                bat 'mvn jacoco:report'
            }
        }
        stage('Publish Test Results') {
            steps {
                // Publish JUnit test results
                junit '**/target/surefire-reports/*.xml'
            }
        }
        stage('Publish Coverage Report') {
            steps {
                // Publish Jacoco coverage report
                jacoco()
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${env.DOCKERHUB_REPO}:${env.DOCKER_IMAGE_TAG}")
                }
            }
        }
        stage('Push Docker Image to Docker Hub') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', env.DOCKERHUB_CREDENTIALS_ID) {
                        docker.image("${env.DOCKERHUB_REPO}:${env.DOCKER_IMAGE_TAG}").push()
                    }
                }
            }
        }
    }
}

