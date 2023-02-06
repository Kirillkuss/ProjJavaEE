pipeline {
  agent 'any'
  	triggers{
		cron('H H(9-16)/2 * * 1-5')
	}
  stages {
    stage('Clean') {
      steps {
        bat(script: 'mvn clean')
      }
    }
    stage('Test') {
      steps {
        bat(script: 'mvn test')
      }
    }
    stage('Compile') {
      steps {
        bat(script: 'mvn compile')
      }
    }
    
    stage('Package') {
      steps {
        bat(script: 'mvn package')
      }
    }

    
  }
    post {
        always {
            junit(testResults: '**/target/surefire-reports/*.xml', allowEmptyResults : true, skipPublishingChecks: true)
            }
        }
}

