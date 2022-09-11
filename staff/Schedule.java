package staff;

import java.util.Calendar;

public class Schedule {
    private Calendar startTime;
    private Calendar endTime;

    //Contructor for StaffSchedule
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
}
