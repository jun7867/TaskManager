package memento.design.pattern.oodp;

public class Memento {
	private int state;
	
	public Memento(int state) {
		this.state=state;
	}


	public int getFont() {
		
		return state;
	}
}
