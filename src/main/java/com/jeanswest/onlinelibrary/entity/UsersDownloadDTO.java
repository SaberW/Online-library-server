package com.jeanswest.onlinelibrary.entity;

import lombok.Data;

import java.util.List;

/**
 * @author :肖钊容
 * @date :2019-06-29 10:34
 * @description :用户下载
 */
@Data
public class UsersDownloadDTO extends UserDTO{
    private List<DownloadRecordDTO> downloadRecords;
}
