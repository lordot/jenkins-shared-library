#! /usr/bin/env groovy

def call(String imageName) {
    sh "docker push $imageName"
    sh "docker push $imageName"
}