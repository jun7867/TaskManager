package factory.design.pattern.oodp;

import group.management.oodp.CompanyGroup;
import group.management.oodp.Group;

public class CompanyGroupFactory extends GroupFactory{
	@Override
	protected Group createGroup(String name, int num, String hostName, String[] memberName) {
		// TODO Auto-generated method stub
		Group group = new CompanyGroup();
		group.setName(name);
		group.setType(0);
		group.setNum(num);
		group.setHostName(hostName);
		for(int i=0; i<num-1; i++)
			group.setMemberName(memberName[i], i);
		return group;
	}

}
