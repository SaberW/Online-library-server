package com.jeanswest.onlinelibrary.controller;

import com.jeanswest.onlinelibrary.service.DownloadRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :肖钊容
 * @date :2019-06-27 14:39
 * @description :
 */
@RestController
public class DownloadRecordController {

    @Autowired
    DownloadRecordService downloadRecordService;

    @GetMapping("DownloadRecord")
    public void test1() {
        System.out.println("hi");
        downloadRecordService.test1();
    }
}
