package com.manish.entity;

import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int rollNo;
	@Column
	private String name;
	@Column
	private String section;
	@Column
	private int className;
	
	public Student() {
		super();
		
	}
	public Student(int rollNo, String name, String section, int className) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.section = section;
		this.className = className;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public int getClassName() {
		return className;
	}
	public void setClassName(int className) {
		this.className = className;
	}

	
}
