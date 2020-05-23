package user.management.oodp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import user.management.oodp.SignUpCheck;
import user.management.oodp.SignUp;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
 
public class Login extends JFrame{
    private Initial main;
    private JButton btnLogin;
    private JButton btnSignUp;
    private JPasswordField passText;
    private JTextField userText;
    private boolean isloginChecked;
 
    public Login() {
        setTitle("login");
        setSize(280, 150);
        setResizable(false);
        setLocation(800, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       
        JPanel panel = new JPanel();
        placeLoginPanel(panel);
       
        add(panel);
       
        setVisible(true);
    }
   
    public void placeLoginPanel(JPanel panel){
        panel.setLayout(null);     
        JLabel userLabel = new JLabel("ID");
        userLabel.setBounds(10, 10, 80, 25);
        panel.add(userLabel);
       
        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(10, 40, 80, 25);
        panel.add(passLabel);
       
        userText = new JTextField(20);
        userText.setBounds(100, 10, 160, 25);
        panel.add(userText);
       
        passText = new JPasswordField(20);
        passText.setBounds(100, 40, 160, 25);
        panel.add(passText);
        passText.addActionListener(new ActionListener() {          
            @Override
            public void actionPerformed(ActionEvent e) {
                isLoginCheck();        
            }
        });
       
        btnSignUp = new JButton("Sign Up");
        btnSignUp.setBounds(10, 80, 100, 25);
        panel.add(btnSignUp);
        btnSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	SignUp signUp = new SignUp();
            	try {
					signUp.SingUp();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
       
        btnLogin = new JButton("Login");
        btnLogin.setBounds(160, 80, 100, 25);
        panel.add(btnLogin);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isLoginCheck();
            }
        });
    }
   
    public void isLoginCheck(){
    	try {
    		String str;
    		String[] array;
    		boolean isLoginSucceed = false;
    		BufferedReader logbuff = new BufferedReader(new FileReader("user.txt"));
    		while((str=logbuff.readLine())!=null){
    			array=str.split("/");
    		if(userText.getText().equals(array[1]) && new String(passText.getPassword()).equals(array[2])) {
    			JOptionPane.showMessageDialog(null, "로그인 되었습니다.");
    			isLoginSucceed = true;
    			main.gotoMenu();
    			dispose();
    		}else {
    			continue;
    		}
    		}
    		if(!isLoginSucceed)
    			JOptionPane.showMessageDialog(null, "로그인 실패하였습니다.");
    		logbuff.close();
    	}catch (IOException E10) {
    		E10.printStackTrace();
    	}
    }
 
    public void setMain(Initial main) {
        this.main = main;
    }
 
    public boolean isLogin() {     
        return isloginChecked;
    }
 
}
