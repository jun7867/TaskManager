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

import factory.design.pattern.oodp.CompanyGroupFactory;
import factory.design.pattern.oodp.GroupFactory;
import factory.design.pattern.oodp.OtherGroupFactory;
import factory.design.pattern.oodp.SchoolGroupFactory;
import user.management.oodp.SignUp;
import user.management.oodp.UserDTO;
import group.management.oodp.Menu;

public class ManageGroup extends JFrame{
	UserDTO user = new UserDTO();
	GroupDTO group = new GroupDTO();
	public void screen(UserDTO user) {
		JPanel panel = new JPanel();
		Label l1 = new Label("환영합니다.	"+ user.getName() +" 님!!");
		add(l1);
		l1.setBounds(0, 0, 200, 40);
		JButton j1 = new JButton("그룹 생성"); add(j1);
		JButton j2 = new JButton("그룹 관리"); add(j2);
		JButton j3 = new JButton("새로 고침"); add(j3);
		j1.setBounds(150, 330, 80, 30);
		j2.setBounds(250, 330, 80, 30);
		j3.setBounds(400, 0, 80, 30);
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
				int j=3;
				while(!g_array[j].equals("!end!")) {
					if(g_array[j].equals(user.getName())) {
						btn[i]=new JButton("");
						btn[i].setText(g_array[0]);
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
		setSize(500,400);
		setTitle("그룹 생성/관리/선택");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
		
		j1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MakeGroup makegroup = new MakeGroup();
				makegroup.make(user.getName());
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
				ManageGroup menu = new ManageGroup();
		        menu.screen(user);
			}
		});
		for(int j=0; j<i; j++) {
			btn[j].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton button = (JButton) e.getSource();
				    String btnName = button.getActionCommand();
					//System.out.println("->"+btnName);
					GroupDAO groupdao = new GroupDAO();
					group=groupdao.getGroupUsingName(btnName);
					
					int type = group.getType();
					GroupFactory factory;
					if(type==0)
						factory = new SchoolGroupFactory();
					else if (type==1)
						factory = new CompanyGroupFactory();
					else
						factory = new OtherGroupFactory();
					Group newG = factory.make(btnName);
					Menu menu = new Menu();
					menu.screen(user, newG);
				}
			});
		}
	}


}
