package com.wyl.research.validUser;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/5/25
 */
@Aspect
@Component
public class ParamValidAspect {

    public ParamValidAspect() {
        System.out.println("ParamValidAspect创建了.....");
    }

    @Pointcut("@annotation(com.wyl.research.validUser.ValidAnno) ")
    public void pointCut() {

    }


    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {

        Object[] args = joinPoint.getArgs();
        for (Object object : args) {
            Field[] fields = object.getClass().getDeclaredFields();

            for (Field field : fields) {
                field.setAccessible(true);

                if (field.isAnnotationPresent(NotNull.class)) {
                    NotNull annotation = field.getAnnotation(NotNull.class);
                    System.out.println(annotation);

                    Object o = null;
                    try {
                        o = field.get(object);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                    if (o == null) {
                        throw new BusinessException(ResponseEnum.USER_NAME_ISNULL);
//                        throw new RuntimeException("用户名不能为空...");
                    }
                    if (String.valueOf(o).length() < 5) {
                        throw new BusinessException(ResponseEnum.USER_NAME_ISVALID);
//                        throw new RuntimeException("用户名长度不能小于5...");
                    }

                }


            }
        }

    }


//    @Around("pointCut()")
//    public Object before(ProceedingJoinPoint joinPoint) throws Throwable {
//
//        Object[] args = joinPoint.getArgs();
//        for (Object object : args) {
//            Field[] fields = object.getClass().getDeclaredFields();
//
//            for (Field field : fields) {
//                field.setAccessible(true);
//
//                if (field.isAnnotationPresent(NotNull.class)) {
//                    NotNull annotation = field.getAnnotation(NotNull.class);
//                    System.out.println(annotation);
//
//                    Object o = null;
//                    try {
//                        o = field.get(object);
//                    } catch (IllegalAccessException e) {
//                        e.printStackTrace();
//                    }
//
//                    if (o == null) {
////                        throw new BusinessException(ResponseEnum.USER_NAME_ISNULL);
//                        throw new RuntimeException("用户名不能为空...");
//                    }
//                    if (String.valueOf(o).length() < 5) {
////                        throw new BusinessException(ResponseEnum.USER_NAME_ISNULL);
//                        throw new RuntimeException("length can not below 5...");
//                    }
//
//                }
//
//
//            }
//        }
//        return joinPoint.proceed();
//    }

}