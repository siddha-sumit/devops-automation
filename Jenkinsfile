pipeline {
    agent any
    tools{
        maven 'maven_3_9_11'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/siddha-sumit/devops-automation']])
                bat 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    bat 'docker build -t sumitjain16/devops-integration .'
                }
            }
        }
        stage('Push image to Hub'){
            steps{
                script{
                  withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd1')]) {
                  echo "Password length: ${dockerhubpwd1}"
                  //bat 'docker login -u sumitjain16 -p ${dockerhubpwd}'
                    bat 'echo %dockerhubpwd1% | docker login -u sumitjain16 --password-stdin'
                    }
                  bat 'docker push sumitjain16/devops-integration'
                }
            }
        }
//         stage('Deploy to k8s'){
//             steps{
//                 script{
//                     kubernetesDeploy (configs: 'deploymentservice.yaml',kubeconfigId: 'k8sconfigpwd')
//                 }
//             }
//         }
    }
}