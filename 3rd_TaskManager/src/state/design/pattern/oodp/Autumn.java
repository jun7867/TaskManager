package state.design.pattern.oodp;

import java.awt.Color;

public class Autumn implements Background{

	@Override
	public Color changeBackground() {
		//return Color.BLUE;
		Color color = new Color(0xcfc1b2);
		return color;
	}


}
