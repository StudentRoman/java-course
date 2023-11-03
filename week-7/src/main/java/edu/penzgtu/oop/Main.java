package edu.penzgtu.oop;

public class Main {
    public static void main(String[] args) {
        DatasetGenerator generator = new DatasetGenerator();
        var dataset = generator.generateBrackets(7);

        LogarithmicChart logarithmicChart = new LogarithmicChart(
                "График временной сложности",
                "n",
                "T(n), нс",
                dataset
        );
        logarithmicChart.pack();
        logarithmicChart.setVisible(true);
    }
}
