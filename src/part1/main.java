package part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;



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
		ArrayList<ArrayList<Double>> dataset = new ArrayList<>(); // list of one_line

		// reading the file seeds_data.txt
		BufferedReader bf = new BufferedReader(
				new FileReader("C:\\Users\\soffi\\Documents\\GitHub\\DATAMINING\\ressources\\test.txt"));

		// reading all data lines : 1 2 3 4 5 6 7 8, 1 2 3 4 5 6 7 8 ....
		String tmp_line = bf.readLine();

		/*
		 * spliting a specific line to separate the attributes :
		 * one_line=[1,2,3,4,5,6,7,8] parsing one_line's values to double :
		 * [1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0] adding one_line to list_data :
		 * [[1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0],[1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0]....]
		 */

		while (tmp_line != null) {
			splitRow = tmp_line.split("\t+");
			one_line = new ArrayList<>();

			for (String s : splitRow) {
				one_line.add(Double.parseDouble(s));
			}

			dataset.add(one_line);
			c++;
			tmp_line = bf.readLine();

		}

		// printing list
		System.out.print(dataset);
		System.out.println("\n Reading dataset ends \n");

		
/*
 * ####2 : Calculating Central Tendency Metrics
 */
		
		
		
		
/*
 * test of all methods
 */
		ManipData m = new ManipData();
		ArrayList<Double> example = new ArrayList<>();
		ArrayList<Double> x = new ArrayList<>();

		
		example.add(1.1);
		example.add(1.2);
		example.add(1.3);
		example.add(7.0);
		example.add(1.5);
		example.add(3.9);
		example.add(3.0);
	
		
		// trying add row method : checked
		dataset = m.addData(dataset, example);
		System.out.println("add row to data " + dataset);

		// trying alter rown with num att method : checked
		dataset = m.AlterRowN(dataset, 0, 1, 0.0);
		System.out.println("alter row having row index" + dataset);

		// trying get row given a pos : checked
		x = m.GetRow(dataset,0);
		System.out.println("get row having row index" + x);

		// trying get pos of row : checked
		int y;
		ArrayList<Double> temp = new ArrayList<>();
		Double[] t = new Double[] { 0.4, 1.1, 43.0 };
		temp.addAll(Arrays.asList(t));
		y = m.GetPos(dataset, temp);
		System.out.println("get pos having row " + (y + 1));

		// trying rowexists method : checked
		boolean b;
		Double[] tt = new Double[] { 0.4, 1.1 };
		temp.addAll(Arrays.asList(tt));
		b = m.RowExists(dataset, temp);
		System.out.println("existance " + b);

		// trying drop method
		ArrayList<Double> dropp = new ArrayList<>();
		Double[] f = new Double[] { 0.0, 14.84, 0.871, 5.763, 3.312, 2.221, 5.22, 1.0 };
		dropp.addAll(Arrays.asList(f));
		dataset = m.DropData(dataset, dropp);
		System.out.println("drop " + dataset);

		// trying getattribute method2
		ArrayList<Double> r = new ArrayList<>();
		r = m.GetAttribute(dataset, 0);
		System.out.println("att  " + r);
		System.out.println("size " + dataset.size());
		System.out.println("min  " + m.GetMin(r));
		System.out.println("max  " + m.GetMax(r));
		
		// trying getattribute method
		ArrayList<ArrayList<Double>> rr = new ArrayList<>();
		rr = m.GetAttribute(dataset, 0, 1);
		System.out.println(" 2 att " + rr);
		
		// trying getfrequencies
		//ArrayList<ArrayList<Double>> u = new ArrayList<>();
		 ArrayList<ArrayList<Double>> u = new ArrayList<>();

		u = m.GetFrequencies(example);
		System.out.println(" freq " + u);
		
		
		//trying list of list to .txt file
		 
		m.ListToFile(dataset);
		m.setData(dataset);
		CentralTendencyM mm=new CentralTendencyM();
		System.out.println("example "+example+" mean " +mm.GetMean(example)+ " median" +mm.GetMedian(example)+"midrange "+mm.GetMidRange(example));
		System.out.println("ex "+example+" max " +m.GetMax(example)+ " min" +m.GetMin(example));
		// trying sorting method checked
		x = m.SortAttribute(example);
		System.out.println("sorted data " + x);

	}

}