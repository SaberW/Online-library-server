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

    public List<DownloadRecordDTO> getDownloadList(){
     List <DownloadRecordDTO> downloadRecordDTOList = downloadRecordMapper.selectList(null);
     return downloadRecordDTOList;
    }

    public Object getDownloadListByUserID(Integer userId) {
      return "null";
    }

    public Object saveDownloadRecord(DownloadRecordDTO downloadRecordDTO) {
        return downloadRecordMapper.insert(downloadRecordDTO);
    }
}
