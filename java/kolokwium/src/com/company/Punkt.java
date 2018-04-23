package com.company;

public class Punkt {
    double x = 0;
    double y = 0;

    public Punkt(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void przesun(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public String toString() {
        return "Punkt{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
