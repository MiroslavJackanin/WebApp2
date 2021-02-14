package sk.it.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sk.it.entity.Customer;

@Aspect
@Order(4)
@Component
public class GetterAspect {

    @Before("AopExpressions.forDaoGetCustomers()")
    public void beforeDaoGetCustomersMethod(JoinPoint joinPoint) {
        System.out.println("\n====>>>> beforeDaoGetCustomersMethod <<<<=====\n");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        Object[] args = joinPoint.getArgs();
        for (Object tempArg : args) {
            System.out.println(tempArg);

            if (tempArg instanceof Customer) {
                Customer customer = (Customer) tempArg;
                System.out.println(customer.getFirstName());
                System.out.println(customer.getLastName());
            }
        }
    }

    @AfterReturning(
            pointcut = "AopExpressions.forDaoGetCustomer()",
            returning = "customer"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, Customer customer) {
        System.out.println("\n====>>>> afterReturningDaoGetCustomerMethod <<<<=====\n");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        System.out.println("Result: " + customer.getFirstName() + ", " + customer.getLastName());
    }
}
