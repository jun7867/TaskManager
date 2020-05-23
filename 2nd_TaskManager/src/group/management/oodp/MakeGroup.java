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
	int i=0;
	public void make(String name) throws HeadlessException {
		JPanel panel = new JPanel();
		Label l1 = new Label("그룹 번호");
		Label l2 = new Label("그룹 명");
		Label l3 = new Label("멤버 선택  - 한 번에 선택 후 > 버튼을 눌러주세요!");
		Label l4 = new Label("52643");
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		l1.setBounds(40, 10, 60, 30);
		l2.setBounds(40, 50, 40, 30);
		l3.setBounds(40, 80, 260, 30);
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
		String userNames[] = new String[100];
		try {
			while((str=logbuff.readLine())!=null){
				
				array=str.split("/");	
				if(!array[0].equals(name)) {
					userNames[i]=array[0];
					i++;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		JList userJList;
		JList copyJList = new JList();
		JButton copyJButton;
		userJList = new JList( userNames );
		userJList.setVisibleRowCount( 10 );
		userJList.setSelectionMode( ListSelectionModel.MULTIPLE_INTERVAL_SELECTION );
		JScrollPane userScroll = new JScrollPane(userJList);
		add(userScroll);
		userScroll.setBounds(100, 110, 120, 200);
		copyJButton = new JButton( ">");
		add(copyJButton);
		copyJButton.setBounds(240, 200, 20, 20);

	  copyJList.setVisibleRowCount( 10 );
	  copyJList.setFixedCellWidth( 120 );
	  copyJList.setFixedCellHeight( 15 );
	  copyJList.setSelectionMode
	   (
	    ListSelectionModel.SINGLE_INTERVAL_SELECTION );
		copyJButton.addActionListener(
				new ActionListener(){
				   public void actionPerformed(ActionEvent e) {
				    {
				      copyJList.setListData( userJList.getSelectedValues() ); //copyJList에 선택된 값을 넘김.
				     }   
				   	}
				   }	
			);
		JScrollPane copyScroll = new JScrollPane(copyJList); 
		//copyScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(copyScroll);
		copyScroll.setBounds(270, 160, 140, 100);
		
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
					    bos.write(name+"/"); //host는 만든사람
					    for(int j=0; j<copyJList.getModel().getSize(); j++) {
					    	bos.write(copyJList.getModel().getElementAt(j)+"/");
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
