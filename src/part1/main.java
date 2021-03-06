package part1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws IOException {
		/*
		 * ####1 : READING DATA
		 */
		//System.out.println("Reading dataset ...");

		ManipData manip = new ManipData();
		String path = "ressources/seeds_dataset.txt";
		ArrayList<ArrayList<Double>> dataset = new ArrayList<>();
		dataset = manip.OpenTxtFile(path);
		//manip.setData(dataset);
		//System.out.println("\nReading Ends\n");
		
		/*
		 * ####2 : Mnipulating Data
		 */
/*
		ArrayList<Double> tmp = new ArrayList<>();
		tmp.addAll(Arrays.asList(1.1,100.2,3.0,4.1,5.3,6.5,7.7,8.8));
		dataset=manip.addData(tmp);
*/		
		
		
		/*
		 * ####3 : Calculating Central Tendency Metrics
		 */
		/*
		System.out.println("\nCalculating Central Tendency Metrics\n");
		System.out.print("\n Normalization : ");

		System.out.print("\nChoose an attribute : \n");
		System.out.print("1. area A,\r\n" + "2. perimeter P,\r\n" + "3. compactness C = 4*pi*A/P^2,\r\n"
				+ "4. length of kernel,\r\n" + "5. width of kernel,\r\n" + "6. asymmetry coefficient\r\n"
				+ "7. length of kernel groove. \n    your choice : ");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		*/
		int choice=0;
		CentralTendencyM metrics = new CentralTendencyM();
		metrics.setDataset(dataset);
		metrics.setAttribute(manip.GetAttribute(choice));
		
		// NORMALISATION 
		//System.out.print("\n avant normalisation : " + manip.GetAttribute(choice) + "\n");
		//System.out.print("\n normalisation min max: " + metrics.NormMinMax() + "\n");
		//System.out.print("\n normalisation z score : " + metrics.NormZscore(0) + "\n");

		//DISCRETIZATION


		/*
		System.out.print("Median : " + metrics.GetMedian() + "\n");
		System.out.print("Mode : " +metrics.GetMode()+"\n");
		System.out.print("Mean : " + metrics.GetMean() + "\n");
		System.out.print("Enter pourcentage (1-100%) to calculate trimmed mean : ");
		int prcentage = sc.nextInt();
		System.out.print("Trimmed mean : " + metrics.GetTrMean(prcentage) + "\n");
		System.out.print("Min : " + metrics.GetQ0() + "\n");
		System.out.print("Max : " + metrics.GetQ4() + "\n");
		System.out.print("Etendue : " + metrics.GetEtendu() + "\n");
		System.out.print("MidRange : " + metrics.GetMidRange() + "\n");
		System.out.print("Q1 : " + metrics.GetQ1() + "\n");
		System.out.print("Q3 : " + metrics.GetQ3() + "\n");
		System.out.print("Ecart interquartile : " + metrics.GetIQR() + "\n");
		System.out.print("Outliers : \n    -MinValue = " + metrics.GetOutliersMin() + " \n    -MaxValue = "
				+ metrics.GetOutliersMax() + "\n");
		System.out.print("Ecart type : " + metrics.GetEcartType() + "\n");
		System.out.print("Variance : " + metrics.GetVariance() + "\n");
		System.out.print("output  : " + manip.DataDesc() + "\n");
		System.out.print("covar  : " + metrics.GetCoVariance(1, 2) + "\n");
		System.out.print("correlation  : " + metrics.GetCorrelation(1, 2) + "\n");
		System.out.print("correlation  : " + metrics.GetCorrelation(1, 3) + "\n");
		*/
		int ch = 2;
		metrics.setDatasetZScore(ch);
		ManipData manip_zcore = new ManipData();
		ManipData manip_min_max = new ManipData();
		if(ch == 2){
			manip_zcore.setData(metrics.datasetZScore);			
		}else if(ch == 1){
			manip_zcore.setData(metrics.datasetMinMax);
		}
		System.out.println("test getAtt"+manip_zcore.GetAttributeNorm(0));
		metrics.atr2interv(manip_zcore.GetAttributeNorm(0), 5);
		System.out.print("\n##END## ");

	}

}