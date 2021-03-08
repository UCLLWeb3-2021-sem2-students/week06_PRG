package be.ucll.week06_PRG.domain.model;

import java.time.LocalTime;

public class Activity {
    private String type;
    private LocalTime time;

    public Activity(String type, LocalTime time) {
        if (isValidType(type))
            this.type = type;
        else this.type = "home";
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (isValidType(type)) {
            this.type = type;
        } else throw new IllegalArgumentException("No valid type");
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    private boolean isValidType(String type) {
        return type != null && type.length() > 0;
    }
}
