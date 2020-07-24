#! /bin/bash

docker stop dozer-test
docker rm dozer-test
docker rmi -f $(docker images | grep "^<none>" | awk "{print $3}")
