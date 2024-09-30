package com.pluralsight.alarms;

import java.awt.*;

public final class HighVisibilityAlarm extends Alarm {

    public HighVisibilityAlarm(String message) { super(message); }

    public Color getColor() { return Color.ORANGE; }

    public String getReport(boolean uppercase) {
        String report = super.getReport(uppercase);
        if (report.isEmpty())
            return report;
        else
            return report + "!";
    }

//    public static void main(String[] args) {
//        HighVisibilityAlarm alarm = new HighVisibilityAlarm("Temperature too high");
//        alarm.turnOn();
//        alarm.sendReport();
//    }
}