package com.jeanswest.onlinelibrary.controller;

import com.jeanswest.onlinelibrary.service.DownloadRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :肖钊容
 * @date :2019-06-27 14:39
 * @description :
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Api(tags = "下载记录相关接口")
public class DownloadRecordController {

    @Autowired
    DownloadRecordService downloadRecordService;

    @ApiOperation("获取所有所有用户的下载记录")
    @GetMapping("/DownloadRecords")
    public Object getDownloadList() {
        return downloadRecordService.getDownloadList();
    }

    @ApiOperation("根据用户Id获取下载记录")
    @GetMapping("/DownloadRecords/{userId}")
    public Object getDownloadListByUserId(@PathVariable Integer userId){
        return downloadRecordService.getDownloadListByUserID(userId);
    }

}
