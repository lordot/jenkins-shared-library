#! /usr/bin/env groovy

def call(String imageName, String Path) {
    sh "docker build ./airbot -t $imageName"
}