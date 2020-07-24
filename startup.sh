#! /bin/bash

mvn clean package

docker build --no-cache -t dozer:v1.0 .

docker run -it -d -v /Users/dufugang/playground/dozer-test/logs:/home/admin/logs --name=dozer-test -p8088:8080 dozer:v1.0
