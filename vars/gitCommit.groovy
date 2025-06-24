#! /usr/bin/env groovy

def call() {
    echo 'commit to changes to github'
    withCredentials([usernamePassword(credentialsId: 'github-cred-two', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'git status'
        sh 'git branch'
        sh 'git config --list'

        sh 'git remote set-url origin https://$USER:$PASS@github.com/Nella1a/jenkins-exercises.git'
        sh 'git add .'
        sh 'git commit -m "ci: version bump"'
        sh 'git push origin HEAD:main'
    }

}