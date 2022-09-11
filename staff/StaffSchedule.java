package staff;

import general.Person;
import java.util.Date;

public class StaffSchedule {
    private Person userID;
    private Date time;
    private String day;

    //Contructor for StaffSchedule
    public StaffSchedule(Person userID, Date time, String day){
        this.userID = userID;
        this.time = time;
        this.day = day;
    }

    //Getter for userID
    public Person getUserID(){
        return userID;
    }

    //Setter for userID
    public void setUserID(){
        this.userID = userID;
    }

    //Getter for time
    public Date getTime(){
        return time;
    }

    //Setter for time
    public void setTime(){
        this.time = time;
    }

    //Getter for day
    public String getDay(){
        return day;
    }

    //Setter for day
    public void setDay(){
        this.day = day;
    }
}
