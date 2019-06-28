package com.jeanswest.onlinelibrary.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("书籍模型")
public class BookDTO {
    @ApiModelProperty(value="id会自动生成 可不加",name="status",example = "0")
    private Long id ;

    @ApiModelProperty(value="资源是否有效 0（无效） 1（有效）",name="status",example="1")
	private Integer status ;

    @ApiModelProperty(value="作者",name="author",example="admin")
	private String author ;

    @ApiModelProperty(value="书籍名称",name="bookName",example="你不知道的JS")
	private String bookName ;

    @ApiModelProperty(value="类别",name="category",example="编程")
	private String category ;

    @ApiModelProperty(value="点击量",name="clickRate",example="100")
    private Long clickRate ;

    @ApiModelProperty(value="书籍描述信息",name="status",example="测试测试")
    private String describe ;

    @ApiModelProperty(value="下载量",name="downloadCount",example="10")
    private Long downloadCount ;

    @ApiModelProperty(value="下载链接",name="downloadLink",example="http://.1234")
    private String downloadLink ;

    @ApiModelProperty(value="下载密码",name="downloadPassword",example="12345")
    private String downloadPassword ;

    @ApiModelProperty(value="出版社",name="publishingHouse",example="机械出版社")
    private String publishingHouse ;

    @ApiModelProperty(value="资源保存时间",name="holdTime",example="2019-06-11 22:34:30")
    private String holdTime ;

}
