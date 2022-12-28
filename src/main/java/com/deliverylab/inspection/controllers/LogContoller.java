package com.deliverylab.inspection.controllers;

import java.time.Instant;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliverylab.inspection.common.utils.FileUtils;
import com.deliverylab.inspection.models.Log;
import com.deliverylab.inspection.payload.request.log.CreateLogRequest;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/log")
public class LogContoller {

    @GetMapping("/check")
    public ResponseEntity<String> check() {
        return ResponseEntity.ok("Please use methods.");
    }

    // 로그 생성해서 로그 파일에 저장
    @PostMapping("/create")
    public ResponseEntity<?> createLog(@Valid @RequestBody CreateLogRequest createLogRequest) throws Exception {
        Log logData = new Log(
                createLogRequest.getMsg(),
                createLogRequest.getPath());

        String path = "path: [" + logData.getPath() + "] ";
        String date = "date: [" + Instant.now().toString() + "] ";
        String msg = "msg: [" + logData.getMsg() + "]";

        // 로그 저장할 포맷 만들어줌
        String logStr = path + date + msg + "; \n";

        FileUtils.addFileWriter("./logs", "access.log", logStr);

        return ResponseEntity.ok(logData);
    }

    // 로그 전부 읽어오기
    @GetMapping("/read")
    public ResponseEntity<String> readLog() throws Exception {
        String logsData = FileUtils.fileReader("./logs/access.log");

        return ResponseEntity.ok(logsData);
    }

    // 로그 뒤에서 부터 읽기
    @GetMapping("/tail/{offset}")
    public ResponseEntity<String> tailLog(@PathVariable int offset) throws Exception {
        String logsData = FileUtils.fileReaderOnTail("./logs/access.log", offset);

        return ResponseEntity.ok(logsData);
    }
}
