package asad.ws; /**
 * Auteur    : Moret Jérôme
 * Date      : 16/05/2017
 * Version   : 1.0
 */

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@WebService(endpointInterface= "asad.ws.ICommentsService")
public class CommentsService implements ICommentsService {
    List<Comment> comments = new ArrayList<Comment>();

    public boolean addComment(Comment comment) {
        return comments.add(comment);
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<Comment> getCommentsForSubject(String subject) {
        List<Comment> commentsFiltred = new ArrayList<Comment>();
        for (Comment comment: comments) {
            if (Objects.equals(comment.getSubject(), subject)) {
                commentsFiltred.add(comment);
            }
        }
        return commentsFiltred;
    }


    public String deleteComment(Comment comment) {
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
