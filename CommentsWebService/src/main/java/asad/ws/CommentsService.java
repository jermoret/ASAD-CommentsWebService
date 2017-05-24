/**
 * Auteur    : Moret Jérôme
 * Date      : 16/05/2017
 * Version   : 1.0
 */

package asad.ws;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@WebService(endpointInterface= "asad.ws.ICommentsService")
public class CommentsService implements ICommentsService {
    List<Comment> comments = new ArrayList<Comment>();

    public boolean addComment(User user, Comment comment) {
        //System.out.println("Helllllo !");
        return comments.add(comment);
    }

    public List<Comment> getComments(User user) {
        return comments;
    }

    public List<Comment> getCommentsForSubject(User user, String subject) {
        List<Comment> commentsFiltred = new ArrayList<Comment>();
        for (Comment comment: comments) {
            if (Objects.equals(comment.getSubject(), subject)) {
                commentsFiltred.add(comment);
            }
        }
        return commentsFiltred;
    }


    public String deleteComment(User user, Comment comment) {
        boolean deleted = false;
        for (Iterator<Comment> iterator = comments.iterator(); iterator.hasNext();) {
            Comment retrievedComment = iterator.next();
            if (retrievedComment.equals(comment)) {
                iterator.remove();
                deleted = true;
            }
        }

        if(deleted)
            return "Comment(s) successfully deleted.";
        else
            return "Comment not found.";
    }
}
