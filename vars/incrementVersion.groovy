#! /usr/bin/env groovy

def call(String UPDATED_VERSION) {
    echo 'incrementing app version'
    // change directory
    dir('app') {
        sh 'git fetch'
        def CURRENT_VERSION = sh(
                script: "node -p \"require('./package.json').version\"",
                returnStdout: true
        ).trim()
        sh 'npm version minor --git-tag-version false'

        UPDATED_VERSION = sh(
                script: "node -p \"require('./package.json').version\"",
                returnStdout: true
        ).trim()

        sh 'git add package.json'
        sh '[ -f ./package-lock.json ] && git add package-lock.json'
    }
}