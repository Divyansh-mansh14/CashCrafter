package com.example.springsecuritysection9.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="customer_id")
    private int id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="email")
    private String email;
    
    @Column(name="mobile_number")
    private String mobileNumber;
    
//    for password we are using Json Property instead of Json Ignore
//    The reason is we need the password details from UI application to the backend, like whenever user is trying to log in or register himself,we need that password details inside the JSON request.
//    So that's why we should not use the JsonIgnore. 
//    Instead, we should use annotation @JsonProperty and we can define the access value as write only. 
//    With the write only, what I'm trying to say is I always want this field inside the request that is coming from the UI to the backend but I don't want to send the password details that I've loaded from that database back to the UI application. 
//    The reason why we're doing this is again for security reasons.We don't want to send that hash or password value that we loaded from the database over the network and to the UI application. There is a chance that it may get misused.
    @JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
    @Column(name="pwd")
    private String pwd;
    
    @Column(name="role")
    private String role;
    
    @Column(name="create_dt")
    private String createDt;
    
    @OneToMany(mappedBy="customer", fetch=FetchType.EAGER)
    private Set<Authority> authorities;

    public Customer() {
		super();
	}

	public Customer(int id, String name, String mobileNumber, String email, String pwd, String role, String createDt) {
		super();
		this.id = id;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.pwd = pwd;
		this.role = role;
		this.createDt = createDt;
	}

	// When we use JsonIgnore on a field then that field is not sent inside the json response to the ui application/frontrnd application
	@JsonIgnore
	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    public String getCreateDt() {
        return createDt;
    }

    public void setCreateDt(String createDt) {
        this.createDt = createDt;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
}