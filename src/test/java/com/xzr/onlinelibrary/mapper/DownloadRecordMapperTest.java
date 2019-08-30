package com.xzr.onlinelibrary.mapper;

import com.xzr.onlinelibrary.entity.DownloadRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DownloadRecordMapperTest {

    @Autowired
    DownloadRecordMapper downloadRecordMapper;

    @Test
    public void getDownloadRecord() {
        List<DownloadRecord> downloadRecords = downloadRecordMapper.getDownloadRecord();
        for (DownloadRecord downloadRecord : downloadRecords) {
            System.out.println(downloadRecord);
        }
    }

    @Test
    public void getDownloadRecordByUserId(){
       List <DownloadRecord> downloadRecords = downloadRecordMapper.getDownloadRecordByUserId(1);
        System.out.println(downloadRecords);
    }
}