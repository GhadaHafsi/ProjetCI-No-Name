pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M2_HOME" and add it to the path.
        maven "M2_HOME"
    }

    stages {
        stage('GIT') {
            steps {
                // Get some code from a GitHub repository
                git branch: 'Operateur',
                    url: 'https://github.com/GhadaHafsi/ProjetCI-No-Name'
                // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.failure.ignore=true clean package"
            }
        }    
        stage('MVN Clean') {
            steps {
                script
                    {
                        if (isUnix()) 
                            {
                                sh 'mvn --batch-mode clean'
                            }
                            else
                            {
                                bat 'mvn --batch-mode clean'
                            }
                    }
                }
            }
    
        stage('Build'){
            steps{
                script
                    {
                        if (isUnix()) 
                            {
                                sh 'mvn --batch-mode compile'
                            }
                        else
                            {
                                bat 'mvn --batch-mode compile'
                            }
                    }
                 }
        }
        stage('SonarQube'){
            steps{
                script
                    {
                        withSonarQubeEnv('SonarQube Server') {
                        sh "mvn sonar:sonar"
                        }
                    }
            }
        }
        stage('Nexus Deployment'){
            steps{
                script
                    {
                        if (isUnix()) 
                            {
                                sh 'mvn --batch-mode deploy -DskipTests'
                            }
                        else
                            {
                                bat 'mvn --batch-mode deploy -DskipTests'
                            }
                    }
                 }
        }
        stage('JUnit and Mockito Test'){
            steps{
                script
                {
                    if (isUnix())
                    {
                        sh 'mvn --batch-mode test'
                    }
                    else
                    {
                        bat 'mvn --batch-mode test'
                    }
                }
            }
        }
    }
}    
