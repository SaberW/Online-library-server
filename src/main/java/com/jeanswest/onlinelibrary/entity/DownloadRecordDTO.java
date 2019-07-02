package com.jeanswest.onlinelibrary.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author :肖钊容
 * @date :2019-06-27 11:51
 * @description :下载记录
 */

@Data
@TableName("download_record")
public class DownloadRecordDTO {
    private Integer did;
    private Integer userFk;
    private Integer bookFk;
    private String saveDate;
}
