package group.management.oodp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import user.management.oodp.UserDTO;

public class Menu {
	
	public void screen(UserDTO user, String groupName) {
		JFrame f = new JFrame();
		f.setSize(400, 400);
		f.setVisible(true);
		
		JLabel welcome = new JLabel(user.getName()+"님, 현재 "+ groupName +"에 접속해있습니다.");
		f.add(welcome, BorderLayout.CENTER);
	}
}
