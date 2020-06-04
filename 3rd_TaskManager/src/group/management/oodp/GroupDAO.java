package group.management.oodp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import user.management.oodp.UserDTO;

public class GroupDAO {
	public GroupDTO getGroupUsingName(String name){
		GroupDTO group = new GroupDTO();
		String str;
		String[] array;
		try {
			BufferedReader groupbuff = new BufferedReader(new FileReader("group.txt"));
    		while((str=groupbuff.readLine())!=null){
	    			array=str.split("/");
	    			if(name.equals(array[0])) {
	    				group.setName(array[0]);
	    				group.setType(Integer.parseInt(array[1]));
	    				group.setNum(Integer.parseInt(array[2]));
	    				group.setHostName(array[3]);
		    			for(int i=0; i<Integer.parseInt(array[2])-1; i++)
		    				group.setMemberName(array[i+4], i);

		    			groupbuff.close();
		    			return group;
	    			}
    		}
    		groupbuff.close();
		}catch (IOException E10) {
    		E10.printStackTrace();
    	}
		return null;
	}

}
