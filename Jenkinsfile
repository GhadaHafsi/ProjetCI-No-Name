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

        stage ('COMPILING') {
            steps {
                echo "Compiling with Maven...";
                sh 'mvn compile'
            }
        }

        stage ('SONARQUBE') {
            steps {
                echo "Launching static tests...";
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
            }
        }

        stage ('JUNIT-MOCKITO') {
            steps {
                echo "Launching unitairy tests...";
                sh 'mvn test'
            }
        }

        stage ('NEXUS') {
            steps {
                echo "Deploying on Nexus...";
                /*sh 'mvn clean package  deploy:deploy-file  -DgroupId=tn.esprit.rh -DartifactId=achat -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo'
                sh 'mvn dependency:tree';
                sh 'mvn clean';*/
                sh 'mvn clean deploy -Dmaven.test.skip=true'
            }
        }
    }
}
