package com.los.cmisbackend.payload.request;

import javax.validation.constraints.NotBlank;

public class PasswordUpdateRequest {

    @NotBlank
    private String oldPassword;

    @NotBlank
    private String newPassword;

    public PasswordUpdateRequest() {
    }

    public PasswordUpdateRequest(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
