package factory.design.pattern.oodp;

import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.swing.JOptionPane;

import group.management.oodp.CompanyGroup;
import group.management.oodp.Group;
import group.management.oodp.SchoolGroup;

public class SchoolGroupFactory  extends GroupFactory{
	@Override
	protected Group createGroup(String name, int num, String hostName, String[] memberName) {
		// TODO Auto-generated method stub
		Group group = new SchoolGroup();
		group.setName(name);
		group.setType(1);
		group.setNum(num);
		group.setHostName(hostName);
		for(int i=0; i<num-1; i++)
			group.setMemberName(memberName[i], i);
		return group;
	}
}
