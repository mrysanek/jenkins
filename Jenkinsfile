pipeline {
    agent any
    environment {
        tadutils = load ('utils/helpers-tad.groovy')
    }

    stages {
        stage('Reading TAD') {
            steps {
                script {
                    tadText = readfile 'utils/helpers-tad.groovy'
                    println "tadText=" + tadText
                }
            }
        }
    }
}
