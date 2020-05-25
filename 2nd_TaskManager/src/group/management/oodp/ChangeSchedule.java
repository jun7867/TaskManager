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

public class ChangeSchedule extends JFrame {
	
	public void edit() throws HeadlessException {
		JPanel panel = new JPanel();
		Label l1 = new Label("스케줄 수정");
		add(l1);
		l1.setBounds(40, 10, 80, 30);
		
		try{
	          //파일 객체 생성
	          File file = new File("C:\\Users\\suyou\\eclipse-workspace\\TaskManager\\Sched.txt");
	          //입력 스트림 생성
	          FileReader filereader = new FileReader(file);
	          int singleCh = 0;
	          while((singleCh = filereader.read()) != -1){
	        	  char a = (char) singleCh;
	        	  TextField t3 = new TextField(a);
	        	  add(t3);
	        	  t3.setBounds(40, 50, 100, 60);
	          }
	          filereader.close();
	      }catch (FileNotFoundException e) {
	          // TODO: handle exception
	      }catch(IOException e){
	          System.out.println(e);
	      }

		add(panel);
		setSize(500,400);
		setTitle("스케줄 수정");
		setVisible(true);
	}
	

}
