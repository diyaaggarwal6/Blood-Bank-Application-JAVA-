package table;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class tableViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> combobg;

    @FXML
    private TableView<tableBean> tblGrid;

    ObservableList<tableBean> List;
    PreparedStatement pst;
	@FXML
    void dofetch(ActionEvent event) 
    {
    	
    	   	
    	List=FXCollections.observableArrayList();
    	try {
    		pst=con.prepareStatement("select * from registerdata where BloodGroup= ? ");
    		   pst.setString(1,combobg.getSelectionModel().getSelectedItem());
			ResultSet table=pst.executeQuery();
			while(table.next())
			{
				int Age=table.getInt("Age");
	    		String Name=table.getString("Name");
	    		String MobileNo=table.getString("MobileNo");
	    		String Gender=table.getString("Gender");
	    		String Address=table.getString("Address");
	    		String City=table.getString("City");
	    		String Disease=table.getString("Disease");
	    		String BloodGroup=table.getString("BloodGroup");
	    		tableBean obj=new tableBean(MobileNo,Name,Gender,Address,Age,City,Disease,BloodGroup);
				List.add(obj);
			}
			tblGrid.setItems(List);
		} catch (SQLException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }

    @FXML
    void doshowall(ActionEvent event)
    {
    	
    	
    	ObservableList<tableBean>allRecords=getAllObjects();	
    	

    	tblGrid.setItems(allRecords);
    	//getAllObjects();

    }

    ResultSet table;
    Connection con;
    
   ObservableList<tableBean> getAllObjects() 
      {
    	ObservableList<tableBean> ary=FXCollections.observableArrayList();
    	
    	PreparedStatement pst;
    	try {
    	pst=con.prepareStatement("select * from registerdata");
    	table=pst.executeQuery();
    	while(table.next())
    	{
    		int Age=table.getInt("Age");//col wala name
    		String Name=table.getString("Name");
    		String MobileNo=table.getString("MobileNo");
    		String Gender=table.getString("Gender");
    		String Address=table.getString("Address");
    		String City=table.getString("City");
    		String Disease=table.getString("Disease");
    		String BloodGroup=table.getString("BloodGroup");
    		tableBean obj=new tableBean(MobileNo,Name,Gender,Address,Age,City,Disease,BloodGroup);
    		ary.add(obj);
		    		
    		System.out.println(MobileNo+"  "+Name+"  "+Gender+"  "+Address+" "+Age+" "+City+" "+Disease+" "+BloodGroup);
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

   	TableColumn<tableBean, String> MobileNo=new TableColumn<tableBean, String>("Mobile Number");
   	MobileNo.setCellValueFactory(new PropertyValueFactory<>("MobileNo"));//same as bean property
   	MobileNo.setMinWidth(100);
   	
   	TableColumn<tableBean, String> Name=new TableColumn<tableBean, String>("Name");
   	Name.setCellValueFactory(new PropertyValueFactory<>("Name"));//same as bean property
   	Name.setMinWidth(50);
   	
   	TableColumn<tableBean, String> Gender=new TableColumn<tableBean, String>("Gender");
   	Gender.setCellValueFactory(new PropertyValueFactory<>("Gender"));//same as bean property
   	Gender.setMinWidth(50);
   	
   	TableColumn<tableBean, String> Address=new TableColumn<tableBean, String>("Address");
       Address.setCellValueFactory(new PropertyValueFactory<>("Address"));//same as bean property
   	Address.setMinWidth(50);
   	
   	TableColumn<tableBean, Integer> Age=new TableColumn<tableBean, Integer>("Age");
   	Age.setCellValueFactory(new PropertyValueFactory<>("Age"));//same as bean property
   	Age.setMinWidth(50);
   	
   	TableColumn<tableBean, String> City=new TableColumn<tableBean, String>("City");
   	City.setCellValueFactory(new PropertyValueFactory<>("City"));//same as bean property
   	City.setMinWidth(50);
   	
   	TableColumn<tableBean, String> Disease=new TableColumn<tableBean, String>("Disease");
   	Disease.setCellValueFactory(new PropertyValueFactory<>("Disease"));//same as bean property
   	Disease.setMinWidth(50);
   	
   	TableColumn<tableBean, String> BloodGroup=new TableColumn<tableBean, String>("BloodGroup");
   	BloodGroup.setCellValueFactory(new PropertyValueFactory<>("BloodGroup"));//same as bean property
   	BloodGroup.setMinWidth(50);
   	
   	tblGrid.getColumns().addAll(MobileNo,Name,Gender,Address,Age,City,Disease,BloodGroup);
   	
   	
   }
   
   
    
   
   @FXML
   void doexport(ActionEvent event) throws Exception 
   {
	   try {
			writeExcel(getAllObjects());
			System.out.println("Exported to excel..");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

   }
   
   public void writeExcel( ObservableList<tableBean> list) throws Exception {
       Writer writer = null;
       try {
       	File file = new File("Hw.csv");
           writer = new BufferedWriter(new FileWriter(file));
           String text="Name,MobileNo,Age,Address,BloodGroup,City,Disease,Gender\n";
           writer.write(text);
           for (tableBean p : list)
           {
				text = p.getName()+ "," + p.getMobileNo()+ "," + p.getAge()+ "," + p.getAddress()+","+p.getBloodGroup()+","+p.getCity()+","+p.getDisease()+","+p.getGender()+"\n";
               writer.write(text);
           }
       } catch (Exception ex) {
           ex.printStackTrace();
       }
       finally {
          
           writer.flush();
            writer.close();
       }
   }

   
    @FXML
    void initialize() 
    {
    	addcolumns();

    	con=DatabaseConnection3.doConnect();
    	ArrayList<String>bg=new ArrayList<String>(Arrays.asList("Op","On","Bp","Bn","ABp","ABn","Ap","An"));
    	combobg.getItems().addAll(bg);
    	
    }

}
