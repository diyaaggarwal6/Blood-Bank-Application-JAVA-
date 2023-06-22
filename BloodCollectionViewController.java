package BloodCollectionTable;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import table.tableBean;

public class BloodCollectionViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField mobile;

    @FXML
    private TableView<BloodCollectionBean> tblgrid;

    @FXML
    void showalldonations(ActionEvent event) 
    {
        ObservableList<BloodCollectionBean>allRecords=getAllObjects();	
        tblgrid.setItems(allRecords);
    	//getAllObjects();

    }
    ObservableList<BloodCollectionBean> List;
    PreparedStatement pst;
    Connection con;
    ResultSet table;
    
    ObservableList<BloodCollectionBean> getAllObjects() 
    {
  	ObservableList<BloodCollectionBean> ary=FXCollections.observableArrayList();
  	
  	PreparedStatement pst;
  	try {
  	pst=con.prepareStatement("select * from donations");
  	table=pst.executeQuery();
  	while(table.next())
  	{
  		String mobile=table.getString("mobile");
  		String bgroup=table.getString("bgroup");
  		String date=table.getString("date");
  		
  		BloodCollectionBean obj=new BloodCollectionBean(mobile,bgroup,date);
  		ary.add(obj);
		    		
  		System.out.println(mobile+" "+bgroup+"  "+date);
  	}
  	}
  	catch(Exception exp)
  	{ 	
  		System.out.println(exp);
  	}
  	System.out.println(ary.size());
  	return ary;
  	
  }

    @SuppressWarnings("unchecked")
	void addcolumns()
    {
    	TableColumn<BloodCollectionBean, String> mobile=new TableColumn<BloodCollectionBean, String>("mobile");
       	mobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));//same as bean property
       	mobile.setMinWidth(150);
    	
       	TableColumn<BloodCollectionBean, String> bgroup=new TableColumn<BloodCollectionBean, String>("bgroup");
       	bgroup.setCellValueFactory(new PropertyValueFactory<>("bgroup"));//same as bean property
       	bgroup.setMinWidth(150);
       	
       	TableColumn<BloodCollectionBean, String> date=new TableColumn<BloodCollectionBean, String>("date");
       	date.setCellValueFactory(new PropertyValueFactory<>("date"));//same as bean property
       	date.setMinWidth(150);
       	
       	tblgrid.getColumns().addAll(mobile,bgroup,date);
       	
    }
    @FXML
    void showrecentcoll(ActionEvent event) 
    {
    	ObservableList<BloodCollectionBean>allRecords=getAllObject();	
        tblgrid.setItems(allRecords);
    	//getAllObjects();

    }
    ObservableList<BloodCollectionBean> getAllObject() 
    {
  	ObservableList<BloodCollectionBean> ary=FXCollections.observableArrayList();
  	
  	PreparedStatement pst;
  	try {
  	pst=con.prepareStatement("select * from donations where mobile=?");
  	pst.setString(1, mobile.getText());
  	table=pst.executeQuery();
  	while(table.next())
  	{
  		String mobile=table.getString("mobile");
  		String bgroup=table.getString("bgroup");
  		String date=table.getString("date");
  		
  		BloodCollectionBean obj=new BloodCollectionBean(mobile,bgroup,date);
  		ary.add(obj);
		    		
  		System.out.println(mobile+" "+bgroup+"  "+date);
  	}
  	}
  	catch(Exception exp)
  	{ 	
  		System.out.println(exp);
  	}
  	System.out.println(ary.size());
  	return ary;
  	
  }

    @FXML
    void initialize() 
    {
    	con=DatabaseConnection3.doConnect();
    	addcolumns();
        assert mobile != null : "fx:id=\"dmobile\" was not injected: check your FXML file 'BloodCollectionView.fxml'.";
        assert tblgrid != null : "fx:id=\"tblgrid\" was not injected: check your FXML file 'BloodCollectionView.fxml'.";

    }

}
