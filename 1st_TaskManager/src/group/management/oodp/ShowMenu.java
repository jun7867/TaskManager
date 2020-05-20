package group.management.oodp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ShowMenu extends JFrame implements ActionListener{
	
	private String userName = "정일석";
	
	public void screen() {
		JFrame f = new JFrame();
		f.setSize(400, 400);
		f.setVisible(true);
		
		JLabel welcome = new JLabel("환영합니다.	"+ userName +" 님!!");
		f.add(welcome, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		
		JButton groupButton = new JButton("그룹 생성/관리");
		groupButton.addActionListener(this);
		buttonPanel.add(groupButton);
		
		JButton taskButton = new JButton("업무 관리");
		taskButton.addActionListener(this);
		buttonPanel.add(taskButton);
		
		JButton meetingButton = new JButton("회의 관리");
		meetingButton.addActionListener(this);
		buttonPanel.add(meetingButton);
		
		JButton schduleButton = new JButton("스케줄 관리");
		schduleButton.addActionListener(this);
		buttonPanel.add(schduleButton);
		
		JButton optionButton = new JButton("옵션 변경");
		optionButton.addActionListener(this);
		buttonPanel.add(optionButton);
		
		f.add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("그룹 생성/관리")) {}
		else if (e.getActionCommand().equals("업무 관리")) {}
		else if (e.getActionCommand().equals("회의 관리")) {}
		else if (e.getActionCommand().equals("스케줄 관리")) {}
		else {}
	}

}