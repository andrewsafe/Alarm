package com.pluralsight.alarms;

import java.awt.*;
import java.time.LocalDateTime;

public abstract class Alarm implements Widget, PersistentObject {
    protected boolean active;
    private final String message;
    private LocalDateTime snoozeUntil;

    public Alarm(String message) {
        this.message = message;
        stopSnoozing();
    }

    @Override
    public String getHelpText() {
        return "I'm an alarm. Turn on, off, or snooze.";
    }

    @Override
    public void save() {
        System.out.println("saving...");
    }

    public abstract Color getColor();

    public LocalDateTime getSnoozeUntil() {
        return snoozeUntil;
    }

    public void snooze() {
        if (active)
            snoozeUntil = LocalDateTime.now().plusMinutes(5);
    }

    public boolean isSnoozing() { return snoozeUntil.isAfter(LocalDateTime.now()); }

    public String getMessage() { return message; }

    public void turnOn() {
        active = true;
        stopSnoozing();
    }

    public void turnOff() {
        active = false;
        stopSnoozing();
    }

    public String getReport() { return getReport(false); }

    public String getReport(boolean uppercase) {
        if (active && !isSnoozing()) {
            if (uppercase)
                return message.toUpperCase();
            else
                return message;
        } else
            return "";
    }

    public void sendReport() {
        System.out.println(getReport(true));
    }

    @Override
    public String toString() {
        return getReport();
    }

    private void stopSnoozing() { snoozeUntil = LocalDateTime.now().minusSeconds(1); }

    public static void main(String[] args) {
        Alarm alarm = new HighVisibilityAlarm("We're almost out of donuts");
        System.out.println(alarm.getColor());
    }

//    public static void main(String[] args) throws InterruptedException {
//        Alarm alarm = new Alarm("Temperature too high");
//        alarm.turnOn();
//        alarm.snooze();
//        alarm.active = false;
//    }


}