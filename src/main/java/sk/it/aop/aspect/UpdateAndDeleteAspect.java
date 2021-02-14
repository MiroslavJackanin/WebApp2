package sk.it.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(6)
@Component
public class UpdateAndDeleteAspect {

    @After("AopExpressions.forDaoDeleteOrUpdate()")
    public void afterDeleteOrUpdate(JoinPoint joinPoint) {
        System.out.println("\n====>>> DATABASE ALTERED <<<<====\n");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);
    }
}
