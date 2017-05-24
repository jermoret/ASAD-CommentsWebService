/**
 * Auteur    : Moret Jérôme
 * Date      : 24/05/2017
 * Version   : 1.0
 */
package asad.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect
public class LoginAspect {

    @Around("execution(* asad.ws.CommentsService.addComment(..))")
    public Object addCommentAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs(); // change the args if you want to
        Object retVal = joinPoint.proceed(args); // run the actual method (or don't)
        System.out.println("Return object : " + retVal);
        return retVal; // return the return value (or something else)
    }

    @Around("execution(* asad.ws.CommentsService.deleteComment(..))")
    public Object deleteCommentAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs(); // change the args if you want to
        Object retVal = joinPoint.proceed(args); // run the actual method (or don't)
        System.out.println("Return object : " + retVal);
        return retVal; // return the return value (or something else)
    }
}
