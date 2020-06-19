package decorate.design.pattern.oodp;

public class JustName implements DecoName{
	private String name;
	
// 기본 네임 
	@Override
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	
	

}
