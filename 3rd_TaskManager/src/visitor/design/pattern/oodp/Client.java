package visitor.design.pattern.oodp;

import java.text.ParseException;
import group.management.oodp.Group;
import schedule.management.oodp.Schedule;

public class Client {

	public static void main(String[] args) {	
	}
	
	//그룹 멤버 인원 체크 연산
	public static int calculate(Group group) {
		Visitor visitor = new VisitorImpl();
		int mem = visitor.visit(group);
		return mem;
	}
	
	//해당 스케줄이 오늘로부터 몇일 후인지 계산
	public static int dayLeft(Schedule Sched) throws ParseException {
		Visitor visitor = new VisitorImpl();
		int rem_day = visitor.visit(Sched);
		return rem_day;
	}

}
