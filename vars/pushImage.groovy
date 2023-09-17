#! /usr/bin/env groovy

def call(String Repo, String imageName) {
    sh "echo $CREDS_PSW | docker login -u $CREDS_USR --password-stdin $Repo"
    sh "docker push $Repo/$imageName"
    sh "docker push $Repo/$imageName"
}