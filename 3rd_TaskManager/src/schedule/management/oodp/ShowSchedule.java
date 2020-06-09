
package schedule.management.oodp;

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
import javax.swing.table.DefaultTableModel;

import group.management.oodp.Group;
import group.management.oodp.GroupDTO;
import task.management.oodp.ShowTask;
import task.management.oodp.Task;
import user.management.oodp.UserDTO;

import java.awt.*;
import java.util.*;
import java.text.*;

public class ShowSchedule extends JFrame {
	
	private int i=0;
	private JFrame frame;
	private JTable tableView;
	private StringBuilder sbuilder;
	private JScrollPane scrollList;
	DefaultTableModel model;
	Vector<String> rows;

	public void ShowSchedule(UserDTO user,Group group) {
		JPanel panel = new JPanel();
		BufferedReader logbuff = null;
		ArrayList<Schedule> schedList = new ArrayList<>();
		try {
			logbuff = new BufferedReader(new FileReader("schedule.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String str;
		
		try {
			while((str=logbuff.readLine())!=null){
				//array에 파일이 한줄씩 저장됨 [0]: group / [1] : sched name /..
				String[] array = str.split("/");
				
				//같은 group에 있는 스케줄들이 schedList에 저장됨.
				if(array[0].equals(group.getName())) {
					System.out.println(" Same !! ");
					schedList.add(new Schedule(array[1],array[2],array[3]));
					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Vector<String> colNames=new Vector<>();
		colNames.addElement("Group");
		colNames.addElement("Schedule name");
		colNames.addElement("Date");
		colNames.addElement("Content");


		model=new DefaultTableModel(colNames,0);
		tableView=new JTable(model);
		//panel.setLayout(new BorderLayout());
		scrollList=new JScrollPane(tableView);
		add(scrollList,BorderLayout.CENTER);

		
		for(int i=0; i<schedList.size(); i++) {
			rows=new Vector<String>();
			rows.addElement(group.getName());
			rows.addElement(schedList.get(i).getSchedule());
			rows.addElement(schedList.get(i).getDate());
			rows.addElement(schedList.get(i).getContent());
			model.addRow(rows);
		}


		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(2, 1));

		JTextField tfName = new JTextField(10);
		JTextField tfDate= new JTextField(10);
		JTextField tfContent = new JTextField(15);
		panel.add(new JLabel("Schedule"));
		panel.add(tfName);
		panel.add(new JLabel("Date"));
		panel.add(tfDate);
		panel.add(new JLabel("Content"));
		panel.add(tfContent);
		bottomPanel.add(panel);

		JPanel panel2 = new JPanel();
		JButton btnMod = new JButton("수정");
		JButton btnDel = new JButton("삭제");
		JButton btnBack = new JButton("뒤로가기");
		panel2.add(btnMod);
		panel2.add(btnDel);
		panel2.add(btnBack);
		bottomPanel.add(panel2);

		add(bottomPanel, BorderLayout.SOUTH);
		setResizable(false);
		setLocationRelativeTo(null);

		setSize(900, 500);
		setTitle("스케줄 확인 페이지");
		setVisible(true);

		btnMod.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 선택한 줄 (row)번호 알아내기
				int rowIndex = tableView.getSelectedRow();
				UpdateSched(rowIndex, group, tfName, tfDate, tfContent);
				// 선택 안하고 누를 경우
				if (rowIndex == -1)
					JOptionPane.showMessageDialog(null, "아무것도 선택이 되지 않았습니다.");
				// 선택하고 누를 경우
				else {
					dispose();
					ShowSchedule showsched =new ShowSchedule();
					showsched.ShowSchedule(user,group);
				}
			}
		});

		btnDel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 선택한 줄 (row)번호 알아내기
				int rowIndex = tableView.getSelectedRow();
				// 선택 안하고 누를 경우
				if (rowIndex == -1)
					JOptionPane.showMessageDialog(null, "아무것도 선택이 되지 않았습니다.");
				// 선택하고 누를 경우
				else {
					model.removeRow(rowIndex);
					deleteSched(rowIndex, group, tfName, tfDate, tfContent);
				}
			}
		});

		// 뒤로가기
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

	private void UpdateSched(int rowIndex, Group group, JTextField tfName, JTextField tfDate, JTextField tfContent) 
	{
		String task = tfName.getText();
		String date = tfDate.getText();
		String content = tfContent.getText();
		String inputData = group.getName() + "/" + task + "/" + date + "/" + content + "/!end!";
		String outputData = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader("schedule.txt"));
			int count = 0;
			String line = "";
			while ((line = br.readLine()) != null) {

				if (count == rowIndex) {
					outputData += inputData + "\n";
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
			File file = new File("schedule.txt");
			BufferedWriter fw = new BufferedWriter(new FileWriter(file));
			fw.write(outputData);
			fw.close();
		} catch (FileNotFoundException e) {
			e.getStackTrace();
		} catch (IOException e) {
			e.getStackTrace();
		}

	}
	
	private void deleteSched(int rowIndex, Group group, JTextField tfName, JTextField tfDate, JTextField tfContent) {
		String outputData = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader("schedule.txt"));
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
			File file = new File("schedule.txt");
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
