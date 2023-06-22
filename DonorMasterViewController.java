package donorregister;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

public class DonorMasterViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField addid;

    @FXML
    private TextField ageid;

    @FXML
    private TextField cityid;

    @FXML
    private ComboBox<String> comboblood;

    @FXML
    private ComboBox<String> combogender;

    @FXML
    private TextField disid;

    @FXML
    private ImageView imageid;

    @FXML
    private TextField mobileid;

    @FXML
    private TextField nameid;
    
    String filepath;
    Connection con;
    PreparedStatement pst;

    @FXML
    void dobrowse(ActionEvent event) 
    {
    	FileChooser chooser=new FileChooser();
    	chooser.getExtensionFilters().addAll
    	(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("*.*", "*.*")
        );
    	File file=chooser.showOpenDialog(null);
        filepath = file.getAbsolutePath();
    	
    	try 
    	{
    		
             imageid.setImage(new Image(new FileInputStream(file)));
		} 
    	catch (FileNotFoundException e) 
    	{	
    		e.printStackTrace();
    		
    	}

    }

    @FXML
    void doclear(ActionEvent event) 
    {
    	mobileid.setText("");
    	nameid.setText("");
    	combogender.setValue(null);;
    	addid.setText("");
    	comboblood.setValue(null);
    	ageid.setText("");
    	cityid.setText("");
    	disid.setText("");
    	imageid.setImage(null);

    }

    @FXML
    void dodelete(ActionEvent event) 
    {
    	try
    	{
			pst=con.prepareStatement("delete from registerdata where MobileNo=?");
			pst.setString(1, mobileid.getText() );
			int count = pst.executeUpdate();
			if(count==0)
			{
				showMsg("Invalid Input");
			}
			else
			{
				showmsg("Deleted");
			}
		} 
    	catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    void showMsg(String msg)
    {
    	Alert alert=new Alert(AlertType.ERROR);
    	alert.setTitle("ERROR");
    	alert.setContentText(msg);
    	alert.show();
    }
    void showmsg(String msg)
    {
    	Alert alert=new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("CONFIRMATION");
    	alert.setContentText(msg);
    	alert.show();
    }	

    @FXML
    void dofind(ActionEvent event) throws SQLException 
    {
    	pst=con.prepareStatement("select * from registerdata where MobileNo=?");
		pst.setString(1, mobileid.getText());
		ResultSet records=pst.executeQuery();
		if(records.next()==true)
		{
		String Name=records.getString("Name");
		String Address=records.getString("Address");
		String Gender=records.getString("Gender");
		String City=records.getString("City");
		String Disease=records.getString("Disease");
		String Image=records.getString("Image");
		String BloodGroup=records.getString("BloodGroup");
		String Age=records.getString("Age");
		nameid.setText(Name);
        addid.setText(Address);
		cityid.setText(City);
		ageid.setText(Age);
		disid.setText(Disease);
		comboblood.getSelectionModel().select(BloodGroup);
		combogender.getSelectionModel().select(Gender);
		File file=new File(Image);
		try 
		{
    		imageid.setImage(new Image(new FileInputStream(file)));
    	}
		
    	catch(FileNotFoundException e)
    	{
    		e.printStackTrace();
    		}
		}
    	
    }

    @FXML
    void doregister(ActionEvent event)
    {
    	try 
    	{
			pst=con.prepareStatement("insert into registerdata values(?,?,?,?,?,?,?,?,?)");
			pst.setString(1, mobileid.getText());
			pst.setString(2, nameid.getText());
			pst.setString(3, combogender.getSelectionModel().getSelectedItem());
			pst.setString(4, addid.getText());
			pst.setInt(5, Integer.parseInt(ageid.getText()));
			pst.setString(6, cityid.getText());
			pst.setString(7, disid.getText());
			pst.setString(8, comboblood.getSelectionModel().getSelectedItem());
			pst.setString(9, String.valueOf(filepath));
			pst.executeUpdate();
			showmsg("Record Inserted Successfully");
			
		} 
    	catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	



    }

    @FXML
    void doupdate(ActionEvent event) 
    {
    	try 
    	{
			pst=con.prepareStatement("update registerdata set Name=?,Gender=?,Address=?,Age=?,City=?,Disease=?,BloodGroup=?,Image=? where MobileNo=?");
			pst.setString(9, mobileid.getText());
			pst.setString(1, nameid.getText());
			pst.setString(2, combogender.getSelectionModel().getSelectedItem());
			pst.setString(3, addid.getText());
			pst.setString(4, ageid.getText());
			pst.setString(5, cityid.getText());
			pst.setString(6, disid.getText());
			pst.setString(7, comboblood.getSelectionModel().getSelectedItem());
			pst.setString(8, String.valueOf(filepath));
			pst.executeUpdate();
		    int records= pst.executeUpdate();
			
			if(records==0)
				showMsg("Invalid Mobile Number");
			else
				
			showmsg("Record Updated Successfullyyyy");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @FXML
    void initialize() 
    {
    	con=DatabaseConnection3.doConnect();
    	ArrayList<String> gender = new ArrayList<String>(Arrays.asList("Male","Female","Other"));
    	combogender.getItems().addAll(gender);
    	ArrayList<String>blood=new ArrayList<String>(Arrays.asList("Op","On","Bp","Bn","ABp","ABn","Ap","An"));
    	comboblood.getItems().addAll(blood);
       
    }

}



