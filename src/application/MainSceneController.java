package application;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.jfree.data.statistics.DefaultBoxAndWhiskerXYDataset;
import part1.CentralTendencyM;
import part1.Individu;
import part1.ManipData;
import javax.swing.*;

public class MainSceneController implements Initializable{
	@FXML
	ComboBox<String> attributeComboBox;
	@FXML
	private Label hintLabel;
	@FXML
	private Button parcourirButton;
	@FXML
	private TextField chargerDatasetTextField;
	@FXML
	private Button chargerDatasetButton;
	@FXML
	private TableView<Individu> datasetTableView;
	@FXML
	private TextField A1TextField;
	@FXML
	private TextField A5TextField;
	@FXML
	private TextField A2TextField;
	@FXML
	private TextField A3TextField;
	@FXML
	private TextField A4TextField;
	@FXML
	private TextField A6TextField;
	@FXML
	private TextField A7TextField;
	@FXML
	private TextField classeTextField;
	@FXML
	private TextField medTextField;
	@FXML
	private TextField meanTextField;
	@FXML
	private TextField modeTextField;
	@FXML
	private TextField trMeanTextField;
	@FXML
	private TextField minTextField;
	@FXML
	private TextField maxTextField;
	@FXML
	private TextField eqartTextField;
	@FXML
	private TextField varTextField;
	@FXML
	private TextField ecartTypeTextField;
	@FXML
	private TextField etenduTextField;
	@FXML
	private TextField midTextField;
	@FXML
	private TextField q1TextField;
	@FXML
	private TextField q3TextField;
	@FXML
	private TextField outMinTextField;
	@FXML
	private TextField outMaxTextField;
	@FXML
	private TextField pourcentTextField;
	@FXML
	private Button AjouterButton;
	@FXML
	private Button modifierButton;
	@FXML
	private Button supprimerButton;
	@FXML
	private Button sauvegarderButton;
	@FXML
	private Button startButton;
	@FXML
	private TableColumn<Individu, Integer> NColumn = new TableColumn<>("Number"); 
	@FXML
	private TableColumn<Individu, Double> A1Column = new TableColumn<>("A1"); 
	@FXML
	private TableColumn<Individu, Double> A2Column = new TableColumn<>("A2"); 
	@FXML
	private TableColumn<Individu, Double> A3Column = new TableColumn<>("A3"); 
	@FXML
	private TableColumn<Individu, Double> A4Column = new TableColumn<>("A4"); 
	@FXML
	private TableColumn<Individu, Double> A5Column = new TableColumn<>("A5"); 
	@FXML
	private TableColumn<Individu, Double> A6Column = new TableColumn<>("A6"); 
	@FXML
	private TableColumn<Individu, Double> A7Column = new TableColumn<>("A7");
	@FXML
	private TableColumn<Individu, Double> classColumn = new TableColumn<>("classe");
	@FXML
	private ComboBox<String> visAtrComboBox = new ComboBox<>();
	@FXML
	private Button visButton;
	@FXML
	private Button manipButton;
	@FXML
	private BarChart<String, Number> barChart;
	@FXML
	private CategoryAxis barCharXAxis = new CategoryAxis();
	@FXML
	private NumberAxis barCharYAxis = new NumberAxis();
	@FXML
	private RadioButton singletonBucketsRadioButton = new RadioButton();
	@FXML
	private RadioButton uniformWidthRadioButton = new RadioButton();
	@FXML
	private Button rafraichirHistButton;
	@FXML
	private ComboBox<String> atr1ScatterPlotComboBox;
	@FXML
	private ComboBox<String> atr2ScatterPlotComboBox;
	@FXML
	private Button rafrachirScatterButton;
	@FXML
	private ScatterChart<Double, Double> scatterChart;
	@FXML
	private NumberAxis scatterNumberXAxis;
	@FXML
	private NumberAxis scatterNumberYAxis;
	@FXML
	private ComboBox<String> atrBoxPlotComboBox;
	@FXML
	private Button rafraichirBoxPlotButton;
	@FXML
	private Label modLabel;
	@FXML
	private Label symLabel;
	@FXML
	private TextArea descTextArea;
	@FXML
	private TextArea outliersTextArea;
	@FXML
	private Tab descTab;
	@FXML
	private Button rdButton;
	@FXML
	private ProgressBar dProgressBar;
	@FXML
	private TextField covTextField;
	@FXML
	private TextField rTextField;
	@FXML
	private ComboBox<String> atr1RComboBox;
	@FXML
	private ComboBox<String> atr2RComboBox;
	@FXML
	private Label covLabel;
	@FXML
	private Label rLabel;




	private ToggleGroup histChoice = new ToggleGroup();
	private String path;
	private ManipData manip = new ManipData();
	private ArrayList<ArrayList<Double>> dataset = new ArrayList<ArrayList<Double>>();
	private ArrayList<Individu> indDataset = new ArrayList<Individu>();;
	private ObservableList<String> options = 
			    FXCollections.observableArrayList(
			        "A1(Area)",
			        "A2(Perimeter)",
			        "A3(Compactness)",
			        "A4(lenght of kernel)",
			        "A5(width of kernel)",
			        "A6(asymmetry coefficient",
			        "A7(length of kernel groove)"
			    );
	private BigDecimal progress;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//indDataset = new ArrayList<Individu>();
		attributeComboBox.setItems(options);
		visAtrComboBox.setItems(options);
		atr1ScatterPlotComboBox.setItems(options);
		atr2ScatterPlotComboBox.setItems(options);
		atr1RComboBox.setItems(options);
		atr2RComboBox.setItems(options);
		atr1RComboBox.getSelectionModel().selectFirst();
		atr2RComboBox.getSelectionModel().selectLast();
		attributeComboBox.getSelectionModel().selectFirst();
		visAtrComboBox.getSelectionModel().selectFirst();
		atr1ScatterPlotComboBox.getSelectionModel().selectFirst();
		atr2ScatterPlotComboBox.getSelectionModel().selectLast();
		singletonBucketsRadioButton.setToggleGroup(histChoice);
		singletonBucketsRadioButton.setSelected(true);
		uniformWidthRadioButton.setToggleGroup(histChoice);
		dProgressBar.setProgress(0);
	}

	// THIS FUNCTION ALLOW US TO CREATE A BOXPLOT FOR EACH ATTRIBUTE
	@SuppressWarnings({"unchecked", "deprecation","Gdk"})
	public void loadBoxPlot() throws Exception{
		// CREATE THE BOXPLOT
		ArrayList<ArrayList<Double>> _list= new ArrayList<ArrayList<Double>>();
		// GET THE LATEST UPDATE OF THE DATASET
		manip.setData(manip.indDataToArrayData(indDataset));
		for(int i=0; i<7; i++){
			_list.add(manip.GetAttribute(i));
		}
		JFrame frame = new JFrame();
		BoxPlot boxPlot = new BoxPlot(_list);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.add(boxPlot.getChartPanel(), BorderLayout.CENTER);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	// SHOWDESC DESCRIBE THE DATA SET
	public void showDesc(){
		try{
			descTextArea.setText("###############################################################################\n");
			dProgressBar.setProgress(ProgressBar.INDETERMINATE_PROGRESS);
			// GENERAL INFORMATIONS
			descTextArea.appendText("\n\n ##### - Informations sur le DATASET chargé.\n\n");
			descTextArea.appendText("###############################################################################\n");
			descTextArea.appendText("Le groupe examiné comprenait des grains appartenant à trois variétés différentes de blé :\n"
					+ " Kama, Rosa et Canadian, 70 éléments chacun, sélectionnés au hasard pour\n" + 
					"l'expérience. Une visualisation de haute qualité de la structure interne du noyau \n"
					+ "a été détectée à l'aide d'une technique de rayons X doux. Elle est non destructive et considérablement\n"
					+ " moins chère que d'autres techniques d'imagerie plus sophistiquées comme la microscopie à balayage ou \n"
					+ "la technologie laser. Les images ont été enregistrées sur des plaques KODAK à rayons X de 13x18 cm. \n"
					+ "Des études ont été menées à l'aide de grains de blé récoltés à la moissonneuse-batteuse provenant de champs expérimentaux,\n"
					+ " explorés à l'Institut d'agrophysique de l'Académie polonaise des sciences à Lublin.\n");
			descTextArea.appendText("###############################################################################\n");
			descTextArea.appendText("Nombre d'instances = "+ indDataset.size()+"\n");
			descTextArea.appendText("###############################################################################\n");
			descTextArea.appendText("Nombre d'attributs = "+ 7+" + 1(classe)\n");
			// THE NUMBER OF BINS TO CREATE
			descTextArea.appendText("###############################################################################\n");
			// OBTAIN ALL THE CLASS VALUES
			ArrayList<Double>classValues = new ArrayList<Double>();
			for(int i=0; i<indDataset.size(); i++){
				if(!classValues.contains(indDataset.get(i).getClasse())){
					classValues.add(indDataset.get(i).getClasse());
				}
			}
			descTextArea.appendText("Nombre de classes = "+classValues.size()+"\n");
			descTextArea.appendText("###############################################################################\n");
			ArrayList<ArrayList<ArrayList<Double>>> dataClasses = new ArrayList<ArrayList<ArrayList<Double>>>();
			ArrayList<ArrayList<Double>> _class = new ArrayList<ArrayList<Double>>();
			// DIVIDE THE DATA BY CLASSES(KIND OF SORT)
			for(int i=0; i<classValues.size(); i++){
				_class = new ArrayList<ArrayList<Double>>();
				for(int j=0; j<manip.getData().size(); j++){
					if(classValues.get(i).equals(manip.getData().get(j).get(7))){
						_class.add(manip.getData().get(j));
					}
				}
				dataClasses.add(_class);
			}
			// DISPLAY THE NUMBER OF INSTANCE FOR EACH CLASS
			for(int i=0; i<classValues.size(); i++){
				descTextArea.appendText("Class "+(int)(double)classValues.get(i)+ ": -- Nombre d'instances -- : "+ dataClasses.get(i).size()+
						" | -- Pourcentage -- : "+ String.format("%.2f", (double)(dataClasses.get(i).size() * 100)/manip.getData().size())+ "%\n");
			}
			descTextArea.appendText("###############################################################################\n");
			// DISPLAY THE VALUES THAT THE ATTRIBUTES CAN TAKE
			for(int i=0; i<=6; i++){
				descTextArea.appendText("Attribut: "+options.get(i)+"\n");
				descTextArea.appendText("----------------------------------------------------------------------------\n");
				ArrayList<ArrayList<Double>> frequencies = new ArrayList<ArrayList<Double>>();
				frequencies = manip.GetFrequencies(manip.GetAttribute(i));
				for(int j=0; j<frequencies.size(); j++){
					// CHECK IF WE ALREADY ADDED THE CURRENT ELEMENT
					frequencies = manip.GetFrequencies(manip.GetAttribute(i));
					descTextArea.appendText(String.format("%.3f",frequencies.get(j).get(0))+ "\t -- Nbr -- : " + (int)(double)frequencies.get(j).get(1)+  "\t -- Pourcentage -- "+ String.format("%.2f", (frequencies.get(j).get(1)*100)/indDataset.size()) +"% \t TYPE:Numérique-Quantitatif\n");
				}
			}
			// REPRESENTING DATA WITH INTERVALS
			descTextArea.appendText("Distribution par intervalles(Avec discretisation): \n");
			ArrayList<ArrayList<Double>> bins = new ArrayList<ArrayList<Double>>();
			String temp = "";
			for(int i=0; i<=6; i++){
				descTextArea.appendText("Attribut"+ String.valueOf(i+1) +": \n");
				descTextArea.appendText("----------------------------------------------------------------------------\n");
				bins = binsCalc(i);
				for(int j=0; j<bins.size(); j++){
					temp = "[" + String.format("%.2f", (double) Math.round(bins.get(j).get(0)*100)/100) + ", "+ String.format("%.2f", (double) Math.round(bins.get(j).get(1)*10000)/10000) + "[\t -- Nbr --: "+ (int)(double)bins.get(j).get(2)+ "\t --Pourcentage-- " + String.format("%.2f", (bins.get(j).get(2)*100)/indDataset.size()) + "%";
					descTextArea.appendText(temp+"\n");
				}
				descTextArea.appendText("----------------------------------------------------------------------------\n");
			}
			dProgressBar.setProgress(1);
		}catch(Exception e){
			descTextArea.setText("###############################################################################\n");
			dProgressBar.setProgress(ProgressBar.INDETERMINATE_PROGRESS);
			descTextArea.appendText("Informations générales sur le Seeds data set.\n");
			descTextArea.appendText("###############################################################################\n");
			descTextArea.appendText("###############################################################################\n");
			descTextArea.appendText("Le groupe examiné comprenait des grains appartenant à trois variétés différentes de blé :\n"
					+ " Kama, Rosa et Canadian, 70 éléments chacun, sélectionnés au hasard pour\n" + 
					"l'expérience. Une visualisation de haute qualité de la structure interne du noyau \n"
					+ "a été détectée à l'aide d'une technique de rayons X doux. Elle est non destructive et considérablement\n"
					+ " moins chère que d'autres techniques d'imagerie plus sophistiquées comme la microscopie à balayage ou \n"
					+ "la technologie laser. Les images ont été enregistrées sur des plaques KODAK à rayons X de 13x18 cm. \n"
					+ "Des études ont été menées à l'aide de grains de blé récoltés à la moissonneuse-batteuse provenant de champs expérimentaux,\n"
					+ " explorés à l'Institut d'agrophysique de l'Académie polonaise des sciences à Lublin.\n");
			descTextArea.appendText("###############################################################################\n");
			descTextArea.appendText("Liste des attributs\n");
			descTextArea.appendText("----------------------------------------------------------------------------\n");
			descTextArea.appendText("Attribut 1: zone A\n");
			descTextArea.appendText("Attribut 2: périmètre P\n");
			descTextArea.appendText("Attribut 3: compacité c\n");
			descTextArea.appendText("Attribut 4: longueur du noyau\n");
			descTextArea.appendText("Attribut 5: largeur du noyau\n");
			descTextArea.appendText("Attribut 6: coefficient d'asymétrie\n");
			descTextArea.appendText("Attribut 7: longueur de la rainure du noyau\n");
			descTextArea.appendText("###############################################################################\n");
			descTextArea.appendText("Nombre d'instances = "+ indDataset.size()+"\n");
			descTextArea.appendText("###############################################################################\n");

			ManipData manip = new ManipData();
			manip.setData(manip.indDataToArrayData(indDataset));
			ArrayList<ArrayList<String>> dict = manip.DataDesc();
			for(ArrayList<String> item: dict){
				descTextArea.appendText("----------------------------------------------------------------------------\n");
				for(String line:item){
					descTextArea.appendText(line+"\n");
				}
			}
			descTextArea.appendText("----------------------------------------------------------------------------\n");
			descTextArea.appendText("----------------------------------------------------------------------------\n");
			descTextArea.appendText("\nVeuillez charger le data set pour avoir plus d'informations!\n\n");
			descTextArea.appendText("----------------------------------------------------------------------------\n");
			descTextArea.appendText("----------------------------------------------------------------------------\n");
		}
	}

	// THIS METHOD CREATE INTERVALS USING UNIFORM WIDTH METHOD
	public ArrayList<ArrayList<Double>> binsCalc(int index){
		ArrayList<ArrayList<Double>> frequencies = new ArrayList<ArrayList<Double>>();
		manip.setData(manip.indDataToArrayData(indDataset));
		frequencies = manip.GetFrequencies(manip.GetAttribute(index));
		// GETTING MIN AND MAX
		CentralTendencyM metrics = new CentralTendencyM();
		metrics.setAttribute(manip.GetAttribute(index));
		double min = metrics.GetQ0();
		double max = metrics.GetQ4();
		ArrayList<Double> visited = new ArrayList<>();
		ArrayList<Double> freq = new ArrayList<>();
		// GET THE MAXIMUM FREQUENCE FOR THE CURRENT ATTRIBUTE AND CREATE THE CATEGORY SET
		for(ArrayList<Double> elt:frequencies){
			// Check if we already added the current element
			if(!visited.contains(elt.get(0))){
				visited.add(elt.get(0));
				freq.add(elt.get(1));
			}
		}
		Double W = max - min + 0.01;
		Double k = 1 + ((10/3) * Math.log10(indDataset.size()));
		Double w = W/k;
		Double left = min;
		Double right = min + w;
		ArrayList<Double> temp;
		// DEFINE THE BINS
		ArrayList<ArrayList<Double>> bins = new ArrayList<ArrayList<Double>>();
		for(int i = 0; i<=(int)(double) k; i++){
			temp = new ArrayList<Double>();
			temp.add(left);
			temp.add(right);
			temp.add((double)0);
			bins.add(temp);
			for(int j = 0; j<visited.size(); j++){
				if(visited.get(j)>=left && visited.get(j)<right){
					temp.set(2, temp.get(2) + freq.get(j));
					bins.set(i, temp);
				}
			}
			left = right;
			right = min + w*(i+2);
		}
		return bins;
	}

	// LOADSCATTERCHART CREATE A SCATTER PLOT
	public void loadScatterChart(){
		// SETUP THE LABELS OF THE AXIS
		try{
			scatterChart.getData().setAll(new XYChart.Series<Double, Double>());
			scatterNumberXAxis.setLabel(atr1ScatterPlotComboBox.getValue());
			scatterNumberYAxis.setLabel(atr2ScatterPlotComboBox.getValue());
			scatterChart.setTitle("Diagramme de dispersion");
			int index1 = atr1ScatterPlotComboBox.getSelectionModel().getSelectedIndex();
			int index2 = atr2ScatterPlotComboBox.getSelectionModel().getSelectedIndex();
			manip.setData(manip.indDataToArrayData(indDataset));
			// OBTAIN THE POSSIBLE VALUES THE CLASS ATTRIBUTE CAN TAKE
			ArrayList<Double>classValues = new ArrayList<Double>();
			for(int i=0; i<indDataset.size(); i++){
				if(!classValues.contains(indDataset.get(i).getClasse())){
					classValues.add(indDataset.get(i).getClasse());
				}
			}
			// CREATE THE DIFFERENTS SERIES OF DATA(IT'S A MUST IF WE WANT TO REPRESENT THE SCATTER PLOT)
			ArrayList<XYChart.Series<Double, Double>> dataSeries = new ArrayList<XYChart.Series<Double, Double>>();
			XYChart.Series<Double, Double> series = new XYChart.Series<Double, Double>();
			for(int i=0; i<classValues.size(); i++){
				series = new XYChart.Series<Double, Double>();
				series.setName("Classe : " + String.valueOf((int)(double)classValues.get(i)));
				for(int j=0; j<manip.getData().size(); j++){
					if(classValues.get(i).equals(manip.getData().get(j).get(7))){
						series.getData().add(new XYChart.Data<Double, Double>(manip.getData().get(j).get(index1),manip.getData().get(j).get(index2)));
					}
				}
				dataSeries.add(series);
			}
			// DISPLAY THE DATA ON THE SCATTERPLOT
			for(int i=0; i<classValues.size(); i++){
				scatterChart.getData().add(dataSeries.get(i));
			}
		}catch(Exception e){
			System.out.println("Vide");
		}
	}

	public void loadBarChart(){
		try{
			// SETUP THE AXIS
			barCharXAxis.setLabel(visAtrComboBox.getValue());
			barCharYAxis.setLabel("Fréquence");
			barCharXAxis.setAnimated(false);
			// SETUP THE CHART
			barChart.setCategoryGap(0);
			// GET THE SELECTED ITEM
			int index = visAtrComboBox.getSelectionModel().getSelectedIndex();
			// CREATE A MANIP VARIABLE TO CONVERT OUR INDDATASET TO A COMPOSED ARRAYLIST
			manip.setData(manip.indDataToArrayData(indDataset));
			System.out.println(manip.getData());
			ArrayList<ArrayList<Double>> frequencies = new ArrayList<ArrayList<Double>>();
			frequencies = manip.GetFrequencies(manip.GetAttribute(index));
			ArrayList<Double> visited = new ArrayList<>();
			ArrayList<Double> freq = new ArrayList<>();
			// GET THE MAXIMUM FREQUENCE FOR THE CURRENT ATTRIBUTE
			for(ArrayList<Double> elt:frequencies){
				// Check if we already added the current element
				if(!visited.contains(elt.get(0))){
					visited.add(elt.get(0));
					freq.add(elt.get(1));
				}
			}
			if(singletonBucketsRadioButton.isSelected()){
				System.out.println("je suis entrain d'afficher : " + visAtrComboBox.getSelectionModel().getSelectedIndex());
				singletonBuckets(index, visited, freq);
			}else{
				CentralTendencyM metrics = new CentralTendencyM();
				metrics.setDataset(manip.getData());
				metrics.setAttribute(manip.GetAttribute(index));
				uniformWidth(index, frequencies.size(), metrics.GetQ0(), metrics.GetQ4(), visited, freq);
			}
		}catch(Exception e){
			System.out.println("Aucun Dataset sélectionné");
		}
	}

	public void uniformWidth(int index, int N, Double min, Double max, ArrayList<Double> visited, ArrayList<Double> freq){
		XYChart.Series<String, Number> hist = new XYChart.Series<String, Number>();
		hist.setName(visAtrComboBox.getValue());
		// COMPUTE THE NUMBER OF BINS TO CREATE
		Double W = max - min + 0.01;
		Double k = 1 + ((10/3) * Math.log10(N));
		Double w = W/k;
		Double left = min;
		Double right = min + w;
		ArrayList<Double> temp;
		// DEFINE THE BINS
		ArrayList<ArrayList<Double>> bins = new ArrayList<ArrayList<Double>>();
		for(int i = 0; i<=(int)(double) k; i++){
			temp = new ArrayList<Double>();
			temp.add(left);
			temp.add(right);
			temp.add((double)0);
			bins.add(temp);
			for(int j = 0; j<visited.size(); j++){
				if(visited.get(j)>=left && visited.get(j)<right){
					temp.set(2, temp.get(2) + freq.get(j));
					bins.set(i, temp);
				}
			}
			left = right;
			right = min + w*(i+2);
		}
 		for (int categoryIndex = 0; categoryIndex < bins.size(); categoryIndex++) {
			hist.getData().add(new XYChart.Data<String, Number>("[" + String.valueOf((double) Math.round(bins.get(categoryIndex).get(0)*100)/100) + ", "+ String.valueOf((double) Math.round(bins.get(categoryIndex).get(1)*100)/100) + "[", bins.get(categoryIndex).get(2)));
		}
		barChart.getData().setAll(hist);
		barChart.setTitle("Histogramme");
	}

	public void singletonBuckets(int index, ArrayList<Double> visited, ArrayList<Double> freq){
		XYChart.Series<String, Number> hist = new XYChart.Series<String, Number>();
		hist.setName(visAtrComboBox.getValue());
		for (int categoryIndex = 0; categoryIndex < visited.size(); categoryIndex++) {
			hist.getData().add(new XYChart.Data<String, Number>(String.valueOf(visited.get(categoryIndex)), freq.get(categoryIndex)));
		}
		barChart.getData().setAll(hist);
		barChart.setTitle("Histogramme");
	}

	// ALOW US TO SEARCH FOR THE DATA SET
	public void parcourirMethod() {
		hintLabel.setText("");
		try {
			FileChooser openFileChooser = new FileChooser();
			File workingDirectory = new File(System.getProperty("user.dir"));
			openFileChooser.setInitialDirectory(workingDirectory);
			openFileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text File", "*.txt"), 
					new FileChooser.ExtensionFilter("CSV File", "*.csv"));
			path = openFileChooser.showOpenDialog(new Stage()).getAbsolutePath();
			dataset = manip.OpenTxtFile(path);
			indDataset = new ArrayList<Individu>();
			indDataset = manip.arrayDatatoIndData(dataset);
			displayInd();
			initDatasetTableView();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			hintLabel.setText("Erreur lors de l'ouverture du fichier");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(NullPointerException e) {
			hintLabel.setText("Aucun fichier n'a été sélectionné");
		}
	}
	
	public void refreshDatasetTableView() {
		try {
			initDatasetTableView();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// iNIT THE TABLE VIEW
	public void initDatasetTableView() throws ClassNotFoundException, SQLException {
			// Set UP Columns
			NColumn.setCellValueFactory(new PropertyValueFactory<Individu, Integer>("Number"));
			NColumn.setSortable(false);
			A1Column.setCellValueFactory(new PropertyValueFactory<Individu, Double>("A1"));
			A1Column.setSortable(false);
			A2Column.setCellValueFactory(new PropertyValueFactory<Individu, Double>("A2"));
			A2Column.setSortable(false);
			A3Column.setCellValueFactory(new PropertyValueFactory<Individu, Double>("A3"));
			A3Column.setSortable(false);
			A4Column.setCellValueFactory(new PropertyValueFactory<Individu, Double>("A4"));
			A4Column.setSortable(false);
			A5Column.setCellValueFactory(new PropertyValueFactory<Individu, Double>("A5"));
		 	A5Column.setSortable(false);
			A6Column.setCellValueFactory(new PropertyValueFactory<Individu, Double>("A6"));
			A6Column.setSortable(false);
			A7Column.setCellValueFactory(new PropertyValueFactory<Individu, Double>("A7"));
			A7Column.setSortable(false);
			classColumn.setCellValueFactory(new PropertyValueFactory<Individu, Double>("classe"));
			datasetTableView.setItems(getDataset(this.indDataset));

			}

	public ObservableList<Individu> getDataset(ArrayList<Individu> indArray) throws SQLException, ClassNotFoundException{
		ObservableList<Individu> observableDataset = FXCollections.observableArrayList();
		// filling the user observable list
		for(int i = 0 ; i < indArray.size(); i++){
			observableDataset.add(
					new Individu(
						i+1,	
						indArray.get(i).getA1(),
						indArray.get(i).getA2(),
						indArray.get(i).getA3(),
						indArray.get(i).getA4(),
						indArray.get(i).getA5(),
						indArray.get(i).getA6(),
						indArray.get(i).getA7(),
						indArray.get(i).getClasse()
					));
			System.out.println(observableDataset.get(i));
		}
		return observableDataset;
	}
	
	public void chargerMethod() {
		hintLabel.setText("");
		path = chargerDatasetTextField.getText();
		try {
			dataset = manip.OpenTxtFile(path);
			indDataset = manip.arrayDatatoIndData(dataset);
			displayInd();
			initDatasetTableView();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			hintLabel.setText("Fichier introuvable!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(path);
	}
	
	public void displayInd() {
		for(int i = 0 ; i < indDataset.size(); i++) {
			indDataset.get(i).display();
		}
	}
	
	public void selectInstance() {
		try {
			Individu ind = datasetTableView.getSelectionModel().getSelectedItem();
			A1TextField.setText(Double.toString(ind.getA1()));
			A2TextField.setText(Double.toString(ind.getA2()));
			A3TextField.setText(Double.toString(ind.getA3()));
			A4TextField.setText(Double.toString(ind.getA4()));
			A5TextField.setText(Double.toString(ind.getA5()));
			A6TextField.setText(Double.toString(ind.getA6()));
			A7TextField.setText(Double.toString(ind.getA7()));
			classeTextField.setText(Double.toString(ind.getClasse()));
		}catch(Exception e) {
			hintLabel.setText("Table vide!");
		}
	}
	
	public void modifierInstance() {
		try {
			int index = datasetTableView.getSelectionModel().getSelectedIndex();
			this.indDataset.get(index).setA1(Double.parseDouble(A1TextField.getText()));
			this.indDataset.get(index).setA2(Double.parseDouble(A2TextField.getText()));
			this.indDataset.get(index).setA3(Double.parseDouble(A3TextField.getText()));
			this.indDataset.get(index).setA4(Double.parseDouble(A4TextField.getText()));
			this.indDataset.get(index).setA5(Double.parseDouble(A5TextField.getText()));
			this.indDataset.get(index).setA6(Double.parseDouble(A6TextField.getText()));
			this.indDataset.get(index).setA7(Double.parseDouble(A7TextField.getText()));
			this.indDataset.get(index).setClasse(Double.parseDouble(classeTextField.getText()));
			refreshDatasetTableView();
			manip.setData(manip.indDataToArrayData(indDataset));
		}catch(Exception e) {
			hintLabel.setText("Aucune ligne sélectionnée!");
		}
	}
	public void supprimerInstance() {
		try {
			int index = datasetTableView.getSelectionModel().getSelectedIndex();
			this.indDataset.remove(index);
			refreshDatasetTableView();
			manip.setData(manip.indDataToArrayData(indDataset));
		}catch(Exception e) {
			hintLabel.setText("Aucune ligne sélectionnée!");
		}	
	}
	public void ajouterInstance() {
		try {
			int last = indDataset.size();
			Individu ind = new Individu(
					last,
					Double.parseDouble(A1TextField.getText()),
					Double.parseDouble(A2TextField.getText()),
					Double.parseDouble(A3TextField.getText()),
					Double.parseDouble(A4TextField.getText()),
					Double.parseDouble(A5TextField.getText()),
					Double.parseDouble(A6TextField.getText()),
					Double.parseDouble(A7TextField.getText()),
					Double.parseDouble(classeTextField.getText())
					);
			indDataset.add(ind);
			refreshDatasetTableView();
		}catch(NumberFormatException e) {
			hintLabel.setText("Input erroné!");
		}
	}
	public void sauvegarderDataset() {
		try {
			FileChooser saveFileChooser = new FileChooser();
			File workingDirectory = new File(System.getProperty("user.dir"));
			saveFileChooser.setInitialDirectory(workingDirectory);
			saveFileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text File", "*.txt"));
			ManipData manip = new ManipData();
			String path = saveFileChooser.showSaveDialog(new Stage()).getAbsolutePath();
			manip.ListToFile(manip.indDataToArrayData(indDataset), path);
			}catch(NullPointerException e) {
				hintLabel.setText("Sauvegarde annulé");
			}catch (IOException e){
				hintLabel.setText("");
		}
	}
	// CALCULATE THE MEAN, MOD ETC..
	public void startCalc() {
		try {
			hintLabel.setText("");
			outliersTextArea.setText("");
			modLabel.setText("# - Modalité: ");
			symLabel.setText("# - Symétrie: ");
			CentralTendencyM metrics = new CentralTendencyM();
			manip.setData(manip.indDataToArrayData(indDataset));
			metrics.setAttribute(manip.GetAttribute(attributeComboBox.getSelectionModel().getSelectedIndex()));
			medTextField.setText(Double.toString(metrics.GetMedian()));
			meanTextField.setText(Double.toString(metrics.GetMean()));
			modeTextField.setText("");
			for(int i = 0; i<metrics.GetMode().size()-1; i++) {
				modeTextField.setText(modeTextField.getText()+"| "+ metrics.GetMode().get(i));
			}
			 // DESCRIBE THE MODALITY
			switch(metrics.GetMode().size()-1){
				case 1:
					modLabel.setText("# - Modalité: Unimodale.");
					break;
				case 2:
					modLabel.setText("# - Modalité: Bimodale.");
					break;
				case 3:
					modLabel.setText("# - Modalité: Trimodale.");
					break;
				default:
					modLabel.setText("# - Modalité: Pas de Mode.");
			}
			trMeanTextField.setText(Double.toString(metrics.GetTrMean(Integer.parseInt(pourcentTextField.getText()))));
			ecartTypeTextField.setText(Double.toString(metrics.GetEcartType()));
			varTextField.setText(Double.toString(metrics.GetVariance()));
			eqartTextField.setText(Double.toString(metrics.GetIQR()));
			etenduTextField.setText(Double.toString(metrics.GetEtendu()));
			midTextField.setText(Double.toString(metrics.GetMidRange()));
			q1TextField.setText(Double.toString(metrics.GetQ1()));
			q3TextField.setText(String.format("%.2f",metrics.GetQ3()));
			outMinTextField.setText(Double.toString(metrics.GetOutliersMin()));
			outMaxTextField.setText(Double.toString(metrics.GetOutliersMax()));
			minTextField.setText(Double.toString(metrics.GetQ0()));
			maxTextField.setText(Double.toString(metrics.GetQ4()));
			// DESCRIBE THE SYMMETRY
			double temp = 0;
			for(Double d : metrics.GetMode()){
				temp+=d;
			}
			if(metrics.GetMode().size()-1==1){

				double d = metrics.GetMode().get(0);
				if(Math.round(d) == Math.round(metrics.GetMean())&& Math.round(metrics.GetMean()) == Math.round(metrics.GetMedian())){
					symLabel.setText("# - La distribution des données\n est symétrique.");
				}else{
					symLabel.setText("# - La distribution des données\n est légèrement asymétrique.");
				}
			}else {
				temp = temp / (metrics.GetMode().size() - 1);
				modeTextField.setText(modeTextField.getText() + " -- Moy --" + temp);
				if (Math.round(temp) == Math.round(metrics.GetMean()) && Math.round(metrics.GetMean()) == Math.round(metrics.GetMedian())) {
					symLabel.setText("# - La distribution des données\n est symétrique.");
				} else {
					symLabel.setText("# - La distribution des données\nest légèrement asymétrique.");
				}
			}


		// DETERMINE THE OUTLIERS
		for(int i=0; i<metrics.getAttribute().size(); i++){
			if(metrics.getAttribute().get(i)>metrics.GetOutliersMax() || metrics.getAttribute().get(i)<metrics.GetOutliersMin()){
				outliersTextArea.appendText(", "+String.valueOf(metrics.getAttribute().get(i)));
			}
		}
		// Be sure the variable aren't the same
		int i = atr1RComboBox.getSelectionModel().getSelectedIndex();
		int j = atr2RComboBox.getSelectionModel().getSelectedIndex();
		if(i!=j){
			ArrayList<String> r;
			metrics.setDataset(manip.indDataToArrayData(indDataset));
			r = metrics.GetCorrelation(i, j);
			// COV AND R CALCULATIONS
			covTextField.setText(String.valueOf(metrics.GetCoVariance(i, j)));
			rTextField.setText(r.get(0));
			rLabel.setText(r.get(1));
		}else{
			rTextField.setText("-");
			covTextField.setText("-");
		}
		} catch(NumberFormatException e) {
			hintLabel.setText("La case du pourcentage doit etre remplie");
		} catch(Exception e) {
			//e.printStackTrace();
			hintLabel.setText("Insuffisant pour lancer les calculs!");
		}
	}
}
