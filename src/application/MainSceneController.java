package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import part1.CentralTendencyM;
import part1.Individu;
import part1.ManipData;
import javafx.scene.control.TableView;

public class MainSceneController implements Initializable{
	@FXML
	ComboBox<String> attributeComboBox = new ComboBox<>();
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
	
	private String path;
	private ManipData manip = new ManipData();
	private ArrayList<ArrayList<Double>> dataset = new ArrayList<ArrayList<Double>>();
	private ArrayList<Individu> indDataset;
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
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		indDataset = new ArrayList<Individu>();
		attributeComboBox.setItems(options);
		attributeComboBox.getSelectionModel().selectFirst();
	}
	

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
			indDataset = manip.arrayDatatoIndData(dataset);
			displayInd();
			initDatasetTableView();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			hintLabel.setText("Erreur lors de l'ouverture du fichier");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(NullPointerException e) {
			hintLabel.setText("Aucun fichier n'a �t� s�lectionn�");
		}
		System.out.println(path);
	}
	
	public void refreshDatasetTableView() {
		try {
			initDatasetTableView();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void initDatasetTableView() throws ClassNotFoundException, SQLException {
			
			// Set UP Columns
			NColumn.setCellValueFactory(new PropertyValueFactory<Individu, Integer>("Number"));
			A1Column.setCellValueFactory(new PropertyValueFactory<Individu, Double>("A1"));
			A2Column.setCellValueFactory(new PropertyValueFactory<Individu, Double>("A2"));
			A3Column.setCellValueFactory(new PropertyValueFactory<Individu, Double>("A3"));
			A4Column.setCellValueFactory(new PropertyValueFactory<Individu, Double>("A4"));
			A5Column.setCellValueFactory(new PropertyValueFactory<Individu, Double>("A5"));
			A6Column.setCellValueFactory(new PropertyValueFactory<Individu, Double>("A6"));
			A7Column.setCellValueFactory(new PropertyValueFactory<Individu, Double>("A7"));
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
		}catch(Exception e) {
			hintLabel.setText("Aucune ligne s�lectionn�e!");
		}
	}
	
	public void supprimerInstance() {
		try {
			int index = datasetTableView.getSelectionModel().getSelectedIndex();
			this.indDataset.remove(index);
			refreshDatasetTableView();
		}catch(Exception e) {
			hintLabel.setText("Aucune ligne s�lectionn�e!");
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
			hintLabel.setText("Input erron�!");
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
			}catch(Exception e) {
				e.printStackTrace();
		}
	}
	
	public void startCalc() {
		try {
			CentralTendencyM metrics = new CentralTendencyM();
			metrics.setAttribute(manip.GetAttribute(attributeComboBox.getSelectionModel().getSelectedIndex()+1));
			medTextField.setText(Double.toString(metrics.GetMedian()));
			meanTextField.setText(Double.toString(metrics.GetMean()));
			modeTextField.setText("");
			for(int i = 0; i<metrics.GetMode().size(); i++) {
				modeTextField.setText(modeTextField.getText()+"| "+ metrics.GetMode().get(i));
			}
			trMeanTextField.setText(Double.toString(metrics.GetTrMean(Integer.parseInt(pourcentTextField.getText()))));
			eqartTextField.setText(Double.toString(metrics.GetEcartType()));
			varTextField.setText(Double.toString(metrics.GetVariance()));
			ecartTypeTextField.setText(Double.toString(metrics.GetIQR()));
			etenduTextField.setText(Double.toString(metrics.GetEtendu()));
			midTextField.setText(Double.toString(metrics.GetMidRange()));
			q1TextField.setText(Double.toString(metrics.GetQ1()));
			q3TextField.setText(Double.toString(metrics.GetQ3()));
			outMinTextField.setText(Double.toString(metrics.GetOutliersMin()));
			outMaxTextField.setText(Double.toString(metrics.GetOutliersMax()));
			minTextField.setText(Double.toString(metrics.GetQ0()));
			maxTextField.setText(Double.toString(metrics.GetQ4()));
		}catch(NullPointerException e) {
			hintLabel.setText("Insuffisant pour lancer les calculs!");
		}catch(NumberFormatException e) {
			hintLabel.setText("La case du pourcentage doit etre remplie");
		}
	}

	

}
