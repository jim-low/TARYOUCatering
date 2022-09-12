package staff;

import java.util.Calendar;

public class Schedule {
    private Calendar startTime;
    private Calendar endTime;

    public Schedule(){
        this.startTime = Calendar.getInstance();
        this.endTime = Calendar.getInstance();
    }

    public Calendar getStartTime() {
        return startTime;
    }

    public void setStartTime(int hour, int minute) {
        startTime.set(Calendar.HOUR, hour);
        startTime.set(Calendar.MINUTE, minute);
    }

    public Calendar getEndTime() {
        return endTime;
    }

    public void setEndTime(int hour, int minute) {
        endTime.set(Calendar.HOUR, hour);
        endTime.set(Calendar.MINUTE, minute);
    }

    public void setDay(int num) {
        startTime.set(Calendar.DAY_OF_WEEK, num);
        endTime.set(Calendar.DAY_OF_WEEK, num);
    }

    public static String getNameOfDay(int number) {
        String[] weekNames = {
            "Sunday",
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday",
            "Saturday",
        };
        return weekNames[number - 1];
    }

    @Override
    public String toString() {
        String nameOfDay = getNameOfDay(startTime.get(Calendar.DAY_OF_WEEK));
        String startTimeAMPM = startTime.get(Calendar.AM_PM) == 1 ? "am" : "pm";
        String endTimeAMPM = endTime.get(Calendar.AM_PM) == 1 ? "am" : "pm";
        return String.format("%-15s%d%s - %d%s", nameOfDay, startTime.get(Calendar.HOUR), startTimeAMPM, endTime.get(Calendar.HOUR), endTimeAMPM);
    }
}
