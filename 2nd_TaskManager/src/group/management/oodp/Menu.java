package group.management.oodp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import user.management.oodp.UserDTO;

public class Menu {
	
	public void screen(UserDTO user, GroupDTO group) {
		JFrame f = new JFrame();
		f.setSize(400, 400);
		f.setVisible(true);
		
		JLabel welcome = new JLabel(user.getName()+"님, 현재 "+ group.getName() +"에 접속해있습니다.");
		f.add(welcome, BorderLayout.CENTER);
		System.out.println("Host : "+group.getHostName()+"\nMember");
		for(int i=0; i<group.getNum()-1; i++)
			System.out.println(group.getMemberName(i));
	}
	
	//Template method Design Pattern : https://jdm.kr/blog/116
	
}
