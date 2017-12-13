#!groovy

pipeline {
    agent none
    parameters {
        tadutils = load ('utils/helpers-tad.groovy')
    }

    stages {
        stage('Reading TAD') {
            steps {
                tadText = readfile 'utils/helpers-tad.groovy'
                println "tadText=" + tadText
            }
        }
    }
}

