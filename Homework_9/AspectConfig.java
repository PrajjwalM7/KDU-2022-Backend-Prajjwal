import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectConfig {

    @Pointcut("execution(public * add(..))")
    public void publicMethods() {
        System.out.println("A public method executed");
    }

    @Pointcut("execution(* *..print(double))")
    public void longArg() {
        System.out.println("Long arg printed");
    }

    @Pointcut("within(Calculator)")
    public void methodsWithinCalculator() {
        System.out.println("A calculator Method");
    }

    @Before("publicMethods()")
    public void beforeFunction(JoinPoint joinPoint) {
        System.out.println("Before : " + joinPoint.getSignature().getName());
    }

    @After("publicMethods()")
    public void afterFunction(JoinPoint joinPoint) {
        System.out.println("After : " + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "publicMethods()", returning = "result")
    public void afterReturnPublic(double result) {
        System.out.println("After Return " + result);
    }

    @AfterReturning(pointcut = "methodsWithinCalculator()", returning = "result")
    public void afterReturnCalculator(double result) {
        System.out.println("After Calculator Method Return " + result);
    }

    @Around("methodsWithinCalculator()")
    public double measureMethodExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        double result = (Double) pjp.proceed();
        return result;
    }
}
