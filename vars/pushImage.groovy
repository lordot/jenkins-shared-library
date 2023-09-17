#! /usr/bin/env groovy

def call(String repo, String imageName) {
    sh "echo $CREDS_PSW | docker login -u $CREDS_USR --password-stdin $repo"
    sh "docker push $repo/$imageName"
    sh "docker push $repo/$imageName"
}