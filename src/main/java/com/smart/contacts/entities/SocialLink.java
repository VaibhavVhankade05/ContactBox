package com.smart.contacts.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
 class SocialLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false, length = 255)
    private String link;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(nullable = false, length = 100)
    private String title;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "contacts_id", nullable = false)
    private Contacts contacts;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Contacts getContacts() {
		return contacts;
	}

	public void setContacts(Contacts contacts) {
		this.contacts = contacts;
	}

	public SocialLink() {
		super();
	}

	public SocialLink(long id, @NotNull @Size(min = 1, max = 255) String link,
			@NotNull @Size(min = 1, max = 100) String title, @NotNull Contacts contacts) {
		super();
		this.id = id;
		this.link = link;
		this.title = title;
		this.contacts = contacts;
	}

	@Override
	public String toString() {
		return "SocialLink [id=" + id + ", link=" + link + ", title=" + title + ", contacts=" + contacts + "]";
	}
    
	
    
}
