package task.management.oodp;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import group.management.oodp.GroupDTO;
import user.management.oodp.UserDTO;

public class ShowTask extends JFrame{
	private int i=0;
	private JFrame frame;
	private JTable tableView;
	private StringBuilder sbuilder;
	private JScrollPane scrollList;
	DefaultTableModel model;
	Vector<String> rows;

	public void ShowTask(UserDTO user,GroupDTO group) {	
//		JPanel panel = new JPanel();
//		JPanel bottomPanel = new JPanel();
//		bottomPanel.setLayout(new GridLayout(2,1));
//		
//		JTextField tfName=new JTextField(10);
//		JTextField tfMember=new JTextField(10);
//		JTextField tfStartday=new JTextField(8);
//		JTextField tfEndday=new JTextField(8);
//		panel.add(comp)
		
		
		BufferedReader logbuff = null;
		ArrayList<Task> taskList = new ArrayList<>();
		try {
			logbuff = new BufferedReader(new FileReader("task.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String str;
		
		try {
			while((str=logbuff.readLine())!=null){
				ArrayList<String> memberList = new ArrayList<>();
				//array에 파일이 한줄씩 저장됨 [0]: group / [1] : task name /..
				String[] array = str.split("/");
				
				//같은 group에 있는 task들이 taskList에 저장됨.
				if(array[0].equals(group.getName())) {
					System.out.println(" Same !! ");
					for(int i = 4; i < array.length-1; i++){
						memberList.add(array[i]);
					}
					taskList.add(new Task(array[1],array[2],array[3],memberList));
					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Vector<String> colNames=new Vector<>();
		colNames.addElement("Group");
		colNames.addElement("Task");
		colNames.addElement("member");
		colNames.addElement("Date");

		model=new DefaultTableModel(colNames,0);
		tableView=new JTable(model);
		scrollList=new JScrollPane(tableView);
		add(scrollList,BorderLayout.CENTER);
		
		
		
		JPanel panel = new JPanel();
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(2,1));
		
		JTextField tfName=new JTextField(10);
		JTextField tfMember=new JTextField(10);
		JTextField tfStartday=new JTextField(8);
		JTextField tfEndday=new JTextField(8);
		panel.add(new JLabel("Task"));
		panel.add(tfName);
		panel.add(new JLabel("Member"));
		panel.add(tfMember);
		panel.add(new JLabel("StartDay"));
		panel.add(tfStartday);
		panel.add(new JLabel("EndDay"));
		panel.add(tfEndday);
		bottomPanel.add(panel);
		
		JPanel panel2= new JPanel();
		JButton btnMod=new JButton("수정");
		JButton btnDel=new JButton("Delete");
		JButton btnBack = new JButton("뒤로가기");
		panel2.add(btnMod);
		panel2.add(btnDel);
		panel2.add(btnBack);
		bottomPanel.add(panel2);
		

		//Vector<String> rows=new Vector<>();
		
		for(int i=0; i<taskList.size(); i++) {
			// setting member taskList
			String allUser ="";
			for(String users : taskList.get(i).getUserList()){
				allUser += users+" ";
			}
			System.out.println(allUser);
			rows=new Vector<String>();
			rows.addElement(group.getName());
			rows.addElement(taskList.get(i).getTask());
			rows.addElement(allUser);
			rows.addElement(taskList.get(i).getStartDate()+'-'+taskList.get(i).getEndDate());
			model.addRow(rows);
		}
		
		
		
		
//		j1.setBounds(200, 380, 100, 30);
//		panel.add(j1);
//		bottomPanel.add(panel);
		add(bottomPanel,BorderLayout.SOUTH);
		setResizable(false);
		setLocationRelativeTo(null);
		
		setSize(900,500);
		setTitle("업무 확인 페이지");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
		btnMod.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//선택한 줄 (row)번호 알아내기
				int rowIndex=tableView.getSelectedRow();
				
				
			}
		});
		
		btnDel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//선택한 줄 (row)번호 알아내기
				int rowIndex=tableView.getSelectedRow();
				//선택 안하고 누를 경우 
				if(rowIndex==-1) dispose();
				model.removeRow(rowIndex);
				// 실제로 파일 삭제는 아직 구현안함. 디자인 패턴 우선 하겠음.
			}
		});

		//뒤로가기
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

}
