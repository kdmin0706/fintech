#!/bin/sh
# 각 어플리케이션에 존재하는 Dockerfile 을 기준으로 이미지를 빌드

# Setting Versions
VERSION='0.0.1'

cd ..
./gradlew clean build -x test
ROOT_PATH=`pwd -P`
echo $ROOT_PATH

echo 'API Image Build...'
cd $ROOT_PATH/api && docker build -t api:$VERSION .
echo 'API Image Build... Done'

echo 'CONSUMER Image Build...'
cd $ROOT_PATH/consumer && docker build -t consumer:$VERSION .
echo 'CONSUMER Image Build... Done'

echo 'CSS Image Build...'
cd $ROOT_PATH/css && docker build -t css:$VERSION .
echo 'CSS Image Build... Done'

echo 'nginx Image Build...'
cd $ROOT_PATH/nginx  && docker build -t nginx:$VERSION .
echo 'nginx Image Build... Done'