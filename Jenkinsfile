pipeline {
    agent any

    stages {

        stage('Test') {
            steps {
                echo 'Jenkins is working'
            }
        }

        stage('Checkout') {
            steps {
                echo '========== CHECKOUT CODE =========='

                git branch: 'main',
                    url: 'https://github.com/rjdjman-devOps-M/using-jenkins-deploy-first-spring-boot-app.git'
            }
        }

        stage('Build') {
            steps {
                echo '========== BUILD APPLICATION =========='

                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                echo '========== BUILD DOCKER IMAGE =========='

                sh '''
                    docker build -t rj-spring-app:latest .
                '''
            }
        }

        stage('Deploy') {
            steps {
                echo '========== DEPLOY DOCKER CONTAINER =========='

                sh '''
                    echo "Stopping old container..."

                    docker stop rj-spring-container || true

                    echo "Removing old container..."

                    docker rm rj-spring-container || true

                    echo "Starting new container..."

                    docker run -d \
                        --name rj-spring-container \
                        -p 8081:8081 \
                        rj-spring-app:latest

                    echo "Docker container started"
                '''
            }
        }

        stage('Verify') {
            steps {
                echo '========== VERIFY APPLICATION =========='

                sh '''
                    docker ps

                    echo "Checking application..."

                    sleep 10

                    curl -f http://localhost:8081/ || true
                '''
            }
        }
    }

    post {
        success {
            echo '========== DOCKER DEPLOYMENT SUCCESS =========='
        }

        failure {
            echo '========== DOCKER DEPLOYMENT FAILED =========='
        }

        always {
            echo '========== PIPELINE END =========='
        }
    }
}