package asad.ws; /**
 * Auteur    : Moret Jérôme
 * Date      : 16/05/2017
 * Version   : 1.0
 */

import javax.xml.ws.Endpoint;

public class CommentsServiceStarter {
    final static String URL = "http://localhost:8001/comments";
    public static void main(String[] args) {
        Endpoint.publish(URL, new CommentsService());
        System.out.println("Service web démarre url " + URL);
    }
}
