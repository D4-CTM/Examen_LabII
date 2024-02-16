package Logica;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UberSocial {
    ArrayList<SocialClass> clases=new ArrayList<>();
    private String LogedIn;
    
    public String buscar(String username, int indice, int friendsIndex){
        if(username.equals(clases.get(indice).Username)){
            LogedIn = username;
            return username;
        }else{
            if(indice<clases.size()){
                try {
                    if (friendsIndex < clases.get(indice).Friends.get(friendsIndex).length()){
                        LogedIn = username;
                        return username;
                    } else return buscar(username,indice, friendsIndex + 1);
                } catch (Exception Ex){
                    return buscar(username, indice + 1, 0);
                }
            }
        }
        return "No ha encontrado el usuario";
    }
    
    public void agregarCuenta(String username, String tipo, boolean Crear){
        for (SocialClass Cuentas : clases){
            if (Cuentas.Friends.contains(username)){
                Crear = false;
            }
            if (Cuentas.Username.equals(username)){
                Crear = false;
            }
        }
        if (Crear){
            switch (tipo){
                case "FACEBOOK" -> clases.add(new Facebook(username));
                default -> clases.add(new Twitter(username));
            }
            JOptionPane.showMessageDialog(null, "Cuenta creada con exito!");
        } else JOptionPane.showMessageDialog(null, "Ya existe dicho nombre de usuario!");
    }
    
    public void AgregarPost(String username, String Post){
        for (SocialClass Cuenta : clases){
            if (Cuenta.Username.equals(username)){
                Cuenta.addPost(Post);
            }
        }
    }
    
    public boolean AgregarAmigo(String User1, String User2){
        for (SocialClass Cuenta : clases){
            if (Cuenta.Username.equals(User1)){
                for (SocialClass CuentaExiste : clases){
                    if (CuentaExiste instanceof Facebook && Cuenta instanceof Facebook){
                        Cuenta.addFriends(User2);
                        return true;
                    } else if (CuentaExiste instanceof Twitter && Cuenta instanceof Twitter){
                        Cuenta.addFriends(User2);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public void AgregarComentario(String user, int postID, String autor, String comment){
        
    }
    
    
}