package edu.penzgtu.oop;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
class Sensor {
    @Getter
    @Setter
    private double id;

    @Getter
    @Setter
    private double temp;

    @Override
    public String toString() {
        return String.format("%.0f %.1f", this.id, this.temp);
    }
}