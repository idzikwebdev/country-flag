node {
  stage('SCM') {
    checkout scm
    echo $JAVA_HOME$
    eco $PATH$
  }
  stage('SonarQube Analysis') {
    echo $JAVA_HOME$
    eco $PATH$
    def mvn = tool 'Default Maven';
    withSonarQubeEnv() {
      sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=Country-Flag"
    }
  }
}
