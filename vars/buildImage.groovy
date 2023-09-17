#! /usr/bin/env groovy

def call(String imageName, String repo, String path = '.') {
    sh "docker build $path -t $repo/$imageName"
}