package com.epitech.give4free.ws.ui.model.response;

import java.util.Date;

import com.epitech.give4free.ws.shared.dto.UserDto;

public class AnnoncesRest {
    private String adressId;
    private String Title;
    private String Description;
    private Date Date_debut;
    private Date Date_fin;
    private String image;
    private UserDto userDetails;

    /**
     * @return String return the adressId
     */
    public String getAdressId() {
        return adressId;
    }

    /**
     * @param adressId the adressId to set
     */
    public void setAdressId(String adressId) {
        this.adressId = adressId;
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

    /**
     * @return Date return the Date_debut
     */
    public Date getDate_debut() {
        return Date_debut;
    }

    /**
     * @param Date_debut the Date_debut to set
     */
    public void setDate_debut(Date Date_debut) {
        this.Date_debut = Date_debut;
    }

    /**
     * @return Date return the Date_fin
     */
    public Date getDate_fin() {
        return Date_fin;
    }

    /**
     * @param Date_fin the Date_fin to set
     */
    public void setDate_fin(Date Date_fin) {
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
     * @return UserDto return the userDetails
     */
    public UserDto getUserDetails() {
        return userDetails;
    }

    /**
     * @param userDetails the userDetails to set
     */
    public void setUserDetails(UserDto userDetails) {
        this.userDetails = userDetails;
    }

}