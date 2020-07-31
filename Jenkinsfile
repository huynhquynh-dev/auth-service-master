pipeline {
    agent any
    tools {
        maven 'Maven_3.6.2'
    }
    stages {
        stage('Stage Build') {
            steps {
                echo 'Build!'
                sh 'mvn clean package -f /var/lib/jenkins/workspace/auth-service/pom.xml'
            }
        }
        stage('Stage Test') {
            steps {
                echo 'Test!'
            }
        }
        stage('Stage Deploy') {
            steps {
                echo 'Deploy!'
                // sh 'docker build -t auth-service .'
            }
        }
        stage('Stage Docker') {
             steps {
                 echo 'Docker!'
                 // docker run --net osstech -p 6789:6789 -d --name auth-service auth-service
           }
        }
    }
}