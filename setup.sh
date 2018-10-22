#!/bin/sh

if [ $# != 3 ]
then
  echo "Usage: $0 extension-name version \"Description\""
  exit 1
fi

NAME=$1
VERSION=$2
DESC=$3

sed -e "s/@EXT_NAME@/${NAME}/g" settings.gradle > settings.gradle.new
mv -f settings.gradle.new settings.gradle

sed -e "s/@EXT_VERSION@/${VERSION}/g" -e "s/@EXT_DESCRIPTION@/${DESC}/g" build.gradle > build.gradle.new
mv -f build.gradle.new build.gradle
