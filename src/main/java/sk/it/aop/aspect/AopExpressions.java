package sk.it.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution(* sk.it.dao.CustomerDAOImpl.get*(..))")
    public void forDaoGetCustomers() {}

    @Pointcut("execution(* sk.it.dao.CustomerDAOImpl.saveCustomer(..))")
    public void forDaoSaveCustomer() {}

    @Pointcut("execution(* sk.it.dao.CustomerDAOImpl.deleteCustomer(..))")
    public void forDaoDeleteCustomer() {}

    @Pointcut("forDaoDeleteCustomer() || forDaoSaveCustomer()")
    public void forDaoDeleteOrUpdate() {}

    @Pointcut("execution(* sk.it.dao.CustomerDAOImpl.getCustomer(..))")
    public void forDaoGetCustomer() {}
}
