/**
 * Auteur    : Moret Jérôme
 * Date      : 16/05/2017
 * Version   : 1.0
 */

package asad.ws;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface ICommentsService {
    boolean addComment(User user, Comment comment);
    List<Comment> getComments(User user);
    List<Comment> getCommentsForSubject(User user, String subject);
    String deleteComment(User user, Comment comment);
}
