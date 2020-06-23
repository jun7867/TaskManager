package visitor.design.pattern.oodp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import schedule.management.oodp.Schedule;
import group.management.oodp.Group;

public class VisitorImpl implements Visitor  {
	
	//그룹 멤버 인원 체크 연산
	@Override
	public int visit(Group group) {
		int number = group.getNum();
		return number;
	}
	
	//해당 스케줄이 오늘로부터 몇일 후인지 계산
	@Override
	public int visit(Schedule sched) throws ParseException {
		Calendar calendar = Calendar.getInstance(); 
		Date today = calendar.getTime(); //현재 시간 얻기
		String from = sched.getDate();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date Dday = transFormat.parse(from);
		long diff = Dday.getTime() - today.getTime();
		long remain_day = diff/(24*60*60*1000);
		return (int)remain_day;
	}
	
}
