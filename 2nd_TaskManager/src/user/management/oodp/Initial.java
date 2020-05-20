package user.management.oodp;

import javax.swing.JFrame;
import group.management.oodp.Menu;
 
public class Initial{
    Login login;
    Menu menu;
   
    public static void main(String[] args) {
       
        // 메인클래스 실행
        Initial main = new Initial();
        main.login = new Login(); // 로그인창 보이기
        main.login.setMain(main); // 로그인창에게 메인 클래스보내기
    }
   
    // 테스트프레임창
    public void showFrameTest(){
        login.dispose(); // 로그인창닫기
        this.menu = new Menu(); // 테스트프레임 오픈
    }
 
}