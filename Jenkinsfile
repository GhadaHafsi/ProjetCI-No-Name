pipeline {
    agent any
    
    stages {

        stage ('GIT') {
            steps {
                echo "Pulling project from GIT";
                git branch: 'fournisseur',
                url: "https://github.com/GhadaHafsi/ProjetCI-No-Name.git";
            }
        }

        stage ('COMPILING') {
            steps {
                sh 'mvn compile'
            }
        }

        stage ('SONARQUBE') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
            }
        }
    }
}