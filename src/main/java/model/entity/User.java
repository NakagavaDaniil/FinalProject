package model.entity;

import java.util.Date;

public class User {

  private int ID;
  private  String USER_FIRST_NAME;
  private  String USER_LAST_NAME;
  private  Date BIRTH_DATE;
  private  String USER_LOGIN;
  private  String USER_PASSWORD;
  private  String EMAIL;

    public User(String USER_FIRST_NAME, String USER_LAST_NAME, Date BIRTH_DATE, String USER_LOGIN, String USER_PASSWORD, String EMAIL) {
        this.USER_FIRST_NAME = USER_FIRST_NAME;
        this.USER_LAST_NAME = USER_LAST_NAME;
        this.BIRTH_DATE = BIRTH_DATE;
        this.USER_LOGIN = USER_LOGIN;
        this.USER_PASSWORD = USER_PASSWORD;
        this.EMAIL = EMAIL;
    }

    public User() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUSER_FIRST_NAME() {
        return USER_FIRST_NAME;
    }

    public void setUSER_FIRST_NAME(String USER_FIRST_NAME) {
        this.USER_FIRST_NAME = USER_FIRST_NAME;
    }

    public String getUSER_LAST_NAME() {
        return USER_LAST_NAME;
    }

    public void setUSER_LAST_NAME(String USER_LAST_NAME) {
        this.USER_LAST_NAME = USER_LAST_NAME;
    }

    public String getUSER_LOGIN() {
        return USER_LOGIN;
    }

    public void setUSER_LOGIN(String USER_LOGIN) {
        this.USER_LOGIN = USER_LOGIN;
    }

    public String getUSER_PASSWORD() {
        return USER_PASSWORD;
    }

    public void setUSER_PASSWORD(String USER_PASSWORD) {
        this.USER_PASSWORD = USER_PASSWORD;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public java.sql.Date getBIRTH_DATE() {
        return (java.sql.Date) BIRTH_DATE;
    }

    public void setBIRTH_DATE(Date BIRTH_DATE) {
        this.BIRTH_DATE = BIRTH_DATE;
    }




}
