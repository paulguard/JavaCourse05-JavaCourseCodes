package com.pxd.javacoursecodes.w7.aop;

import com.pxd.javacoursecodes.w7.annotation.ReadOnly;
import com.pxd.javacoursecodes.w7.config.DataSourceNames;
import com.pxd.javacoursecodes.w7.config.DynamicDataSource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;

import java.lang.reflect.Method;

@Slf4j
//@Component
//@Aspect
public class DataSourceAspect implements Ordered {

    public DataSourceAspect() {
        log.error("Construct Aspect");
    }

    @Pointcut("@annotation(com.pxd.javacoursecodes.w7.annotation.ReadOnly)")
    public void dataSOurcePointCut(){
    }

    @Around("dataSOurcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {

        log.error("enter around");

        MethodSignature signature = (MethodSignature)point.getSignature();
        Method method = signature.getMethod();

        ReadOnly annotation = method.getAnnotation(ReadOnly.class);
        if (annotation == null) {
            DynamicDataSource.setDataSource(DataSourceNames.FIRST);
            log.error("select the first datasource");
        } else {
            DynamicDataSource.setDataSource(DataSourceNames.SECOND);
            log.error("select the second datasource");
        }

        try {
            return point.proceed();
        } finally {
            DynamicDataSource.clearDataSource();
        }

    }

    @Override
    public int getOrder() {
        return 1;
    }
}
