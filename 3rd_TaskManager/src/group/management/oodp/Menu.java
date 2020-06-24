package group.management.oodp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import decorate.design.pattern.oodp.DecoName;
import decorate.design.pattern.oodp.JustName;
import decorate.design.pattern.oodp.IsLeaderTopping;
import decorate.design.pattern.oodp.InChargeTopping;
import task.management.oodp.TaskMenu;
import schedule.management.oodp.ScheduleMenu;
import meeting.management.oodp.MeetingMenu;
import user.management.oodp.UserDTO;
import visitor.design.pattern.oodp.*;

public class Menu {
	
	
	public void screen(UserDTO user, Group group, Color color, Font f1) {
		//그냥 이름 
		DecoName justName=new JustName();
		justName.setName(user.getName());
		
		//Decorate Pattern
		DecoName IsLeaderInChargeName = new IsLeaderTopping(new InChargeTopping(justName));
		
		JFrame f = new JFrame();
		f.getContentPane().setBackground(color);
		f.setSize(400, 400);
		f.setVisible(true);
		f.setTitle(group.getName()+" Home");
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		
		
		JLabel welcome = new JLabel("  "+IsLeaderInChargeName.getName()+"님, 현재 "+ group.getName() +"에 접속해있습니다.");
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
		
		JButton j3 = new JButton("회의 관리");
		buttonPanel.add(j3);
		
		//Visitor Pattern
		int member = Client.calculate(group);
		JLabel showMember = new JLabel("그룹 멤버 수: "+member);
		f.add(showMember, BorderLayout.NORTH);

		f.add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setVisible(true);
		welcome.setFont(f1);
		j1.setFont(f1);
		j2.setFont(f1);
		j3.setFont(f1);
	
		
		j1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TaskMenu taskMenu=new TaskMenu();
				taskMenu.screen(user, group, color, f1);
				
			}
			
		});
		
		j2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ScheduleMenu sMenu=new ScheduleMenu();
				sMenu.screen(user, group, color, f1);
				
			}
			
		});
		
		j3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MeetingMenu meetingMenu=new MeetingMenu();
				meetingMenu.screen(user, group, color, f1);
				
			}
			
		});
		
	}
	
	//Template method Design Pattern : https://jdm.kr/blog/116
	
}
