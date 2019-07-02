package com.jeanswest.onlinelibrary.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jeanswest.onlinelibrary.entity.DemoDTO;
import com.jeanswest.onlinelibrary.entity.DownloadRecordDTO;

import java.util.List;

/**
 * @author :肖钊容
 * @date :2019-06-27 14:08
 * @description :书籍下载记录
 */
public interface DownloadRecordMapper extends BaseMapper<DownloadRecordDTO> {
   List<DemoDTO> getDownload(Integer userId);
}
