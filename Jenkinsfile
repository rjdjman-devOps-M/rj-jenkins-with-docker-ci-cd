pipeline {

    agent any

    stages {
		
		  stage('Test') {
            steps {
                echo 'Jenkins is working'
            }
          }

        stage('Start') {
            steps {
                echo '========== PIPELINE START =========='
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

        stage('Deploy') {
            steps {
                echo '========== DEPLOY APPLICATION =========='

                sh '''
                    echo "Stopping old application..."

                    sudo systemctl stop myapp || true

                    echo "Copying new JAR..."

                    cp target/*.jar /opt/myapp/app.jar

                    echo "Starting new application..."

                    sudo systemctl start myapp

                    echo "Application started"
                '''
            }
        }

        stage('Verify') {
            steps {
                echo '========== VERIFY APPLICATION =========='

                sh '''
                    sudo systemctl status myapp --no-pager
                '''
            }
        }
    }

    post {

        success {
            echo '========== DEPLOYMENT SUCCESS =========='
        }

        failure {
            echo '========== DEPLOYMENT FAILED =========='
        }

        always {
            echo '========== PIPELINE END =========='
        }
    }
}