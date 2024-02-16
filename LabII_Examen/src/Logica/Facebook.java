package Logica;

import java.util.ArrayList;

public class Facebook extends SocialClass implements Commentable {
    protected ArrayList<Comment> Comentarios;
    
    public Facebook(String Username) {
        super(Username);
        Comentarios = new ArrayList();
    }
    
    @Override
    public void TimeLine() {

    }

    @Override
    public boolean addComment(Comment Comment) {
        
        Comentarios.add(Comment)
    }
    
}
