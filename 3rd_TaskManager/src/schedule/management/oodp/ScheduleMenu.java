package schedule.management.oodp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import decorate.design.pattern.oodp.DecoName;
import decorate.design.pattern.oodp.JustName;
import decorate.design.pattern.oodp.IsLeaderTopping;
import decorate.design.pattern.oodp.InChargeTopping;
import group.management.oodp.Group;
import group.management.oodp.GroupDTO;
import user.management.oodp.UserDTO;

public class ScheduleMenu {

	public void screen(UserDTO user, Group group, Color color) {
		//그냥 이름 
		DecoName justName=new JustName();
		justName.setName(user.getName());
				
		//Decorate Pattern
		DecoName IsLeaderInChargeName = new IsLeaderTopping(new InChargeTopping(justName));
		
		JFrame f = new JFrame();
		f.setSize(400, 400);
		f.setVisible(true);
		f.getContentPane().setBackground(color);
		f.setTitle("Schedule Menu Page");
		
		JLabel welcome = new JLabel(IsLeaderInChargeName.getName()+"님, 현재 "+ group.getName() +" 스케줄 관리에 접속해있습니다.");
		f.add(welcome, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());	
		
		JButton j1 = new JButton("스케줄 생성하기");
		JButton j2 = new JButton("스케줄 확인/수정 ");
		buttonPanel.add(j1);
		buttonPanel.add(j2);
		
		f.add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setVisible(true);
		
		j1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MakeSchedule makeSched=new MakeSchedule();
				makeSched.MakeSchedule(user, group);
				
			}
			
		});
		
		
		j2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ShowSchedule showSched=new ShowSchedule();
				showSched.ShowSchedule(user,group);
			}
			
		});
		
	}
	
}
