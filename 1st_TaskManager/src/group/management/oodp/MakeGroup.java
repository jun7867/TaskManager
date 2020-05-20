package group.management.oodp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import java.awt.*;

public class MakeGroup extends JFrame{
	boolean isIdUnique=false;
	int i=1;
	public void make() throws HeadlessException {
		JPanel panel = new JPanel();
		Label l1 = new Label("그룹 번호");
		Label l2 = new Label("그룹 명");
		Label l3 = new Label("멤버 선택");
		Label l4 = new Label("52643");
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		l1.setBounds(40, 10, 60, 30);
		l2.setBounds(40, 50, 40, 30);
		l3.setBounds(40, 80, 60, 30);
		l4.setBounds(120, 10, 80, 30);
		TextField t1 = new TextField();
		add(t1);
		t1.setBounds(120, 50, 200, 30);
		
		
		BufferedReader logbuff = null;
		try {
			logbuff = new BufferedReader(new FileReader("user.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String str;
		String[] array;
		Label l[] = new Label[100];
		JCheckBox c[] = new JCheckBox[100];
		try {
			while((str=logbuff.readLine())!=null){
				
				array=str.split("/");
				l[i] = new Label("hello");
				l[i].setText(array[0]);
				c[i] = new JCheckBox();
				add(l[i]);
				add(c[i]);
				l[i].setBounds(100, 80+30*i, 140, 30);
				c[i].setBounds (60, 80+30*i, 20, 40);
				i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JButton j1 = new JButton("등록");
		JButton j2 = new JButton("취소");
		add(j1);
		add(j2);
		j1.setBounds(125, 330, 80, 30);
		j2.setBounds(240, 330, 80, 30);
		add(panel);
		setSize(500,400);
		setTitle("그룹 생성");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		j1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					BufferedWriter bos = new BufferedWriter(new FileWriter("group.txt", true));
					    bos.write(l4.getText()+"/");
					    bos.write(t1.getText()+"/");
					    for(int j=1; j<i; j++) {
					    	if(c[j].isSelected()) {
					    		bos.write(l[j].getText()+"/");
					    	}
					    }
					    bos.write("!end!\n");
						bos.close();
						JOptionPane.showMessageDialog(null, t1.getText()+" 그룹이 생성되었습니다.");
						dispose();
				}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "그룹 생성에 실패했습니다.");
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
