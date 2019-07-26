package com.example.SpringDemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	private int id;
	private String name;
	private String total_marks;
	private String phone;
	
	Student(){
		
	}
	
	public Student(int id, String name, String total_marks, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.total_marks = total_marks;
		this.phone = phone;
	}
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
    @Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "total_marks", nullable = false)
	public String getTotal_marks() {
		return total_marks;
	}
	public void setTotal_marks(String total_marks) {
		this.total_marks = total_marks;
	}

	@Column(name = "phone", nullable = false)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", total_marks=" + total_marks + ", phone=" + phone + "]";
	}
	
	
	
}
