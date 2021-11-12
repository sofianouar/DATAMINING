package part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.util.List;

public class main {

	public static void main(String[] args) throws IOException {
		/*
		 * ####1 : READING DATA
		 */

		System.out.println("\n Reading dataset...");

		// Decalarations
		int c = 0;
		String[] splitRow;
		ArrayList<Double> one_line = new ArrayList<>(); // contains all attributes of one specific line
		ArrayList<ArrayList<Double>> list_data = new ArrayList<>(); // list of one_line

		// reading the file seeds_data.txt
		BufferedReader bf = new BufferedReader(
				new FileReader("C:\\Users\\soffi\\Documents\\GitHub\\DATAMINING\\ressources\\test.txt"));

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
		System.out.println("\n Reading dataset ends \n");
		
		
		/*
		 * test of all methods
		 */
		ManipData m=new ManipData();
		ArrayList <Double> example=new ArrayList<>();
		ArrayList <Double> x=new ArrayList<>();
		
		//trying  sorting method checked
		example.add(1.1);
		example.add(0.4);
		example.add(43.0);
		
		x=m.SortAttribute(example);
		System.out.println("sorted data "+x);
		
		//trying add row method  : checked
		list_data=m.addData(list_data,example);
		System.out.println("add row to data "+list_data);
		
		
		//trying alter rown with num att method : checked
		list_data=m.AlterRowN(list_data,0,1, 0.0);
		System.out.println("alter row having row index"+list_data);

		
		//trying get row given a pos : checked
		x=m.GetRow(list_data,0);
		System.out.println("get row having row index"+x);
		
		//trying get pos of row : checked
		int y;
		ArrayList<Double> temp= new ArrayList<>();
		Double[] t = new Double[] {0.4, 1.1, 43.0};
		temp.addAll(Arrays.asList(t));
		y=m.GetPos(list_data,temp);
		System.out.println("get pos having row "+(y+1));
	
		//trying rowexists method : checked
		boolean b;
		Double[] tt = new Double[] {0.4, 1.1};
		temp.addAll(Arrays.asList(tt));
		b=m.RowExists(list_data,temp);
		System.out.println("existance "+b);
		
	
		//trying drop method
		ArrayList<Double> dropp= new ArrayList<>();
		Double[] f = new Double[] {0.0, 14.84, 0.871, 5.763, 3.312, 2.221, 5.22, 1.0};
		dropp.addAll(Arrays.asList(f));
		list_data=m.DropData(list_data,dropp);
		System.out.println("drop "+list_data);
	}

}


/*
 * partie 2  diagramme de dispersion
		XYSeriesCollection colct = new XYSeriesCollection();
		XYSeries serie = new XYSeries("");

//JFreeChart charrt = ChartFactory.createScatterPlot("","","","");
 */
