package com.jeanswest.onlinelibrary.service;

import com.jeanswest.onlinelibrary.entity.DownloadRecordDTO;
import com.jeanswest.onlinelibrary.mapper.DownloadRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :肖钊容
 * @date :2019-06-27 14:35
 * @description :
 */

@Service
public class DownloadRecordService {

    @Autowired
    DownloadRecordMapper downloadRecordMapper;

    public void test1(){
     List <DownloadRecordDTO> list = downloadRecordMapper.selectList(null);
     System.out.println(list);
    }
}
