package asad.ws; /**
 * Auteur    : Moret Jérôme
 * Date      : 16/05/2017
 * Version   : 1.0
 */
import javax.jws.*;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import java.util.List;

@WebService
public interface ICommentsService {
    boolean addComment(Comment comment);
    List<Comment> getComments();
    String deleteComment(Comment comment);
}
