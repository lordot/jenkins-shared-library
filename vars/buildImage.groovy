#! /usr/bin/env groovy

def call(String imageName) {
    sh "docker build ./airbot -t $imageName"
}