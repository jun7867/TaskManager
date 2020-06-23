package visitor.design.pattern.oodp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import schedule.management.oodp.Schedule;
import task.management.oodp.Task;
import group.management.oodp.Group;

public class VisitorImpl implements Visitor  {
	
	
	@Override
	public int visit(Group group) {
		int number = group.getNum();
		return number;
	}
	@Override
	public int visit(Task task) {
		int number=0;
		return number;
	}

	@Override
	public int visit(Schedule sched) throws ParseException {
		Calendar calendar = Calendar.getInstance(); 
		Date today = calendar.getTime(); //현재 시간 얻기
		String from = sched.getDate();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date Dday = transFormat.parse(from);
		long diff = today.getTime() - Dday.getTime();
		long remain_day = diff/(24*60*60*1000);
		return (int)remain_day;
	}
	
	//@Override
	//public int visit(Meeting meeting) {
	//}

}
