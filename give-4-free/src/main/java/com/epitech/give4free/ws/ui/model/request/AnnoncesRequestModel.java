package com.epitech.give4free.ws.ui.model.request;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnnoncesRequestModel {
    private String Title;
    private String Description;
    private String Date_debut;
    private String Date_fin;
    private String image;
    private String userId;

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
