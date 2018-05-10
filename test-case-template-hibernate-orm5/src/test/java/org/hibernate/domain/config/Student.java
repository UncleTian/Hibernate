package org.hibernate.domain.config;

public class Student {
	private Long id;
	private String name;
	private Integer age;
	private String address;
	private String telephone;
	private String email;
	private Teacher teacher;
	private HeadMaster headMaster;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public HeadMaster getHeadMaster() {
		return headMaster;
	}

	public void setHeadMaster(HeadMaster headMaster) {
		this.headMaster = headMaster;
	}
	
	@Override
	public String toString() {
		return "id:" + id + ", name:" + name + ",address:" + address
				+ "telephone:" + telephone + ",email" + email;
	}

}
