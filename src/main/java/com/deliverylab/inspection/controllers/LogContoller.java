package com.deliverylab.inspection.controllers;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliverylab.inspection.models.Log;
import com.deliverylab.inspection.payload.request.CreateLogRequest;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/dev/api/log")
public class LogContoller {
    private ArrayList<Log> logs = new ArrayList<Log>();

    @GetMapping("")
    public ResponseEntity<String> guide(){
        return ResponseEntity.ok("Please use methods.");
    }

    @PostMapping("/create")
    public ResponseEntity<?> createLog(@Valid @RequestBody CreateLogRequest createLogRequest){
        Log log = new Log(
            createLogRequest.getMsg(),
            createLogRequest.getPath());
        this.logs.add(log);
        return ResponseEntity.ok(log);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<?> readLog(@PathVariable Integer id) {
        // id로 로그 가져와서 리턴
        Log log = logs.stream().filter(l -> id.equals((l.getId()))).findAny().orElse(null);

        // log가 널이면 404
        if(log == null){
            return ResponseEntity
				.notFound().build();
        }

        // log가 있으면 보내줌
        return ResponseEntity.ok(log);
    }

    @GetMapping("/readall")
    public ResponseEntity<ArrayList<Log>> readAllLog(){
        return ResponseEntity.ok(this.logs);
    }
}
