/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author user
 */
public class StaffSchedule {
    private Person userID;
    private Date time;
    private String day;

    public StaffSchedule(Person userID, Date time, String day) {
        this.userID = userID;
        this.time = time;
        this.day = day;
    }

    public Person getUserID() {
        return userID;
    }

    public void setUserID(Person userID) {
        this.userID = userID;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "StaffSchedule{" + "userID=" + userID + ", time=" + time + ", day=" + day + '}';
    }
    
    
}
