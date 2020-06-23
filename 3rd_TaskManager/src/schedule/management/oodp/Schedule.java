package schedule.management.oodp;

import java.text.ParseException;
import java.util.ArrayList;
import visitor.design.pattern.oodp.Element;
import visitor.design.pattern.oodp.Visitor;
import visitor.design.pattern.oodp.*;

public class Schedule implements Element {
	private String groupName;
	private String sched;
	private String date;
	private String content;
	private ArrayList<String> userList = new ArrayList<>();

	public Schedule(String sched, String date, String content) {
	
		this.sched = sched;
		this.date = date;
		this.content = content;
	}

	public String getSchedule() {
		return sched;
	}

	public void setSchedule(String sched) {
		this.sched = sched;
	}

	public String getDate() {
		return date;
	}

	public void setdate(String date) {
		this.date = date;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public ArrayList<String> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<String> userList) {
		this.userList = userList;
	}
	
	//Visitor Pattern
	@Override
	public int accept(Visitor visitor) throws ParseException {
		return visitor.visit(this);
	}
	
}
