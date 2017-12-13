pipeline {
    agent any
    environment {
        tadutils = load ('utils/helpers-tad.groovy')
    }

    stages {
        stage('Reading TAD') {
            steps {
                script {
                    tadText = readFile 'utils/helpers-tad.groovy'
                    println "tadText=" + tadText
                }
            }
        }
    }
}
