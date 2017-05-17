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

@WebService(endpointInterface= "asad.ws.ICommentsService")
public class CommentsService implements ICommentsService {
    List<Comment> comments = new ArrayList<Comment>();

    public boolean addComment(Comment comment) {
        return comments.add(comment);
    }

    public List<Comment> getComments() {
        return comments;
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
