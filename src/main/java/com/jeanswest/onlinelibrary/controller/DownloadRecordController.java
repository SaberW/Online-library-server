package com.jeanswest.onlinelibrary.controller;

import com.jeanswest.onlinelibrary.entity.DownloadRecordDTO;
import com.jeanswest.onlinelibrary.entity.ResultData;
import com.jeanswest.onlinelibrary.service.DownloadRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author :肖钊容
 * @date :2019-06-27 14:39
 * @description : 下载记录相关操作
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/DownloadRecords/")
@RestController
@Api(tags = "下载记录相关接口")
public class DownloadRecordController  {

    @Autowired
    DownloadRecordService downloadRecordService;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    @ApiOperation("下载书籍")
    @PostMapping("")
    public ResultData saveDownloadRecord(@RequestBody DownloadRecordDTO downloadRecordDTO) {
        try {
            downloadRecordDTO.setSaveDate(simpleDateFormat.format(new Date()));
            downloadRecordDTO.setDid(null);
            downloadRecordService.saveDownloadRecord(downloadRecordDTO);
            return ResultData.success("添加成功");
        } catch (Exception e) {
            return ResultData.error("请求失败", e.getMessage());
        }
    }

    @ApiOperation("获取所有所有用户的下载记录")
    @GetMapping()
    public ResultData getDownloadList() {
        try {
            return ResultData.success("请求成功", downloadRecordService.getDownloadList());
        } catch (Exception e) {
            return ResultData.error("请求失败", e.getMessage());
        }
    }

    @ApiOperation("根据用户Id获取下载记录")
    @GetMapping("{userId}")
    public Object getDownloadListByUserId(@PathVariable Integer userId) {
        try {
            return ResultData.success("请求成功", downloadRecordService.getDownloadListByUserID(userId));
        } catch (Exception e) {
            return ResultData.error("请求失败", e.getMessage());
        }
    }

}
