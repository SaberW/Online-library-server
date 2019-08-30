package com.xzr.onlinelibrary.mapper;

import com.xzr.onlinelibrary.entity.DownloadRecord;

import java.util.List;

/**
 * @author :肖钊容
 * @version :1.0.0
 * @date :2019/8/29
 * @description :下载记录
 */
public interface DownloadRecordMapper {
    public List<DownloadRecord> getDownloadRecordByUserId(Integer userId);

    public List<DownloadRecord> getDownloadRecord();
}
