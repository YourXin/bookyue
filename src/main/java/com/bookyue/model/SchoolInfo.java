package com.bookyue.model;

public class SchoolInfo {
    private Short schoolId;

    private String schoolName;

    public Short getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Short schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName == null ? null : schoolName.trim();
    }
}