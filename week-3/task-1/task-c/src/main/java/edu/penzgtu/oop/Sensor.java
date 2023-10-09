package edu.penzgtu.oop;

class Sensor {
    double id;
    double temp;

    public Sensor(double id, double temp) {
        this.id = id;
        this.temp = temp;
    }

    @Override
    public String toString() {
        return String.format("%.0f %.1f", this.id, this.temp);
    }
}