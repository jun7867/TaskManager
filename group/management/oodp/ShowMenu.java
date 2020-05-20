package group.management.oodp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ShowMenu extends JFrame implements ActionListener{
	
	private String userName = "沥老籍";
	
	public void screen() {
		JFrame f = new JFrame();
		f.setSize(400, 400);
		f.setVisible(true);
		
		JLabel welcome = new JLabel("券康钦聪促.	"+ userName +" 丛!!");
		f.add(welcome, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		
		JButton groupButton = new JButton("弊缝 积己/包府");
		groupButton.addActionListener(this);
		buttonPanel.add(groupButton);
		
		JButton taskButton = new JButton("诀公 包府");
		taskButton.addActionListener(this);
		buttonPanel.add(taskButton);
		
		JButton meetingButton = new JButton("雀狼 包府");
		meetingButton.addActionListener(this);
		buttonPanel.add(meetingButton);
		
		JButton schduleButton = new JButton("胶纳临 包府");
		schduleButton.addActionListener(this);
		buttonPanel.add(schduleButton);
		
		JButton optionButton = new JButton("可记 函版");
		optionButton.addActionListener(this);
		buttonPanel.add(optionButton);
		
		f.add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("弊缝 积己/包府")) {}
		else if (e.getActionCommand().equals("诀公 包府")) {}
		else if (e.getActionCommand().equals("雀狼 包府")) {}
		else if (e.getActionCommand().equals("胶纳临 包府")) {}
		else {}
	}

}
