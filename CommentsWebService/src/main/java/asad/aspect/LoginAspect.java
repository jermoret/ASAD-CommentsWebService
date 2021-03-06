/**
 * Auteur    : Moret Jérôme
 * Date      : 24/05/2017
 * Version   : 1.0
 */
package asad.aspect;

import asad.ws.Comment;
import asad.ws.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Aspect
public class LoginAspect {

    private IAuthentificationService authentificationService = new SimpleAuthentificationService();

    @Around("execution(* asad.ws.CommentsService.addComment(..))")
    public Object addCommentAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs(); // change the args if you want to
        Comment comment = (Comment) args[1];
        User user = (User) args[0];
        Object retVal;
        if(isUserValid(user) && user.getLogin().equals(comment.getPseudo())) {
            retVal = joinPoint.proceed(args); // run the actual method (or don't)
        } else {
            retVal = false;
        }
        return retVal;
    }

    @Around("execution(* asad.ws.CommentsService.deleteComment(..))")
    public Object deleteCommentAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs(); // change the args if you want to
        User user = (User) args[0];
        Comment comment = (Comment) args[1];

        Object retVal;
        if(isUserValid(user)) {
            if(comment.getPseudo().equals(user.getLogin()))
                retVal = joinPoint.proceed(args); // run the actual method (or don't)
            else
                retVal = "You can't delete a comment that dosen't belong to you";
        } else {
            retVal = "You must give the correct credentials to delete a comment";
        }
        return retVal;
    }
    
    @Around("execution(* asad.ws.CommentsService.getComments(..))")
    public Object getCommentsAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        User user = (User) args[0];
        List<Comment> comments = null;
        if(!isUserValid(user)) {
            List<Comment> commentList = (List<Comment>) joinPoint.proceed(args);
            comments = new ArrayList<Comment>();
            for(Comment comment : commentList) {
                comments.add(new Comment("", comment.getSubject(), ""));
            }
        } else {
            comments = (List<Comment>) joinPoint.proceed(args);
        }
        return comments;
    }

    @Around("execution(* asad.ws.CommentsService.getCommentsForSubject(..))")
    public Object getCommentsForSubject(ProceedingJoinPoint joinPoint) throws Throwable {
        return getCommentsAround(joinPoint);
    }

    private Boolean isUserValid(User user) {
        return user != null && authentificationService.IsValid(user.getLogin(), user.getPass());
    }
}
