package com.xzr.onlinelibrary.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author :肖钊容
 * @date :2019-06-27 11:51
 * @description :下载记录
 */

@Data
@TableName("download_record")
public class DownloadRecord {
    @ApiModelProperty(value = "订单id不用传")
    private Integer dId;
    private Integer userFk;
    private Integer bookFk;
    @ApiModelProperty(value = "保存时间不用传")
    private String saveDate;

    @ApiModelProperty("下载的书籍信息")
    private Book book;
    @ApiModelProperty("下载记录的用户信息")
    private User user;
}
