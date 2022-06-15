package com.voron.mispi_4;

public class Dot {
    private final double x;
    private final double y;
    private final double r;
    private final String executionTime;
    private final String localTime;
    private final boolean result;

    public Dot(double x, double y, double r,
               String executionTime, String localTime, boolean result) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.executionTime = executionTime;
        this.localTime = localTime;
        this.result = result;
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public Double getR() {
        return r;
    }

    public String getExecutionTime() {
        return executionTime;
    }

    public String getLocalTime() {
        return localTime;
    }

    public boolean isResult() {
        return result;
    }
}
