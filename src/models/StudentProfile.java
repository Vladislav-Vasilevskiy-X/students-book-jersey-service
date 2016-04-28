package models;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StudentProfile implements Serializable {

	private static final long serialVersionUID = -8450092588601390728L;
	private String id;
	private String name;
	private String age;
	private String speciality;
	private String course;
	private String faculty;
	private String university;
	private String averageValue;
	private String description;

	public StudentProfile(String id, String name, String age, String speciality, String course, String faculty,
			String univ, String averageValue, String description) {
		this.setId(id);
		this.setName(name);
		this.setAge(age);
		this.setSpeciality(speciality);
		this.setCourse(course);
		this.setFaculty(faculty);
		this.setUniversity(univ);
		this.setAverageValue(averageValue);
		this.setDescription(description);
	}

	public StudentProfile(String id, StudentProfile profile) {
		this.setId(id);
		this.setName(profile.getName());
		this.setAge(profile.getAge());
		this.setSpeciality(profile.getSpeciality());
		this.setCourse(profile.getCourse());
		this.setFaculty(profile.getFaculty());
		this.setUniversity(profile.getUniversity());
		this.setAverageValue(profile.getAverageValue());
		this.setDescription(profile.getDescription());
	}

	// Stuck
	public StudentProfile() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAverageValue() {
		return averageValue;
	}

	public void setAverageValue(String averageValue) {
		this.averageValue = averageValue;
	}
}
