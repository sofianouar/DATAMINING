package part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class main {

	public static void main(String[] args) throws IOException {
		/*
		 * ####1 : READING DATA
		 */

		System.out.println("Reading dataset...");

		// Decalarations
		int c = 0;
		String[] splitRow;
		ArrayList<Double> one_line = new ArrayList<>(); // contains all attributes of one specific line
		ArrayList<ArrayList<Double>> list_data = new ArrayList<>(); // list of one_line

		// reading the file seeds_data.txt
		BufferedReader bf = new BufferedReader(
				new FileReader("C:\\Users\\soffi\\Documents\\GitHub\\DATAMINING\\ressources\\seeds_dataset.txt"));

		// reading all data lines : 1 2 3 4 5 6 7 8, 1 2 3 4 5 6 7 8 ....
		String tmp_line = bf.readLine();

		// spliting a specific line to separate the attributes :
		// one_line=[1,2,3,4,5,6,7,8]
		// parsing one_line's values to double : [1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0]
		// adding one_line to list_data :
		// [[1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0],[1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0]....]

		while (tmp_line != null) {
			splitRow = tmp_line.split("\t+");
			one_line = new ArrayList<>();

			for (String s : splitRow) {
				one_line.add(Double.parseDouble(s));
			}

			list_data.add(one_line);
			c++;
			tmp_line = bf.readLine();

		}

		// printing list
		System.out.print(list_data);
		System.out.println("Reading dataset ends ");


	}

}


/*
 * partie 2  diagramme de dispersion
		XYSeriesCollection colct = new XYSeriesCollection();
		XYSeries serie = new XYSeries("");

//JFreeChart charrt = ChartFactory.createScatterPlot("","","","");
 */
