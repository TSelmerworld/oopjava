package hello;

import java.util.Scanner;

class Display {
    private int value;

    public Display(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getDisplayValue() {
        return String.format("%02d", value);
    }
}

class Clock {
    private Display hour;
    private Display minute;
    private Display second;

    public Clock(int hour, int minute, int second) {
        this.hour = new Display(hour);
        this.minute = new Display(minute);
        this.second = new Display(second);
    }

    public void tick() {
        second.setValue(second.getValue() + 1);
        if (second.getValue() == 60) {
            second.setValue(0);
            minute.setValue(minute.getValue() + 1);
            if (minute.getValue() == 60) {
                minute.setValue(0);
                hour.setValue(hour.getValue() + 1);
                if (hour.getValue() == 24) {
                    hour.setValue(0);
                }
            }
        }
    }

    @Override
    public String toString() {
        return hour.getDisplayValue() + ":" + minute.getDisplayValue() + ":" + second.getDisplayValue();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Clock clock = new Clock(in.nextInt(), in.nextInt(), in.nextInt());
        clock.tick();
        System.out.println(clock);

        in.close();
    }
}
