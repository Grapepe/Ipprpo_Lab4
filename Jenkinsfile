pipeline {
    agent any
    options {
        timestamps()
        buildDiscarder(logRotator(numToKeepStr: '10'))
        disableConcurrentBuilds()
    }
    triggers {
        pollSCM('H/2 * * * *')
    }
    tools {
        // Имена должны совпадать с Manage Jenkins -> Tools
        jdk 'jdk21'
        maven 'maven3'
    }
    stages {
        stage('Fix Git Ownership') {
            steps {
                bat 'git config --global --add safe.directory E:/repos/fibonacci-ci-demo.git'
            }
        }
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM',
                          branches: [[name: '*/main']],
                          userRemoteConfigs: [[url: 'file:///E:/repos/fibonacci-ci-demo.git']]])
            }
        }
        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                    publishHTML([reportDir: 'target/site/jacoco',
                                 reportFiles: 'index.html',
                                 reportName: 'JaCoCo Coverage',
                                 keepAll: true,
                                 alwaysLinkToLastBuild: true,
                                 allowMissing: false])
                }
            }
        }
        stage('Package') {
            steps {
                bat 'mvn package -DskipTests'
            }
            post {
                success {
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                }
            }
        }
        stage('Deploy Local Production') {
            when {
                // 'branch' работает только в multibranch-заданиях; в обычном Pipeline BRANCH_NAME не задан
                anyOf {
                    branch 'main'
                    expression { env.BRANCH_NAME == null }
                }
            }
            steps {
                echo 'Запуск исполняемого артефакта в продакшн-окружении...'
                bat 'start /B java -jar target/fibonacci-ci-demo-1.0.0.jar > production_app.log 2>&1'
            }
        }
    }
}
