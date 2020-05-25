package task.management.oodp;

import java.util.ArrayList;

public class Task {
	private String groupName;
	private String task;
	private String startDate;
	private String endDate;
	private ArrayList<String> userList = new ArrayList<>();

	public Task(String task, String startDate, String endDate, ArrayList<String> userList) {

		
		this.task = task;
		this.startDate = startDate;
		this.endDate = endDate;
		this.userList = userList;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public ArrayList<String> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<String> userList) {
		this.userList = userList;
	}

	
}