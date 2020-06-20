package memento.design.pattern.oodp;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
	private List mementoList = new ArrayList();
	
	public void add(Memento state) {
		mementoList.add(state);
	}
	
	public Memento get(int index) {
		return (Memento) mementoList.get(index);
	}
}
