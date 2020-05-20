package user.management.oodp;

import javax.swing.JFrame;
import group.management.oodp.Menu;
 
public class Initial{
    Login login;
    Menu menu;
   
    public static void main(String[] args) {
        Initial main = new Initial();
        main.login = new Login();
        main.login.setMain(main);
    }
   
    public void gotoMenu(){
        login.dispose();
        this.menu = new Menu();
    }
 
}
