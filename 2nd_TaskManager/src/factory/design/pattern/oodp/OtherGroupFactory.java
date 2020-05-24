package factory.design.pattern.oodp;

import group.management.oodp.CompanyGroup;
import group.management.oodp.Group;
import group.management.oodp.OtherGroup;

public class OtherGroupFactory  extends GroupFactory{

	@Override
	protected Group createGroup(String name, int num, String hostName, String[] memberName) {
		// TODO Auto-generated method stub
		Group group = new OtherGroup();
		group.setName(name);
		group.setType(2);
		group.setNum(num);
		group.setHostName(hostName);
		for(int i=0; i<num-1; i++)
			group.setMemberName(memberName[i], i);
		return group;
	}
}
