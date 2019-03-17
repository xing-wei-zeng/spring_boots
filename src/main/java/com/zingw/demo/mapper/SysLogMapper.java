package com.zingw.demo.mapper;

import com.zingw.demo.pojo.SysLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zxw
 * @Desriiption:
 */
@Mapper
public interface SysLogMapper {
    void addLog(SysLog sysLog);
}
