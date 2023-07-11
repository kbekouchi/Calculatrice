pipeline {
    agent any

    /*tools {
        // Install the Maven version configured as "M3" and add it to the path.
        //maven "Mavenn"
        maven "Maven"
    }*/

    stages {
         stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }
        stage('Recuperation du code') {
            steps {
                // Get some code from a GitHub repository
                git url: 'https://github.com/kbekouchi/Calculatrice.git', branch: 'main'
            }
        }
        stage('Droit d acces') {
            steps {

        //          Donner le droit pour executer MavenWrapper.
                sh "chmod +x mvnw"
            }
        }
        stage('Build') {
             steps {

                //Run Maven on a Unix agent.
                sh "./mvnw clean package"

                // To run Maven on a Windows agent, use
                //bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }


            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
             //       junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                    emailext
                        subject: 'Job \'${JOB_NAME}\' (${BUILD_NUMBER}) s est bien deroule',
                        body: 'cliquez sur ${BUILD_URL} et verifier le build',
                        attachLog: true,
                        to:"bekouchi@hotmail.com"
                        recipientProviders: [upstreamDevelopers()]

                    }
            }
        }
    }
}
