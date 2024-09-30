package com.pluralsight.alarms;

import java.awt.*;
import java.time.LocalTime;

public class TimeSensitiveAlarm extends Alarm {

    public TimeSensitiveAlarm(String message) { super(message); }

    public Color getColor() { return null; }

    public String getReport(boolean uppercase) {
        String report = super.getReport(uppercase);
        if (report.isEmpty())
            return report;
        else
            return LocalTime.now() + ": " + report;
    }
}