#! /usr/bin/env groovy

def call(String Repo = "") {
    sh "echo $CREDS_PSW | docker login -u $CREDS_USR --password-stdin $Repo"
}