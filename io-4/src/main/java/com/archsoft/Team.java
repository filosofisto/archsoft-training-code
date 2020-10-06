package com.archsoft;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Team implements Serializable {

	private static final long serialVersionUID = -2321825565927245035L;
	
	private List<Person> members;

	public List<Person> getMembers() {
		if (members == null) {
			members = new ArrayList<Person>();
		}

		return members;
	}

	public void setMembers(List<Person> members) {
		this.members = members;
	}
	
	public String toString() {
		StringBuilder b = new StringBuilder("Equipe\n");
		
		for (Person p: getMembers()) {
			b.append("\t" + p + "\n");
		}
		
		return b.toString();
	}
}
