package observer.design.pattern.oodp;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TaskObserver implements Observer {

    @Override
    public void Notify() {
        System.out.println("NEW 업무 변경사항 알림");
    	JFrame f = new JFrame();
    	JLabel msg = new JLabel("NEW 업무 변경사항 알림: 업무를 다시 확인해주세요!");
		f.add(msg, BorderLayout.CENTER);
		f.setSize(400, 100);
		f.setVisible(true);
		f.setTitle("Observer Alarm");
		
    }
}
