package com.los.cmisbackend.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/*
+----------+--------------+------+-----+-----------+-------------------+
| Field    	| Type        	| Null 	| Default  	| Extra             |
+----------+--------------+------+-----+-----------+-------------------+
| id       	| varchar(11) 	| NO  	|      		|  AUTO_INCREMENT   |
| name     	| varchar(45) 	| NO  	| 	NULL   	|                   |
| email    	| varchar(45) 	| NO  	|  	NULL  	|                   |
| info 		| varchar(120)	| YES 	|	NULL	|					|
| password 	| varchar(60) 	| NO 	|	NULL 	|                   |
+----------+--------------+------+-----+-----------+-------------------+
*/

@Entity
@Table(name="community")
public class Community {
	
	@Id
	@Column(name="id")
	private Long id;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@MapsId
	@JoinColumn(name= "user_id")
	private User user;

	@Column(name="info", length = 120)
	private String info;

	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			})
	@JoinTable(name = "community_follower",
			joinColumns = { @JoinColumn(name = "community_id") },
			inverseJoinColumns = { @JoinColumn(name = "student_id") })
	private Set<Student> followers = new HashSet<>();

	@Lob
	@Column(name = "image", nullable = true, columnDefinition = "MEDIUMBLOB", length = Integer.MAX_VALUE)
    private String image;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "community_tag",
			joinColumns = @JoinColumn(name = "community_id"),
			inverseJoinColumns = @JoinColumn(name = "tag_id"))
	private Set<Tag> tags = new HashSet<>();

	public Community() {
	}

	public Community(User user, String info, Set<Student> followers, String image, Set<Tag> tags) {
		this.user = user;
		this.info = info;
		this.followers = followers;
		this.image = image;
		this.tags = tags;
	}

	public Community(String info) {
		this.info = info;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Set<Student> getFollowers() {
		return followers;
	}

	public void setFollowers(Set<Student> followers) {
		this.followers = followers;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void addFollower(Student follower) {
		followers.add(follower);
	}

	public void removeFollower(Student follower) {
		followers.remove(follower);
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public void addTag(Tag tag) {
		tags.add(tag);
	}

	public void removeTag(Tag tag) {
		tags.remove(tag);
	}
}
