package com.smart.contacts.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;

@Entity
public class User implements UserDetails
{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id", updatable = false, nullable = false, unique = true)
    private String userId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "email", nullable = false, unique = true, length = 150)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "profile_picture", length = 255) 
    private String profilePic;
    
    @Column(name = "phone", length = 255) 
    private String phoneNumber;
    
    @Column(name = "about", length = 255)
    private String about;

    @Column(name = "enabled", nullable = false)
    private boolean enabled = true;

    @Column(name = "phone_verified", nullable = false)
    private boolean phoneVerified = false;
    
    @Column(name = "email_verified", nullable = false)
    private boolean emailVerified = false;

    @Enumerated(EnumType.STRING)
    @Column(name = "provider", nullable = false, length = 20)
    private Providers provider = Providers.SELF;

    @Column(name = "provider_user_id", length = 255)
    private String providerUserId;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Contacts> contacts = new ArrayList<>();

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isPhoneVerified() {
		return phoneVerified;
	}

	public void setPhoneVerified(boolean phoneVerified) {
		this.phoneVerified = phoneVerified;
	}
	
	public boolean isEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(boolean phoneVerified) {
		this.emailVerified = emailVerified;
	}

	public Providers getProvider() {
		return provider;
	}

	public void setProvider(Providers provider) {
		this.provider = provider;
	}

	public String getProviderUserId() {
		return providerUserId;
	}

	public void setProviderUserId(String providerUserId) {
		this.providerUserId = providerUserId;
	}

	public List<Contacts> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contacts> contacts) {
		this.contacts = contacts;
	}

	public User() {
		super();
	}

	public User(String userId, String name, String email, String password, String profilePic, String phoneNumber,
			String about, boolean enabled, boolean phoneVerified, boolean emailVerified, Providers provider, String providerUserId,
			List<Contacts> contacts) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.profilePic = profilePic;
		this.phoneNumber = phoneNumber;
		this.about = about;
		this.enabled = enabled;
		this.phoneVerified = phoneVerified;
		this.emailVerified = emailVerified;
		this.provider = provider;
		this.providerUserId = providerUserId;
		this.contacts = contacts;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", profilePic=" + profilePic + ", phoneNumber=" + phoneNumber + ", about=" + about + ", enabled="
				+ enabled + ", phoneVerified=" + phoneVerified + ", emailVerified=\" + emailVerified + , provider=" + provider + ", providerUserId="
				+ providerUserId + ", contacts=" + contacts + "]";
	}
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roleList = new ArrayList<>();

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() 
	{
		Collection<SimpleGrantedAuthority> roles = roleList.stream()
        .map(role -> new SimpleGrantedAuthority(role))
        .collect(Collectors.toList());
		
		return roles;
	}

	public List<String> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<String> roleList) {
		this.roleList = roleList;
	}

	@Override
	public String getUsername() {
		return this.email;
	}
	
	@Override
	public boolean isAccountNonExpired() {
	   return true;
	}
	
	
	@Override
	public boolean isAccountNonLocked() {
	    return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
	    return true; 
	} 
   
}
