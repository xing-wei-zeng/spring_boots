package com.zingw.demo.service.impl;

import com.zingw.demo.mapper.SysLogMapper;
import com.zingw.demo.pojo.SysLog;
import com.zingw.demo.service.SaveLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zxw
 * @Desriiption:
 */
@Service
public class SaveLogServiceImpl implements SaveLogService {
    @Autowired
    private SysLogMapper sysLogMapper;
    @Override
    public SysLog addLog(SysLog sysLog) {
        sysLogMapper.addLog(sysLog);
        return sysLog;
    }
}
