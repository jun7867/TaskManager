package group.management.oodp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import user.management.oodp.SignUp;

public class Menu extends JFrame implements ActionListener{
	
	public void screen(String userName) {
		JPanel panel = new JPanel();
		//panel.setBounds();
		Label l1 = new Label("환영합니다.	"+ userName +" 님!!");
		add(l1);
		l1.setBounds(0, 0, 200, 40);
		JButton j1 = new JButton("그룹 생성"); add(j1);
		JButton j2 = new JButton("그룹 관리"); add(j2);
		JButton j3 = new JButton("새로 고침"); add(j3);
		JButton j4 = new JButton("스케줄 생성"); add(j4);
		JButton j5 = new JButton("스케줄 관리"); add(j5);
		j1.setBounds(100, 330, 100, 30);
		j2.setBounds(250, 330, 100, 30);
		j3.setBounds(400, 0, 80, 30);
		j4.setBounds(100, 380, 100, 30);
		j5.setBounds(250, 380, 100, 30);
		String g_str;
		String[] g_array;
		JButton btn[] = new JButton[100];
		int i=0;
		try {
			BufferedReader groupbuff = new BufferedReader(new FileReader("group.txt"));
			int width=10;
			int height=50;
			while((g_str=groupbuff.readLine())!=null){
				g_array=g_str.split("/");
				int j=2;
				while(!g_array[j].equals("!end!")) {
					if(g_array[j].equals(userName)) {
						btn[i]=new JButton("");
						btn[i].setText(g_array[1]);
						add(btn[i]);
						btn[i].setBounds(width, height, 80, 30);
						i++;
						width+=100;
						if(width>500) {
							width=10;
							height+=40;
						}
						break;
					}
					j++;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		add(panel);
		setSize(500,500);
		setTitle("그룹 생성/관리/선택");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
		
		j1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MakeGroup makegroup = new MakeGroup();
				makegroup.make();
			}
		});
		j2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "아직 구현되지 않은 기능입니다ㅠㅠ");
			}
		});
		j3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Menu menu = new Menu();
		        menu.screen(userName);
			}
		});
		j4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Schedule s1 = new Schedule();
				s1.make();
			}
		});
		j5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangeSchedule c1 = new ChangeSchedule();
				c1.edit();
			}
		});
	}
	
	public void actionPerformed(ActionEvent e) {
	}


}
