#!/bin/sh
#
#   Copyright 2018  SenX S.A.S.
#
#   Licensed under the Apache License, Version 2.0 (the "License");
#   you may not use this file except in compliance with the License.
#   You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
#   Unless required by applicable law or agreed to in writing, software
#   distributed under the License is distributed on an "AS IS" BASIS,
#   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#   See the License for the specific language governing permissions and
#   limitations under the License.
#


if [ $# != 4 ]
then
  echo "Usage: $0 group artifact version \"Description\""
  exit 1
fi

GROUP=$1
ARTIFACT=$2
VERSION=$3
DESC=$4

# Create WarpScript directory
mkdir -p "src/main/warpscript/${GROUP}/${ARTIFACT}"

sed -e "s/@MODULE_ARTIFACT@/${ARTIFACT}/g" settings.gradle > settings.gradle.new
mv -f settings.gradle.new settings.gradle

sed -e "s/@MODULE_GROUP@/${GROUP}/g" -e 's/@MODULE_ARTIFACT@/${ARTIFACT}/g" -e "s/@MODULE_VERSION@/${VERSION}/g" -e "s/@MODULE_DESCRIPTION@/${DESC}/g" build.gradle > build.gradle.new
mv -f build.gradle.new build.gradle

# Remove .git
rm -rf .git
