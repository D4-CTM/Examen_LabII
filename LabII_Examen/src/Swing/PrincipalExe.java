package Swing;

import Logica.UberSocial;

public class PrincipalExe {
    
    public static void main(String[] args) {
        UberSocial Social = new UberSocial();
        new Log_In(Social).setVisible(true);
    }

}
