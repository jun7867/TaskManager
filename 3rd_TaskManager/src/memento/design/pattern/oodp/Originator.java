package memento.design.pattern.oodp;

public class Originator {
	private int state;
	
	public void setFont(int state) {
		this.state=state;
	}
	
	public int getFont() {
		return state;
	}
	public Memento saveFontToMemento() {
		return new Memento(state);
	}
	
	public void getFontFromMemento(Memento Memento) {
		state=Memento.getFont();
	}
}
