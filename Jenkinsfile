pipeline {
  agent 'any'
  triggers{ 
	cron('H/5 * * * *') 
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
             allure includeProperties: false, jdk: '', properties: [[key: 'allure.results.directory', value: 'Next-rez/target/allure-results']], report: 'Next-rez/target/allure-report', results: [[path: 'Next-rez/target/allure-results']]
             junit(testResults: '**/target/surefire-reports/*.xml', allowEmptyResults : true, skipPublishingChecks: true)
            }
        }
}

