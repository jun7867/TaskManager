  
package schedule.management.oodp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import group.management.oodp.Group;
import group.management.oodp.GroupDTO;
import user.management.oodp.UserDTO;

public class ScheduleMenu {

	public void screen(UserDTO user, Group group) {
		JFrame f = new JFrame();
		f.setSize(400, 400);
		f.setVisible(true);
		f.setTitle("Schedule Menu Page");
		
		JLabel welcome = new JLabel(user.getName()+"님, 현재 "+ group.getName() +" 스케줄 관리에 접속해있습니다.");
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
