package sk.it.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sk.it.entity.Customer;

@Aspect
@Order(3)
@Component
public class SaveAspect {

    @After("AopExpressions.forDaoSaveCustomer()")
    public void afterDaoSaveCustomersMethod(JoinPoint joinPoint) {
        System.out.println("\n====>>>> afterDaoSaveCustomersMethod <<<<=====\n");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);
    }

    @Before("AopExpressions.forDaoSaveCustomer()")
    public void beforeDaoSaveCustomerMethod(JoinPoint joinPoint) {
        System.out.println("\n====>>>> beforeDaoSaveCustomersMethod <<<<=====\n");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        Object[] args = joinPoint.getArgs();
        for (Object tempArg : args) {
            if (tempArg instanceof Customer) {
                Customer customer = (Customer) tempArg;
                System.out.println("CUSTOMER SAVED");
                System.out.println("name: " + customer.getFirstName() + ", " + customer.getLastName());
            }
        }
    }
}
