#!groovy

pipeline {
    agent none
    parameters {
        def tadutils = load ('utils/helpers-tad.groovy')
    }

    stages {
        stage('Reading TAD') {
            tadText = readfile 'utils/helpers-tad.groovy'
            println "tadText=" + tadText
        }
    }
}

