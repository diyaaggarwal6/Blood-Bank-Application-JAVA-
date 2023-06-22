package history;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class historyViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void showbloodunittable(ActionEvent event) throws IOException 
    {
    	FXMLLoader fxmlloader= new FXMLLoader(getClass().getResource("/BloodCollectionTable/BloodCollectionView.fxml"));
    	Parent root=(Parent)fxmlloader.load();
    	
    	Stage stage=new Stage();
    	stage.setScene(new Scene(root));
    	stage.show();

    }

    @FXML
    void showissuetbl(ActionEvent event) throws IOException 
    {
    	FXMLLoader fxmlloader= new FXMLLoader(getClass().getResource("/BloodIssuedata/BloodIssueView.fxml"));
    	Parent root=(Parent)fxmlloader.load();
    	
    	Stage stage=new Stage();
    	stage.setScene(new Scene(root));
    	stage.show();


    }

    @FXML
    void initialize() {

    }

}
