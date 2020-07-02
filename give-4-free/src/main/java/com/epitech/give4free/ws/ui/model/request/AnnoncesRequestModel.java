package com.epitech.give4free.ws.ui.model.request;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class AnnoncesRequestModel {
    private String Title;
    private ArrayList<String> Description;
    private Date Date_debut;
    private Date Date_fin;
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
     * @return Array return the Description
     */
    public ArrayList<String> getDescription() {
        return Description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(ArrayList<String> Description) {
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

}