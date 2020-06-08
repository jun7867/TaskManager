package state.design.pattern.oodp;

import java.awt.Color;

public class Winter implements Background{

	@Override
	public Color changeBackground() {
		//return Color.BLUE;
		Color color = new Color(0xd7dede);
		return color;
	}


}
