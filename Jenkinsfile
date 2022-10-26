pipeline {
     environment { 

        registry = "walidmbarek/achatrepo" 

        registryCredential = 'walidmbarek-1' 

        dockerImage = '' 

    }
    agent any
    tools {
    	maven 'M2_HOME'
    }
    stages {
       
        stage('Checkout GIT ') {
            steps {
                echo 'Pulliing ...';
                git branch: 'produit', url: 'https://github.com/GhadaHafsi/ProjetCI-No-Name.git'            }

        }
	    
	    stage('compiler') {
      		steps {
        		sh 'mvn compile'
      		}
    	}
	    stage('Build') {
      		steps {
        		sh 'mvn -B -DskipTests clean package'
      		}
    	}
       
	

     	stage('Building image locally') {
          steps {
         	script {
          dockerImage = docker.build registry 
         }
         }
      }

      stage('Deploy image to Docker Hub') {
      	steps {
         script {
            docker.withRegistry( '', registryCredential ) {
            dockerImage.push()
         }
        }
      }
                
    }         
                
    }
    
}
