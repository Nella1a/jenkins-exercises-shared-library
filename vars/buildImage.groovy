#! /usr/bin/env groovy

def call(String UPDATED_VERSION) {
    echo "building the docker image"
    withCredentials([usernamePassword(credentialsId: 'docker-hub-cred', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "docker build -t kanjamn/demo-app:jenkinsexercises-${UPDATED_VERSION} ."
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh "docker push kanjamn/demo-app:jenkinsexercises-${UPDATED_VERSION}"
    }
}