package com.xzr.onlinelibrary.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author xzr
 * @since 2019-08-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Book对象", description="")
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "前端显示的界面")
    private String newBookName;

    @ApiModelProperty(value = "书籍名称")
    private String bookName;

    @ApiModelProperty(value = "文件名称")
    private String fileName;

    @ApiModelProperty(value = "类别")
    private String category;

    @ApiModelProperty(value = "书籍格式")
    private String format;

    @ApiModelProperty(value = "出版社")
    private String publishingHouse;

    @ApiModelProperty(value = "下载链接")
    private String downloadLink;

    @ApiModelProperty(value = "下载密码")
    private String downloadPassword;

    @ApiModelProperty(value = "书籍封面图片存放路径")
    private String bookImgPath;

    @ApiModelProperty(value = "书籍存放路径")
    private String bookPath;

    @ApiModelProperty(value = "保存时间")
    private LocalDateTime holdTime;

    @ApiModelProperty(value = "点击量")
    private Long clickRate;

    @ApiModelProperty(value = "下载量")
    private Long downloadCount;

    @ApiModelProperty(value = "作者")
    private String author;

    @ApiModelProperty(value = "资源是否有效 0（无效） 1（有效）")
    private Integer bookStatus;

    @ApiModelProperty(value = "备注")
    private String bookDescribe;

    @ApiModelProperty(value = "文件大小")
    private String bookSize;


}
