#! /usr/bin/env groovy

def call(String Path = '.') {
    env.CURRENT_VERSION = sh(script: "cat ${Path}/Dockerfile | grep \"LABEL version\" | cut -d \"=\" -f2", returnStdout: true).trim()
    echo "Old version from Dockerfile: ${env.CURRENT_VERSION}"


    def versionParts = env.CURRENT_VERSION.tokenize('.')
    def newPatchVersion = versionParts[2].toInteger() + 1
    env.CURRENT_VERSION = "${versionParts[0]}.${versionParts[1]}.${newPatchVersion}"

    sh "sed -i 's/LABEL version=.*/LABEL version=${env.CURRENT_VERSION}/' ${Path}/Dockerfile"
    echo "New version: ${env.CURRENT_VERSION}"
}

