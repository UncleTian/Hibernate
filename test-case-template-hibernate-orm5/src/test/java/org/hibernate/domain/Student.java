package org.hibernate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="name")
	private String name = "bigwang";
	@Column(name="age")
	private Integer age;
	@Column(name="address")
	private String address;
	@Column(name="telephone")
	private String telephone;
	@Column(name="email")
	private String email;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		name = generateName();
		return name;
	}
	
	private String generateName() {
		return "Heifenglei";
	}
	
	public void setName(String name) {
		//this.name = name;
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
	@Override
	public String toString() {
		return "id:" + id + ", name:" + name + ",address:" + address
				+ "telephone:" + telephone + ",email" + email;
	}
	
	
}
