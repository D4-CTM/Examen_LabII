package Logica;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UberSocial {
    static ArrayList<SocialClass> clases=new ArrayList<>();
    
    public String buscar(String username, int indice, int friendsIndex){
        if(username.equals(clases.get(indice).Username)){
            return username;
        }else{
            if(indice<clases.size()){
                try {
                    if (friendsIndex < clases.get(indice).Friends.get(friendsIndex).length()){
                        return username;
                    } else return buscar(username,indice, friendsIndex + 1);
                } catch (Exception Ex){
                    return buscar(username, indice + 1, 0);
                }
            }
        }
        return null;
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
        }
    }
    
    
}