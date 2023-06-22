package IssueBlood;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class IssueBloodViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField bgid;

    @FXML
    private DatePicker dateid;

    @FXML
    private TextField hosid;

    @FXML
    private TextField mobid;

    @FXML
    private TextField nameid;

    @FXML
    private TextField reasonid;

    @FXML
    private TextField unitsid;
    
    Connection con;
    PreparedStatement pst;
    

    @FXML
    void doupdate(ActionEvent event) 
    
    {
    	String bg=bgid.getText();
    	try 
    	{
			pst=con.prepareStatement("insert into issue values(?,?,?,?,?,?)");
			pst.setString(1, nameid.getText());
			pst.setString(2, mobid.getText());
			pst.setString(3, hosid.getText());
			pst.setString(4, reasonid.getText());
			pst.setString(5, String.valueOf(dateid.getValue()));
			pst.setString(6, bgid.getText());
		    pst.executeUpdate();
			showmsg("Record Inserted Successfully");
			
		} 
    	catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	try {
    		pst=con.prepareStatement("update total_blood_record set "+bg+"="+bg+"-?");
    		pst.setInt(1, 1);
    		pst.executeUpdate();
    		showmsg("Updated Table total blood record");
    	}
    	catch (Exception e) {
			// TODO: handle exception
    		showmsg(e.toString());
		}
    }

    void showmsg(String msg)
    {
    	Alert alert=new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("CONFIRMATION");
    	alert.setContentText(msg);
    	alert.show();
    }	
    @FXML
    void initialize() 
    {
    	con=DatabaseConnection3.doConnect();
        
    }

}
