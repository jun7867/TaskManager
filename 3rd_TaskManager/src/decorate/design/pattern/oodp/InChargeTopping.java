package decorate.design.pattern.oodp;

public class InChargeTopping extends Topping{
	private String name;
	public InChargeTopping(DecoName decoName) {
		super(decoName);
	}
	
	//기본 기능 + Charge
	@Override
	public String getName() {
		String InCharge=Charge();
		return InCharge + decoName.getName();
	}
	
	private String Charge() {
		return "QA Test 담당 ,";
	}
	
	public void setName(String name) {
		this.name=name;
	}

}
