#! /usr/bin/env groovy

def call(){
    echo "running tests"
    // change directory
    dir('app') {
        sh 'npm install'
        sh 'npm run test'
    }
}