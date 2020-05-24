package group.management.oodp;

public class CompanyGroup extends Group{
	private String name;
	private int type;
	private int num;
	private String hostName;
	private String[] memberName;
	public CompanyGroup() {
		System.out.println("Company Group이 생성되었습니다.");
	}
}
