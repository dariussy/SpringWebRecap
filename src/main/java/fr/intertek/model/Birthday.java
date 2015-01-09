package fr.intertek.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Birthday implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private Date dateCreation;
	private User gestionnaire;
	private String fistname;
	private String lastname;
	private Date dateCreate;
	private Integer age;
	private Date dateFete;
	private String description;
	
	@OneToMany
	private List<Invited> inviteds;
	@OneToMany
	private List<Idea> ideas;
	
	public Birthday() {
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public User getGestionnaire() {
		return gestionnaire;
	}
	public void setGestionnaire(User gestionnaire) {
		this.gestionnaire = gestionnaire;
	}
	public String getFistname() {
		return fistname;
	}
	public void setFistname(String fistname) {
		this.fistname = fistname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Date getDateCreate() {
		return dateCreate;
	}
	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getDateFete() {
		return dateFete;
	}
	public void setDateFete(Date dateFete) {
		this.dateFete = dateFete;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Invited> getInviteds() {
		return inviteds;
	}
	public void setInviteds(List<Invited> inviteds) {
		this.inviteds = inviteds;
	}
	public List<Idea> getIdeas() {
		return ideas;
	}
	public void setIdeas(List<Idea> ideas) {
		this.ideas = ideas;
	}
	
	
}
