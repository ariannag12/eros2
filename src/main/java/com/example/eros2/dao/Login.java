/*
 * Java / RDBMS integration by JDBC
 * 
 * https://github.com/egalli64/jd
 */
package com.example.eros2.dao;

import java.sql.Date;

public class Login {
    private int userID;
    private String email;
    private String password;
    private String userName;
    private String firstName;
    private String lastName;
    private String gender;
    private Date birthdate;
    private int userProfileID;
    private Boolean sport;       // Changed to Boolean
    private Boolean viaggiare;   // Changed to Boolean
    private Boolean lettura;     // Changed to Boolean
    private String fumatore;
    
    public Login() {
    }
    
    public Login(String userName, String firstName, String lastName) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Login(String userName, String firstName, String lastName, String email, String password, String gender, Date birthdate, int userProfileID, Boolean sport, Boolean viaggiare, Boolean lettura, String fumatore) {
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthdate = birthdate;
        this.userProfileID = userProfileID;
        this.sport = sport;
        this.viaggiare = viaggiare;
        this.lettura = lettura;
        this.fumatore = fumatore;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public int getUserProfileID() {
        return userProfileID;
    }

    public void setUserProfileID(int userProfileID) {
        this.userProfileID = userProfileID;
    }

    public Boolean getSport() {
        return sport;
    }

    public void setSport(Boolean sport) {
        this.sport = sport;
    }

    public Boolean getViaggiare() {
        return viaggiare;
    }

    public void setViaggiare(Boolean viaggiare) {
        this.viaggiare = viaggiare;
    }

    public Boolean getLettura() {
        return lettura;
    }

    public void setLettura(Boolean lettura) {
        this.lettura = lettura;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Login [email=" + email + ", password=" + password + ", userName=" + userName + ", firstName="
                + firstName + ", lastName=" + lastName + ", gender=" + gender + ", birthdate=" + birthdate
                + ", userProfileID=" + userProfileID + ", sport=" + sport + ", viaggiare=" + viaggiare + ", lettura="
                + lettura + ", fumatore=" + fumatore + "]";
    }
}
