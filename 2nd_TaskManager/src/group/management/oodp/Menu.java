package group.management.oodp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import task.management.oodp.TaskMenu;
import schedule.management.oodp.ScheduleMenu;
import user.management.oodp.UserDTO;

public class Menu {
	
	public void screen(UserDTO user, GroupDTO group) {
		JFrame f = new JFrame();
		f.setSize(400, 400);
		f.setVisible(true);
		f.setTitle(group.getName()+" Home");
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		
		
		JLabel welcome = new JLabel(user.getName()+"님, 현재 "+ group.getName() +"에 접속해있습니다.");
		f.add(welcome, BorderLayout.CENTER);
		System.out.println("Host : "+group.getHostName()+"\nMember");
		for(int i=0; i<group.getNum()-1; i++)
			System.out.println(group.getMemberName(i));
		
		JButton j1 = new JButton("업무 관리");
		buttonPanel.add(j1);
		//j1.setBounds(150, 330, 80, 30);
		
		JButton j2 = new JButton("스케줄 관리");
		buttonPanel.add(j2);
		//j2.setBounds(250, 330, 80, 30);
		

		f.add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setVisible(true);
	
	
		
		j1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TaskMenu taskMenu=new TaskMenu();
				taskMenu.screen(user, group);
				
			}
			
		});
		
		j2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ScheduleMenu sMenu=new ScheduleMenu();
				sMenu.screen(user, group);
				
			}
			
		});
	}
	
	//Template method Design Pattern : https://jdm.kr/blog/116
	
}
