echo "logging"

# 폴더 만들어줌
if ! [ -d $LOGDIR ]; then
    mkdir $LOGDIR
fi

# 원본 로그 파일 생성
if ! [ -e $LOGDIR/$ORIGINLOGFILENAME ]; then
    touch $LOGDIR/$ORIGINLOGFILENAME
    chmod 777 $LOGDIR/$LOGFILENAME
fi

# 날짜 로그 파일 생성
if ! [ -e $LOGDIR/$LOGFILENAME ]; then
    \cp -f $LOGDIR/$ORIGINLOGFILENAME $LOGDIR/$LOGFILENAME
    chmod 777 $LOGDIR/$LOGFILENAME
    cat /dev/null >$LOGDIR/$ORIGINLOGFILENAME
fi

# 31일 초과한 파일들 삭제
find $LOGDIR/ -mtime +30 -delete
