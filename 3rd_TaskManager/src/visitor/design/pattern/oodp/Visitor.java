package visitor.design.pattern.oodp;

import java.text.ParseException;

import schedule.management.oodp.Schedule;
import task.management.oodp.Task;
import group.management.oodp.Group;

public interface Visitor {
	
	int visit(Group group);
	int visit(Task task);
	int visit(Schedule sched) throws ParseException;
	//회의/미팅 구현시 
	//	int visit(Meeting meeting);
}
