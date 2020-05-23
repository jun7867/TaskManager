package user.management.oodp;

import javax.swing.JFrame;
import group.management.oodp.Menu;
 
public class Initial{
    static Login login;
    Menu menu;
    //UserDTO user = new UserDTO();
   
    public static void main(String[] args) {
        Initial main = new Initial();
        main.login = login.getInstance();
        main.login.setMain(main);
    }
   
    public void gotoMenu(UserDTO user){
        login.dispose();
        this.menu = new Menu();
        menu.screen(user);
    }
 
}
