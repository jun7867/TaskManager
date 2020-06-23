package visitor.design.pattern.oodp;

import java.text.ParseException;

import schedule.management.oodp.Schedule;
import group.management.oodp.Group;

public interface Visitor {
	
	int visit(Group group);
	int visit(Schedule sched) throws ParseException;
}
