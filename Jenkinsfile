pipeline {
    agent any
    
    stages {

        stage ('GIT') {
            steps {
                echo "Pulling project from GIT...";
                git branch: 'fournisseur',
                url: "https://github.com/GhadaHafsi/ProjetCI-No-Name.git";
            }
        }
        
        stage ('CLEAN') {
            steps {
                echo "Cleaning project...";
                sh 'mvn clean'
            }
        }

        stage ('COMPILING') {
            steps {
                echo "Compiling with Maven...";
                sh 'mvn compile'
            }
        }

        stage ('NEXUS') {
            steps {
                echo "Deploying on Nexus...";
                sh 'mvn deploy -DskipTests'
            }
        }
    }
}
