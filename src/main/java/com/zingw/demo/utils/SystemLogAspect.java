package com.zingw.demo.utils;

import com.zingw.demo.controller.SystemControllerLog;
import com.zingw.demo.pojo.Movies;
import com.zingw.demo.pojo.SysLog;
import com.zingw.demo.service.SaveLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zxw
 * @Desriiption:
 */
@Aspect
@Component
@SuppressWarnings("all")
public class SystemLogAspect {
    @Resource
    private SaveLogService saveLogService;
    private static final Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);
    //Controller层切点
    @Pointcut("@annotation(com.zingw.demo.controller.SystemControllerLog)")
    public void controllerAspect(){
    }
    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint){
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
       // Movies movies = (Movies) session.getAttribute("id");
        String strid = request.getParameter("id");
        Integer id = Integer.valueOf(strid);
        String ip = IpUtil.getIPAddress(request);
        try{
            SysLog sysLog = new SysLog();
            Date date = new Date();
            //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            sysLog.setDescription(getControllerMethodDescription(joinPoint));
            sysLog.setType("0");
            sysLog.setIp(ip);
            sysLog.setMovieid(id);
            sysLog.setTime(date);

            saveLogService.addLog(sysLog);
        }catch (Exception e){
            logger.error("异常信息：{}",e.getMessage());
        }
    }

    private String getControllerMethodDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        //反射
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for(Method method : methods){
            if(method.getName().equals(methodName)){
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length==arguments.length){
                    description = method.getAnnotation(SystemControllerLog.class).description();
                    break;
                }
            }
        }
        return description;
    }
}
