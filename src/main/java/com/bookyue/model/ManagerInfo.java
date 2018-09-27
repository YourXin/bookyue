package com.bookyue.model;

public class ManagerInfo {
    private Integer managerId;

    private String managerPassword;

    private String managerFullname;

    private String managerPhone;

    private String managerEmail;

    private String managerIdcard;

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword == null ? null : managerPassword.trim();
    }

    public String getManagerFullname() {
        return managerFullname;
    }

    public void setManagerFullname(String managerFullname) {
        this.managerFullname = managerFullname == null ? null : managerFullname.trim();
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone == null ? null : managerPhone.trim();
    }

    public String getManagerEmail() {
        return managerEmail;
    }

    public void setManagerEmail(String managerEmail) {
        this.managerEmail = managerEmail == null ? null : managerEmail.trim();
    }

    public String getManagerIdcard() {
        return managerIdcard;
    }

    public void setManagerIdcard(String managerIdcard) {
        this.managerIdcard = managerIdcard == null ? null : managerIdcard.trim();
    }
}