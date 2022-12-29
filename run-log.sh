#!/bin/bash

cd /home/ec2-user/orderhero-admin-inspection-api

# 실행중인 blue가 있는지
EXIST_BLUE=$(docker ps | grep spring-blue)

DOCKER_APP_NAME=spring
LOGDIR="./logs"
ORIGINLOGFILENAME="access.log"
LOGFILENAME="access.$(date +"%Y-%m-%d").log"

# green이 실행 중이면
if [ -z "$EXIST_BLUE" ]; then
	echo "logging on $DOCKER_APP_NAME-green with crontab"
	docker exec -it $DOCKER_APP_NAME-green /bin/bash
	logging
	exit
else
	echo "logging on $DOCKER_APP_NAME-blue with crontab"
	docker exec -it $DOCKER_APP_NAME-blue /bin/bash
	logging
	exit
fi

sleep 100
