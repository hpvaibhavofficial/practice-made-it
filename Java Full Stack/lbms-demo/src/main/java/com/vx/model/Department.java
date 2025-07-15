package com.vx.model;

import java.util.LinkedList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Department {
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE,generator = "depiseq")
	@SequenceGenerator(name = "depidseq",allocationSize = 1,initialValue = 0)
	int depid;
	String depname;
	
	@OneToMany(mappedBy = "department")
	List<Student> stu = new LinkedList<>(); 
	
	public Department() {
		// TODO Auto-generated constructor stub
	}
	
	public Department(int depid, String depname) {
		super();
		this.depid = depid;
		this.depname = depname;
	}

	public int getDepid() {
		return depid;
	}

	public void setDepid(int depid) {
		this.depid = depid;
	}

	public String getDepname() {
		return depname;
	}

	public void setDepname(String depname) {
		this.depname = depname;
	}

	@Override
	public String toString() {
		return "Department [depid=" + depid + ", depname=" + depname + "]";
	}
	
}
