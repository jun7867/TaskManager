package visitor.design.pattern.oodp;

import schedule.management.oodp.Schedule;
import task.management.oodp.Task;
import group.management.oodp.Group;

public class Client {

	public static void main(String[] args) {	
		//int total = calculate();
		//System.out.println(total);
	}

	public static int calculate(Group group) {
		Visitor visitor = new VisitorImpl();
		int mem = visitor.visit(group);
		return mem;
	}

}
