package com.epitech.give4free.ws.io.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="users")
public class UserEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7446659124812363211L;

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false)
	private String userId;
	// Emulated Id (safe to give on http)

	@Column(nullable = false, length = 50)
	private String firstName;

	@Column(nullable = false, length = 50)
	private String lastName;

	@Column(nullable = false, length = 120)
	private String email;

    @Column(nullable = true, length = 120)
	private String paypalEmail;

	@Column(nullable = false)
	private String encryptedPassword;

	private String emailVerificationToken;

	//@Column(nullable = false, columnDefinition = "boolean default false") correction code non portable
	//private Boolean emailVerificationStatus;
	@Column(nullable = false)
	private Boolean emailVerificationStatus = false;

	@OneToMany(mappedBy = "userDetails", cascade = CascadeType.ALL)	
	private List<AnnoncesEntity> annonces;


    /**
     * @return long return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return String return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return String return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String return the encryptedPassword
     */
    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    /**
     * @param encryptedPassword the encryptedPassword to set
     */
    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    /**
     * @return String return the emailVerificationToken
     */
    public String getEmailVerificationToken() {
        return emailVerificationToken;
    }

    /**
     * @param emailVerificationToken the emailVerificationToken to set
     */
    public void setEmailVerificationToken(String emailVerificationToken) {
        this.emailVerificationToken = emailVerificationToken;
    }

    /**
     * @return Boolean return the emailVerificationStatus
     */
    public Boolean isEmailVerificationStatus() {
        return emailVerificationStatus;
    }

    /**
     * @param emailVerificationStatus the emailVerificationStatus to set
     */
    public void setEmailVerificationStatus(Boolean emailVerificationStatus) {
        this.emailVerificationStatus = emailVerificationStatus;
    }

    /**
     * @return List<AnnoncesEntity> return the annonces
     */
    public List<AnnoncesEntity> getAnnonces() {
        return annonces;
    }

    /**
     * @param annonces the annonces to set
     */
    public void setAnnonces(List<AnnoncesEntity> annonces) {
        this.annonces = annonces;
    }


    /**
     * @return String return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }


    /**
     * @return String return the paypalEmail
     */
    public String getPaypalEmail() {
        return paypalEmail;
    }

    /**
     * @param paypalEmail the paypalEmail to set
     */
    public void setPaypalEmail(String paypalEmail) {
        this.paypalEmail = paypalEmail;
    }

}
