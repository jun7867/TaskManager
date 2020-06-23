package visitor.design.pattern.oodp;

import java.text.ParseException;

public interface Element {

	public int accept(Visitor visitor) throws ParseException;
}
