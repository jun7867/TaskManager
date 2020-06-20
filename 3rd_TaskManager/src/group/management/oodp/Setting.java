package group.management.oodp;

import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import memento.design.pattern.oodp.CareTaker;
import memento.design.pattern.oodp.Originator;

public class Setting extends JFrame {
	private Font f1;
	Originator originator = new Originator();
	CareTaker careTaker = new CareTaker();
	
	
	public void screen() {
		JPanel panel = new JPanel();
		Label l1 = new Label("폰트 사이즈"); add(l1);
		l1.setBounds(100, 50, 60, 30);
		TextField t1 = new TextField(); add(t1);
		t1.setBounds(180, 50, 150, 30);
		
		JButton j1 = new JButton("등록");
		JButton j2 = new JButton("취소");
		JButton j3 = new JButton("되돌리기");
		add(j1);
		add(j2);
		add(j3);
		j1.setBounds(80, 330, 80, 30);
		j2.setBounds(200, 330, 80, 30);
		j3.setBounds(320, 330, 80, 30);
		add(panel);
		setSize(500,400);
		setTitle("환경 설정");
		setVisible(true);
		
		originator.setFont(12); // 초기값 저장.
		careTaker.add(originator.saveFontToMemento());
		
		j1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					//originator.setFont 하고 careTaker.add(originator.saveFontToMemento))) 하면 상태가 저장됨.
					originator.setFont(Integer.parseInt(t1.getText()));
					careTaker.add(originator.saveFontToMemento());
					
					f1 = new Font("돋움",Font.PLAIN,Integer.parseInt(t1.getText()));
					l1.setFont(f1);
					System.out.println(t1.getText());
				}catch(Exception ex) {
						
				}
			}
		});
		j2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		j3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 첫번째 저장한 State 불러오기 get(0)
				// 두번째 저장한 State 불러오려면 get(1)
				
				//get(0)은 기본 사이즈(12)로 돌아가기.
				originator.getFontFromMemento(careTaker.get(0));
				System.out.println(originator.getFont());
				f1 = new Font("돋움",Font.PLAIN,originator.getFont());
				l1.setFont(f1);
			}
		});
	}

}
