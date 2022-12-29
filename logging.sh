#!/bin/bash

cd /home/ec2-user/orderhero-admin-inspection-api

# 실행중인 blue가 있는지
EXIST_BLUE=$(docker ps | grep spring-blue)

DOCKER_APP_NAME=spring
LOGDIR="./logs"
ORIGINLOGFILENAME="access.log"
LOGFILENAME="access.$(date +"%Y-%m-%d").log"

logging() {
	# 폴더 만들어줌
	if ! [ -d $LOGDIR ]; then
		mkdir $LOGDIR
	fi

	# 파일 만들어주고 권한줌
	if ! [ -e $LOGDIR/$LOGFILENAME ]; then
		\cp -f $LOGDIR/$ORIGINLOGFILENAME $LOGDIR/$LOGFILENAME
		chmod 777 $LOGDIR/$LOGFILENAME
		cat /dev/null >$LOGDIR/$ORIGINLOGFILENAME
	fi

	# 31일 초과한 파일들 삭제
	find $LOGDIR/ -mtime +30 -delete
}

# green이 실행 중이면
if [ -z "$EXIST_BLUE" ]; then
	echo "crontab on $DOCKER_APP_NAME-green"
	docker exec -it $DOCKER_APP_NAME-green /bin/bash
	logging
else
	echo "crontab on $DOCKER_APP_NAME-blue"
	docker exec -it $DOCKER_APP_NAME-blue /bin/bash
	logging
fi

sleep 100
