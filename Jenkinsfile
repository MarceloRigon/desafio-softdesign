pipeline {
    agent any

    environment {
        MAVEN_HOME = '/usr/local/apache-maven'
    }

    stages {

        stage('Clone do repositório') {
            steps {
                git url: 'INSERIR O REPOSITÓRIO (não contém pois o projeto foi feito localmente)', branch: 'main'
            }
        }

        stage('Build') {
            steps {
                script {
                    echo 'Rodando mvn clean install'
                    sh 'mvn clean install'
                }
            }
        }

        stage('Testes') {
            steps {
                script {
                    echo 'Rodando mvn test'
                    sh 'mvn test'
                }
            }
        }

    }

    post {
        success {
            echo 'Pipeline finalizada com sucesso!'
        }
        failure {
            echo 'Falha na execução da pipeline!'
        }
    }
    post {
        always {
            archiveArtifacts artifacts: 'target/surefire-reports/*.xml', allowEmptyArchive: true
        }
    }

}
