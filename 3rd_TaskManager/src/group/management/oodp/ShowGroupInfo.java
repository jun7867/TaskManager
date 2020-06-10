package group.management.oodp;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

<<<<<<< HEAD
import Decorate.design.pattern.oodp.DecoName;
import Decorate.design.pattern.oodp.JustName;
import Decorate.design.pattern.oodp.PerfectTopping;
import Decorate.design.pattern.oodp.SuperTopping;
import factory.design.pattern.oodp.CompanyGroupFactory;
import factory.design.pattern.oodp.GroupFactory;
import factory.design.pattern.oodp.OtherGroupFactory;
import factory.design.pattern.oodp.SchoolGroupFactory;
=======
>>>>>>> df970b903afdb4d0a98a5df29a2e2b34e3ebef9d
import task.management.oodp.Task;
import task.management.oodp.TaskMenu;
import schedule.management.oodp.ScheduleMenu;
import user.management.oodp.UserDTO;

public class ShowGroupInfo extends JFrame{
	
	
	public void screen(UserDTO user, Color color) {
		
		DefaultTableModel model;
		JTable tableView;
		StringBuilder sbuilder;
		JScrollPane scrollList;
		Vector<String> colNames = new Vector<>();
		colNames.addElement("그룹명");
		colNames.addElement("호스트");
		colNames.addElement("멤버");
		colNames.addElement("그룹 정보");
		BufferedReader logbuff = null;
		ArrayList<GroupDTO> groupList = new ArrayList<>();
		GroupDAO dao = new GroupDAO();
		try {
			logbuff = new BufferedReader(new FileReader("group.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String str;		
		try {
			while ((str = logbuff.readLine()) != null) {
				ArrayList<String> memberList = new ArrayList<>();
				String[] array = str.split("/");
				int j=3;
				while(!array[j].equals("!end!")) {
					if(array[j].equals(user.getName()))
						groupList.add(dao.getGroupUsingName(array[0]));
					j++;
				}
			}
			logbuff.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		model = new DefaultTableModel(colNames, 0);
		tableView = new JTable(model);
		scrollList = new JScrollPane(tableView);
		
		tableView.getColumnModel().getColumn(0).setPreferredWidth(100); 
		tableView.getColumnModel().getColumn(1).setPreferredWidth(100);
		tableView.getColumnModel().getColumn(2).setPreferredWidth(200);
		tableView.getColumnModel().getColumn(3).setPreferredWidth(400);
		add(scrollList);
		scrollList.setBounds(0, 10, 800, 300);

		for (int i = 0; i < groupList.size(); i++) {
			// setting member taskList
			String allUser = "";
			for(int j=0; j<groupList.get(i).getNum()-1; j++)
				allUser += groupList.get(i).getMemberName(j)+" ";
			System.out.println(allUser);
			
			Vector<String> rows;
			rows = new Vector<String>();
			rows.addElement(groupList.get(i).getName());
			rows.addElement(groupList.get(i).getHostName());
			rows.addElement(allUser);
			GroupFactory factory;
			if(groupList.get(i).getType()==0) factory = new SchoolGroupFactory();
			else if (groupList.get(i).getType()==1) factory = new CompanyGroupFactory();
			else factory = new OtherGroupFactory();
			Group group = factory.make(groupList.get(i).getName());
			rows.addElement(group.getEx());
			model.addRow(rows);
		}
		JButton j1 = new JButton("닫기");
		JButton j2 = new JButton("삭제");
		add(j1);
		add(j2);
		j1.setBounds(410, 330, 100, 30);
		j2.setBounds(290, 330, 100, 30);
		
		setLayout(null);
		setSize(800,400);
		setTitle("나의 그룹 정보");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		
		j1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		j2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 선택한 줄 (row)번호 알아내기
				int rowIndex = tableView.getSelectedRow();
				// 선택 안하고 누를 경우
				if (rowIndex == -1)
					dispose();
				model.removeRow(rowIndex);
				deleteGroup(rowIndex, user);
				
			}
		});

	}
	
	private void deleteGroup(int rowIndex, UserDTO user) {
		String outputData = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader("group.txt"));
			int count = 0;
			String line = "";
			while ((line = br.readLine()) != null) {

				if (count == rowIndex) {
					count++;
					continue;
				} else {
					outputData += line + "\n";
				}
				
				count++;
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.getStackTrace();
		} catch (IOException e) {
			e.getStackTrace();
		}
		System.out.println("output: " + outputData);
		try {
			File file = new File("group.txt");
			BufferedWriter fw = new BufferedWriter(new FileWriter(file));
			fw.write(outputData);
			fw.close();
		} catch (FileNotFoundException e) {
			e.getStackTrace();
		} catch (IOException e) {
			e.getStackTrace();
		}

	}
	
}


//TO DO
/* 그룹 설명 Template method 사용해서 넣기
 * 그룹 수정하면 그룹 정보 저장되게
 * 그룹 삭제 하기
*/
