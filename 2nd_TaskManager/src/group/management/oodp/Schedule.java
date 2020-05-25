package group.management.oodp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.util.*;
import java.text.*;

public class Schedule extends JFrame {
	
	public void make() throws HeadlessException {
		JPanel panel = new JPanel();
		Label l1 = new Label("일시");
		Label l2 = new Label("스케줄 이름");
		Label l3 = new Label("스케줄 해당 그룹");
		add(l1);
		add(l2);
		add(l3);
		l1.setBounds(40, 10, 60, 30);
		l2.setBounds(40, 50, 100, 30);
		l3.setBounds(40, 80, 100, 30);
		TextField t1 = new TextField();
		TextField t2 = new TextField();
		add(t1);
		add(t2);
		t1.setBounds(160, 50, 150, 30);
		t2.setBounds(160, 80, 150, 30);
		
		
		BufferedReader logbuff = null;
		try {
			logbuff = new BufferedReader(new FileReader("user.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// 날짜와 시간 스피너
		Calendar calendar = Calendar.getInstance(); //갤린더 객체 얻기
		Date value = calendar.getTime(); //현재 시간 얻기
				
		calendar.add(Calendar.YEAR, -50); // 50년 전의 날짜 얻기
		Date start = calendar.getTime(); //50년 전의 날짜를 최소 날짜로 지정
				
		calendar.add(Calendar.YEAR, 100); // 50년 뒤의 날짜 얻기 +50하면 현재날짜가됨.
		Date end = calendar.getTime(); //50년 뒤의 날짜를 최대 날짜로 지정

		SpinnerDateModel dateModel = new SpinnerDateModel(value, start, end, Calendar.YEAR);
		JSpinner spinner1 = new JSpinner(dateModel);
		spinner1.setEditor(new JSpinner.DateEditor(spinner1, "yyyy-MM-dd HH시mm분")); //날짜 편집기 지정
		panel.add(spinner1);
		
		JButton j1 = new JButton("등록");
		JButton j2 = new JButton("취소");
		add(j1);
		add(j2);
		j1.setBounds(125, 330, 80, 30);
		j2.setBounds(240, 330, 80, 30);
		
		add(panel);
		setSize(500,400);
		setTitle("스케줄 생성");
		setVisible(true);
		
		
		
		
		j1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					BufferedWriter bos = new BufferedWriter(new FileWriter("Sched.txt", true));
				    	Object timeval = spinner1.getModel().getValue();
						bos.write(timeval+"/");
						bos.write(t1.getText()+"/");
					    bos.write(t2.getText()+"/");
					    bos.write("!end!\n");
						bos.close();
						JOptionPane.showMessageDialog(null, t1.getText()+" 스케줄이 생성되었습니다.");
						dispose();
				}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "스케줄 생성에 실패했습니다.");
				}
			}
		});
		j2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
	
	}
	

	
}
