package part1;

import java.util.ArrayList;
import java.util.Collections;

public class CentralTendencyM {
	public ArrayList<Double> data;
	public ArrayList<ArrayList<Double>> dataset;
	
	/*
	 * constructors
	 */
	public CentralTendencyM() {
	}

	public CentralTendencyM(ArrayList<Double> data) {
		this.data = data;
	}

	/*
	 * getters and setters
	 */
	public ArrayList<Double> getData() {
		return data;
	}

	public void setData(ArrayList<Double> data) {
		this.data = data;
	}

	/*
	 * functions
	 */

	// moyenne
	public double GetMean(ArrayList<Double> attribute) {
		double somme = 0;
		for (int i = 0; i < attribute.size(); i++) {
			somme = somme + attribute.get(i);
		}

		return Math.round((1 / (double) attribute.size() * somme) * 1e2) / 1e2;
	}

	// trimmed moy
	public double GetTrMean(int indexAtt, int pourcentage) {
		ArrayList<Double> attribute=new ArrayList<>();
		attribute=this.dataset.get(indexAtt);
		double somme = 0;
		//pourcentage=4, //4%
		int k=attribute.size()*pourcentage/100; //nbre de val a supprimer de chaque extremite
		//System.out.println(k);
		Collections.sort(attribute);
		System.out.println(attribute);
		for (int i = k; i < attribute.size()-k; i++) {
			somme = somme + attribute.get(i);
			
		}
		return Math.round((1 / (double) (attribute.size()-2*k) * somme) * 1e2) / 1e2;
	}

	public ArrayList<ArrayList<Double>> getDataset() {
		return dataset;
	}

	public void setDataset(ArrayList<ArrayList<Double>> dataset) {
		this.dataset = dataset;
	}

	// médiane
	public double GetMedian(int indexAtt) {
		ArrayList<Double> data=new ArrayList<>();
		data=this.dataset.get(indexAtt);
		Collections.sort(data);
		if (data.size() % 2 == 0)
			return Math.round((data.get((data.size() / 2) - 1) + data.get(data.size() / 2)) / 2.0 * 1e2) / 1e2;;

		return Math.round(data.get(data.size() / 2) * 1e2) / 1e2;
	}
	// mode
	public ArrayList<Double> GetMode(int indexAtt) {
		int cmode=0;
		ArrayList<Double> mode = new ArrayList<>();
		//data = ManipData.SortAttribute(data);

		// type de modalitee
		if (cmode== 1) //System.out.print("unimodal "+ 1);
			mode.add(1.0);
		
		if (cmode == 2) //System.out.print("bimodale "+2);
			mode.add(2.0);
		
		if (cmode == 3) //System.out.print("trimodale "+3);
			mode.add(3.0);
		
		else //System.out.print("pas de mode "+0);
			mode.add(0.0);
		
		return mode;
	}

	// l'étendue
	public double GetEtendue(int indexAtt) {
		ManipData m= new ManipData();
		m.setRow(data);
		return m.GetMax(m.data.indexOf(indexAtt)) - m.GetMin(m.data.indexOf(indexAtt));
	}

	// milieu de l'étendue
	public double GetMidRange(int indexAtt) {
		ManipData m= new ManipData(this.dataset);
		m.setRow(this.dataset.get(indexAtt));
		return (m.GetMax(indexAtt) + m.GetMin(indexAtt)) / 2.0;
	}

	// déduire les symétries
	public void DedSym(double mean, double median, double mode) {
		
		if(mean==median & median==mode)
			System.out.println("data is symetric");
		if(mode<median & median<mean)
			System.out.println("negatively skewed data ");
		if(mean<median & median<mode)
			System.out.println("positively skewed data ");
		return;
	}
}
