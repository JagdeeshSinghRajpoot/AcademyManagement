package com.Academy.Entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import java.util.List;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="Classes")
public class Classes {
	@Id
	@GeneratedValue
	@Column(name="Class_id")
	private long ClassId;

	@Column(name="Class_Name")
	private String ClassName;
	
	@OneToMany(mappedBy="classes",fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	List<Student> students;
	
	@OneToMany(mappedBy="classes",fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	List<Subjects> subjects;
	

	@ManyToMany(mappedBy="classes", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	List<Teacher> teacher;
	
	public String getTeacher() {
		StringBuffer sb = new StringBuffer();
		if(teacher!=null) {
			for(Teacher p : teacher) {
				sb.append(p.getTeacher_name()+",");
			}
		}
		return sb.toString();
	}
	
	public void setTeacher(List<Teacher> teacher) {
		this.teacher = teacher;
	}
	public String getClassName() {
		return ClassName;
	}
	public void setClassName(String class_name) {
		ClassName = class_name;
	}
	
	public long getClassId() {
		return ClassId;
	}
	
	public void setClassId(long classId) {
		ClassId = classId;
	}
	
	public void setStudent(List<Student> student) {
		this.students = student;
	}
	

	public String getStudent() {
		StringBuffer sb = new StringBuffer();
		if(students!=null) {
			for(Student p : students) {
				sb.append(p.getStudentName()+",");
			}
		}
		return sb.toString();
	}
	
	public String getSubject() {
		StringBuffer sb = new StringBuffer();
		if(subjects!=null) {
			for(Subjects a : subjects) {
				sb.append(a.getSubjectName()+",");
			}
		}
		return sb.toString();
	}
	


	public void setSubject(List<Subjects> subject) {
		this.subjects = subject;
	}
	
	
}
