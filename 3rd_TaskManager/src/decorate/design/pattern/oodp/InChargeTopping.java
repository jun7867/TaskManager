package Decorate.design.pattern.oodp;

public class InChargeTopping extends Topping{
	private String name;
	public InChargeTopping(DecoName decoName) {
		super(decoName);
	}
	
	@Override
	public String getName() {
		return "QA 담당 " + decoName.getName();
	}
	public void setName(String name) {
		this.name=name;
	}

}
