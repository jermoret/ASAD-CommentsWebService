/**
 * Auteur    : Moret Jérôme
 * Date      : 16/05/2017
 * Version   : 1.0
 */
package asad.ws;

public class Comment {
    private String pseudo;
    private String subject;
    private String comment;

    public Comment() {
    }

    public Comment(String pseudo, String subject, String comment) {
        this.pseudo = pseudo;
        this.subject = subject;
        this.comment = comment;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object obj) {
        Comment comment = (Comment)obj;
        return comment.getComment().equals(this.getComment()) &&
                comment.getPseudo().equals(this.getPseudo()) &&
                comment.getSubject().equals(this.getSubject());
    }
}
