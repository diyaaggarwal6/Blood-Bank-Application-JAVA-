package Login;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnlogin;

    @FXML
    private TextField loginid;

    @FXML
    private PasswordField passid;

    @FXML
    void dologin(ActionEvent event) 
    {
    	String user = loginid.getText();
        String pass = passid.getText();
        
   
     	   String  checkid = "BloodBank";
     	   String checkpass = "password";
     	   
     	   if(user.equals(checkid) && pass.equals(checkpass))
     	   {
     		   try{
     			  FXMLLoader fxmlloader= new FXMLLoader(getClass().getResource("/ContolPanel/ControlPanelView.fxml"));
     			 Parent root=(Parent)fxmlloader.load();
     	        	Stage stage=new Stage();
     	        	stage.setScene(new Scene(root));
     	        	stage.show();

     	            Scene scene1 = (Scene)btnlogin.getScene();
     	            scene1.getWindow().hide();

     			}
     			catch(Exception e)
     			{
     				e.printStackTrace();
     			}
     	   }
     	   else 
     	   {
     		Alert alert = new Alert(AlertType.WARNING);
   	    	alert.setTitle("Warning Message");
   	    	alert.setHeaderText("ThankYou For Using Our Services");
   	    	alert.setContentText("Invalid Username or Password");
   	    	alert.showAndWait();
     	   }

    }

    @FXML
    void initialize() {
        assert btnlogin != null : "fx:id=\"btnlogin\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert loginid != null : "fx:id=\"loginid\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert passid != null : "fx:id=\"passid\" was not injected: check your FXML file 'LoginView.fxml'.";

    }

}

