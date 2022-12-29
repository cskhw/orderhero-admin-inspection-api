#!/bin/bash

cd /home/ec2-user/orderhero-admin-inspection-api

LOGDIR="./logs"
ORIGINLOGFILENAME="access.log"
LOGFILENAME="access.$(date +"%Y-%m-%d").log"

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
