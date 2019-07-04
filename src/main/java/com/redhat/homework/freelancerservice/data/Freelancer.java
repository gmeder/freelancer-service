package com.redhat.homework.freelancerservice.data;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="freelancer")
public class Freelancer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="freelancer_id")
    private Long freelancerId;

	@Column(name="first_name")
    private String firstName;

	@Column(name="last_name")
    private String lastName;

	@Column(name="email_address")
    private String emailAddress;


    @ManyToMany
    @JoinTable(
  		  name = "freelancer_skills", 
  		  joinColumns = @JoinColumn(name = "freelancer_id"), 
  		  inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private List<Skill> skills;

	public Long getFreelancerId() {
		return freelancerId;
	}

	public void setFreelancerId(Long freelancerId) {
		this.freelancerId = freelancerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
    
    


}
