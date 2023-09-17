#! /usr/bin/env groovy

def call(String imageName, String Repo, String Path = '.') {
    sh "docker build $Path -t $Repo/$imageName"
}