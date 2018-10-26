pipeline {
    agent { docker { image 'maven:3.3.3' } }
     triggers {
        cron('0-59 * * * *')
    }
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
            }
        }

        stage('Test') {
            steps {
                sh 'echo "success!"; exit 0'
            }
        }

        stage('Deploy') {
                    steps {
                        timeout(time: 3, unit: 'MINUTES') {
                            retry(5) {
                                sh './flakey-deploy.sh'
                            }
                        }
                    }
        }
    }
    post {
            always {
                echo 'This will always run'
            }
            success {
                echo 'This will run only if successful'
            }
            failure {
                echo 'This will run only if failed'
            }
            unstable {
                echo 'This will run only if the run was marked as unstable'
            }
            changed {
                echo 'This will run only if the state of the Pipeline has changed'
                echo 'For example, if the Pipeline was previously failing but is now successful'
            }
    }
}
