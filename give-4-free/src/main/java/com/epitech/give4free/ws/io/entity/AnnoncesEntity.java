package com.epitech.give4free.ws.io.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "annonces")
public class AnnoncesEntity implements Serializable {

    /**
     * quand t'implemente serializable il faut defenire cette variable
     */
    private static final long serialVersionUID = 8005375163832215042L;

    @Id
    @GeneratedValue
    private long id;

    @Column(length = 50, nullable = false)
    private String annoncesId;

    @Column(length = 50, nullable = false)
    private String Title;

    //array
    @Column(length = 5000, nullable = false)
    private String Description;

    @Column(length = 50, nullable = false)
    private String Date_debut;
    @Column(length = 50, nullable = false)
    private String Date_fin;

    @Basic(fetch = FetchType.LAZY)
    @Column(columnDefinition = "LONGBLOB")
    private String image;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private UserEntity userDetails;

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
     * @return String return the annoncesId
     */
    public String getAnnoncesId() {
        return annoncesId;
    }

    /**
     * @param annoncesId the annoncesId to set
     */
    public void setAnnoncesId(String annoncesId) {
        this.annoncesId = annoncesId;
    }

    /**
     * @return String return the Title
     */
    public String getTitle() {
        return Title;
    }

    /**
     * @param Title the Title to set
     */
    public void setTitle(String Title) {
        this.Title = Title;
    }

    /**
     * @return String return the Date_debut
     */
    public String getDate_debut() {
        return Date_debut;
    }

    /**
     * @param Date_debut the Date_debut to set
     */
    public void setDate_debut(String Date_debut) {
        this.Date_debut = Date_debut;
    }

    /**
     * @return String return the Date_fin
     */
    public String getDate_fin() {
        return Date_fin;
    }

    /**
     * @param Date_fin the Date_fin to set
     */
    public void setDate_fin(String Date_fin) {
        this.Date_fin = Date_fin;
    }

    /**
     * @return String return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return UserEntity return the userDetails
     */
    public UserEntity getUserDetails() {
        return userDetails;
    }

    /**
     * @param userDetails the userDetails to set
     */
    public void setUserDetails(UserEntity userDetails) {
        this.userDetails = userDetails;
    }

    /**
     * @return String return the Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }

}