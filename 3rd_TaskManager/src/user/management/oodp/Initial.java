package user.management.oodp;

import java.awt.Font;

import javax.swing.JFrame;
import group.management.oodp.ManageGroup;
 
public class Initial{
    static Login login;
    ManageGroup menu;
   
    public static void main(String[] args) {
        Initial main = new Initial();
        main.login = login.getInstance();
        main.login.setMain(main);
    }
   
    public void gotoMenu(UserDTO user){
        login.dispose();
        this.menu = new ManageGroup();
        Font f1 = new Font("돋움",Font.PLAIN,12);
        menu.screen(user, f1);
    }
 
}
