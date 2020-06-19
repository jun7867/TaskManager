package decorate.design.pattern.oodp;

public class IsLeaderTopping extends Topping{
	private String name;
	public IsLeaderTopping(DecoName decoName) {
		super(decoName);
	}
	
	//기본 기능 + Leader
	@Override
	public String getName() {
		String IsLeader=Leader();
		return IsLeader + decoName.getName();
	}
	
	private String Leader() {
		return "팀 리더 ,";
	}
	
	
	public void setName(String name) {
		this.name=name;
	}
	
}
