package group.management.oodp;

public abstract class Group {
	private String name;
	private int type;
	private int num;
	private String hostName;
	private String[] memberName;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
		 memberName = new String[num];
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getMemberName(int i) {
		return memberName[i];
	}
	public void setMemberName(String memberName, int i) {
		this.memberName[i] = memberName;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	abstract void ManageMember();
	abstract void ManageTask();
	abstract void ManageSchedule();
	abstract void ManageMeeting();
}
