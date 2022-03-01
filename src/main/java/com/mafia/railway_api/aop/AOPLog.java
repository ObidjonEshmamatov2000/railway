package com.mafia.railway_api.aop;

import com.mafia.railway_api.entity.log.LoggingEntity;
import com.mafia.railway_api.repository.LoggingRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPLog {
    @Autowired
    private LoggingRepository loggingRepository;

    @Pointcut("execution(* com.mafia.railway_api.entity.*.*(..))")
    public void addEntityLog(){}

    @Pointcut("execution(* com.mafia.railway_api.service.*.*(..))")
    public void addServiceLog(){}

    @Pointcut("execution(* com.mafia.railway_api.controller.*.*(..))")
    public void addControllerLog(){}

    @Pointcut("execution(* com.mafia.railway_api.exception.*.*(..))")
    public void addExceptionLog(){}


    @AfterReturning("addEntityLog() || addServiceLog() || addControllerLog() || addExceptionLog()")
    public void performLogging(JoinPoint joinPoint) {
        MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();
        LoggingEntity loggingEntity = new LoggingEntity();
        loggingEntity.setMessage(methodSig.toShortString());
        loggingRepository.save(loggingEntity);
    }
}
