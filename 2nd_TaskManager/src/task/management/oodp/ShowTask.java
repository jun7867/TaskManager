package task.management.oodp;

import java.awt.BorderLayout;
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
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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
		JPanel panel = new JPanel();
		//frame=new JFrame("Show Task");
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
		panel.setLayout(new BorderLayout());
		scrollList=new JScrollPane(tableView);
		panel.add(scrollList,BorderLayout.CENTER);


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


		JButton j1 = new JButton("뒤로가기");
		add(j1);
		j1.setBounds(200, 380, 100, 30);

		add(panel);
		setResizable(false);
		setLocationRelativeTo(null);
		setSize(600,450);
		setTitle("업무 확인 페이지");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);


		//뒤로가기
		j1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

}
