/**
 * Auteur    : Moret Jérôme
 * Date      : 24/05/2017
 * Version   : 1.0
 */
package asad.aspect;

import asad.ws.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect
public class LoginAspect {

    private IAuthentificationService authentificationService = new SimpleAuthentificationService();

    @Around("execution(* asad.ws.CommentsService.addComment(..))")
    public Object addCommentAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs(); // change the args if you want to
        User user = (User) args[1];
        Object retVal;
        if(authentificationService.IsValid(user.getLogin(), user.getPass())) {
            retVal = joinPoint.proceed(args); // run the actual method (or don't)
        } else {
            retVal = false;
        }
        return retVal;
    }
}
