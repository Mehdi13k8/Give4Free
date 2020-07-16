package com.epitech.give4free.ws.ui.model.response;

import java.util.List;

import com.epitech.give4free.ws.shared.dto.AnnoncesDTO;

public class UserRest {
	private String userId;
	private String firstName;
	private String lastName;
	private String email;
	private List<AnnoncesDTO> annonces;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    /**
     * @return List<AnnoncesDTO> return the annonces
     */
    public List<AnnoncesDTO> getAnnonces() {
        return annonces;
    }

    /**
     * @param annonces the annonces to set
     */
    public void setAnnonces(List<AnnoncesDTO> annonces) {
        this.annonces = annonces;
    }

}
