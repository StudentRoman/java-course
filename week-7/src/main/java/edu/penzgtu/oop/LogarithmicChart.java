package edu.penzgtu.oop;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.LogarithmicAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import java.awt.*;

import java.util.Map;

public class LogarithmicChart extends JFrame {

    private String chartName = "";
    private String xAxisLabel = "";
    private String yAxisLabel = "";
    private Map<Integer, Long> data;

    public LogarithmicChart() {
        initUI();
    }

    public LogarithmicChart(String chartName, String xAxisLabel, String yAxisLabel, Map<Integer, Long> data) {
        this.chartName = chartName;
        this.xAxisLabel = xAxisLabel;
        this.yAxisLabel = yAxisLabel;
        this.data = data;
        initUI();
    }

    private void initUI() {
        XYDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

        pack();
        setTitle("Logarithmic Chart");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private XYDataset createDataset() {
        var series = new XYSeries("");

        for (Map.Entry<Integer, Long> entry : data.entrySet()) {
            series.add(entry.getKey(), entry.getValue());
        }

        var dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        return dataset;
    }

    private JFreeChart createChart(XYDataset dataset) {

        JFreeChart chart = ChartFactory.createXYLineChart(
                this.chartName,
                this.xAxisLabel,
                this.yAxisLabel,
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();

        NumberAxis domainAxis = new NumberAxis(this.xAxisLabel);
        NumberAxis rangeAxis = new LogarithmicAxis(this.yAxisLabel);

        plot.setDomainAxis(domainAxis);
        plot.setRangeAxis(rangeAxis);

        var renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);

        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);

        chart.getLegend().setFrame(BlockBorder.NONE);

        chart.setTitle(new TextTitle(this.chartName, new Font("Serif", java.awt.Font.BOLD, 18)));

        return chart;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var ex = new LogarithmicChart();
            ex.setVisible(true);
        });
    }
}