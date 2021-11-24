package application;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BoxAndWhiskerRenderer;
import org.jfree.data.statistics.DefaultBoxAndWhiskerCategoryDataset;

public class BoxPlot {

    private static final int COLS = 20;
    private static final int VISIBLE = 1;
    private static final int ROWS = 7;
    private static final int VALUES = 10;
    private static final Random rnd = new Random();
    private List<String> columns;
    private ArrayList<ArrayList<Double>> data;
    private DefaultBoxAndWhiskerCategoryDataset dataset;
    private CategoryPlot plot;
    private ChartPanel chartPanel;
    private JPanel controlPanel;
    private int start = 0;
    // CREATE THE BOXPLOT
    public BoxPlot(ArrayList<ArrayList<Double>> _list) {
        //createData(_list);
        createDataset(start, _list);
        createChartPanel();
    }

    // CREATE THE DATASET(IMPORT)
    private void createDataset(int start, ArrayList<ArrayList<Double>> _list) {
        dataset = new DefaultBoxAndWhiskerCategoryDataset();
            int row = 1;
            for (ArrayList<Double> atr : _list) {
                dataset.add(atr, "A" + row++, "Attribut");
            }
    }

    // SETUP THE BOXPLOT
    private void createChartPanel() {
        CategoryAxis xAxis = new CategoryAxis("Attributes");
        NumberAxis yAxis = new NumberAxis("Value");
        BoxAndWhiskerRenderer renderer = new BoxAndWhiskerRenderer();
        plot = new CategoryPlot(dataset, xAxis, yAxis, renderer);
        JFreeChart chart = new JFreeChart("Boites à moustaches", plot);
        chartPanel = new ChartPanel(chart);
    }

    public ChartPanel getChartPanel() {
        return chartPanel;
    }

    public JPanel getControlPanel() {
        return controlPanel;
    }
}