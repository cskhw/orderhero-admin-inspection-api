package com.deliverylab.inspection.kafka.listeners;

import lombok.extern.slf4j.Slf4j;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.deliverylab.inspection.common.utils.FileUtils;
import com.deliverylab.inspection.kafka.messages.LogMessage;
import com.deliverylab.inspection.models.Log;
import com.deliverylab.inspection.models.enums.EAction;

@Slf4j
@Service
public class LogListener {
    @KafkaListener(topics = "log", containerFactory = "logKafkaListenerContainerFactory")
    public void newLogListener(LogMessage msg) throws Exception {
        log.info("Get request from Front 'save log'" + msg.toString());
        Log logData = msg.getLog();
        EAction action = msg.getAction();

        // 로그 스트링 만들고 파일에 add
        if (action == EAction.CREATE) {
            String logStr = logData.toString();
            FileUtils.addFileWriter("./logs", "access.log", logStr);
        }
    }
}