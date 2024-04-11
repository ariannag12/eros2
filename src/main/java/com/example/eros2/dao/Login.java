/*
 * Java / RDBMS integration by JDBC
 * 
 * https://github.com/egalli64/jd
 */
package com.example.eros2.dao;

import java.sql.Date;

public class Login {
    private String email;
    private String password;
    private String userName;
    private String firstName;
    private String lastName;
    private String gender;
    private Date birthdate;
    private int userProfileID;
    private String sport;
    private String viaggiare;
    private String lettura;
    private String fumatore;
    
    public Login() {
    }
    
    public Login(String userName, String firstName, String lastName) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Login(String userName, String firstName, String lastName, String email, String password, String gender, Date birthdate, int userProfileID, String sport, String viaggiare, String lettura, String fumatore) {
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

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getViaggiare() {
        return viaggiare;
    }

    public void setViaggiare(String viaggiare) {
        this.viaggiare = viaggiare;
    }

    public String getLettura() {
        return lettura;
    }

    public void setLettura(String lettura) {
        this.lettura = lettura;
    }

    public String getFumatore() {
        return fumatore;
    }

    public void setFumatore(String fumatore) {
        this.fumatore = fumatore;
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
