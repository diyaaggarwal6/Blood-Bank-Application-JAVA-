package ContolPanel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControlPanelViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void doavailability(ActionEvent event) throws IOException 
    {
    	FXMLLoader fxmlloader= new FXMLLoader(getClass().getResource("/BloodUnits/BloodunitsView.fxml"));
    	Parent root=(Parent)fxmlloader.load();
    	
    	Stage stage=new Stage();
    	stage.setScene(new Scene(root));
    	stage.show();

    }

    @FXML
    void docollection(ActionEvent event) throws IOException 
    {
    	FXMLLoader fxmlloader= new FXMLLoader(getClass().getResource("/BloodCollection/BloodCollectionView.fxml"));
    	Parent root=(Parent)fxmlloader.load();
    	
    	Stage stage=new Stage();
    	stage.setScene(new Scene(root));
    	stage.show();

    }

    @FXML
    void dodonordetails(ActionEvent event) throws IOException 
    {
    	FXMLLoader fxmlloader= new FXMLLoader(getClass().getResource("/table/tableView.fxml"));
    	Parent root=(Parent)fxmlloader.load();
    	
    	Stage stage=new Stage();
    	stage.setScene(new Scene(root));
    	stage.show();

    }

    @FXML
    void dohistory(ActionEvent event) throws IOException 
    {
    	FXMLLoader fxmlloader= new FXMLLoader(getClass().getResource("/history/historyView.fxml"));
    	Parent root=(Parent)fxmlloader.load();
    	
    	Stage stage=new Stage();
    	stage.setScene(new Scene(root));
    	stage.show();
    	

    }

    @FXML
    void doissue(ActionEvent event) throws IOException 
    {
    	FXMLLoader fxmlloader= new FXMLLoader(getClass().getResource("/IssueBlood/IssueBloodView.fxml"));
    	Parent root=(Parent)fxmlloader.load();
    	
    	Stage stage=new Stage();
    	stage.setScene(new Scene(root));
    	stage.show();

    }

    @FXML
    void doregister(ActionEvent event) throws IOException 
    {
    	FXMLLoader fxmlloader= new FXMLLoader(getClass().getResource("/donorregister/DonorMasterView.fxml"));
    	Parent root=(Parent)fxmlloader.load();
    	
    	Stage stage=new Stage();
    	stage.setScene(new Scene(root));
    	stage.show();

    }

    @FXML
    void showdeveloper(MouseEvent event) throws IOException 
    {
    	FXMLLoader fxmlloader= new FXMLLoader(getClass().getResource("/developer/developerView.fxml"));
    	Parent root=(Parent)fxmlloader.load();
    	
    	Stage stage=new Stage();
    	stage.setScene(new Scene(root));
    	stage.show();

    }

    @FXML
    void initialize() {

    }

}
