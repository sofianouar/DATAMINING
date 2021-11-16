package part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class main {

	public static void main(String[] args) throws IOException {
		/*
		 * ####1 : READING DATA
		 */
		System.out.println("Reading dataset ...");
		
		ManipData manip = new ManipData();
		String path = "C:\\Users\\soffi\\Documents\\GitHub\\DATAMINING\\ressources\\test.txt";
		
		ArrayList<ArrayList<Double>> dataset= new ArrayList<>();
		dataset=manip.OpenTxtFile(path);
		manip.setData(dataset);
		System.out.println("\nReading Ends\n");
		
		/*
		 * ####2 : Calculating Central Tendency Metrics
		 */
		System.out.println("\nCalculating Central Tendency Metrics\n");
		System.out.print("\nChoose an attribute : \n");
		System.out.print("1. area A,\r\n" + 
				"2. perimeter P,\r\n" + 
				"3. compactness C = 4*pi*A/P^2,\r\n" + 
				"4. length of kernel,\r\n" + 
				"5. width of kernel,\r\n" + 
				"6. asymmetry coefficient\r\n" + 
				"7. length of kernel groove. \n8.Class \n    your choice : ");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		
		CentralTendencyM metrics = new CentralTendencyM();
	 	metrics.setDataset(dataset);
		metrics.setAttribute(manip.GetAttribute(choice));
		
		System.out.print("Median : "+metrics.GetMedian(choice)+"\n");
		System.out.print("Mode : "+"\n");
		System.out.print("Mean : "+metrics.GetMean()+"\n");
		System.out.print("Enter pourcentage (1-100%) to calculate trimmed mean : ");
		int prcentage = sc.nextInt();
		System.out.print("Trimmed mean : "+metrics.GetTrMean(choice,prcentage)+"\n");
		System.out.print("Min : "+metrics.GetQ0(choice)+"\n");
		System.out.print("Max : "+metrics.GetQ4(choice)+"\n");
		System.out.print("Etendue : "+metrics.GetEtendu(choice)+"\n");
		System.out.print("MidRange : "+metrics.GetMidRange(choice)+"\n");
		System.out.print("Q1 : "+metrics.GetQ1(choice)+"\n");
		System.out.print("Q3 : "+metrics.GetQ3(choice)+"\n");
		System.out.print("Ecart interquartile : "+metrics.GetIQR(choice)+"\n");
		System.out.print("Outliers : \n    -MinValue = "+metrics.GetOutliersMin(choice)+" \n    -MaxValue = "+metrics.GetOutliersMax(choice)+"\n");
		System.out.print("Ecart type : "+metrics.GetEcartType(choice)+"\n");
		System.out.print("Variance : "+metrics.GetVariance(choice)+"\n");
	}

}