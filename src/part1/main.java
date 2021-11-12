package part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Reading dataset...");
		ArrayList<ArrayList<Double>> list = new ArrayList<>();

		ArrayList<Double> lineAtt = new ArrayList<>();

		BufferedReader bf = new BufferedReader(
				new FileReader("C:\\Users\\soffi\\Documents\\M1 S1\\projects\\src\\seeds_dataset.txt"));

		String str = bf.readLine();
		String[] splitRow;
		int c = 0;
		while (str != null) {
			splitRow = str.split("\t+");
			lineAtt = new ArrayList<>();

			for (String s : splitRow) {
				lineAtt.add(Double.parseDouble(s));
			}

			list.add(lineAtt);
			c++;
			str = bf.readLine();

		}

		System.out.print(list);

//partie 2  diagramme de dispersion
		XYSeriesCollection colct = new XYSeriesCollection();
		XYSeries serie = new XYSeries("");

//JFreeChart charrt = ChartFactory.createScatterPlot("","","","");
	}

}
