package state.design.pattern.oodp;

import java.awt.Color;

public class Summer implements Background{

	@Override
	public Color changeBackground() {		
		//return Color.BLUE;
		Color color = new Color(0xbbede1);
		return color;
	}
}
