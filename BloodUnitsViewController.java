package BloodUnits;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class BloodUnitsViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField abpid;

    @FXML
    private TextField anid;

    @FXML
    private TextField apid;

    @FXML
    private TextField apnid;

    @FXML
    private TextField bnid;

    @FXML
    private TextField bpid;

    @FXML
    private TextField onid;

    @FXML
    private TextField opid;
    Connection con;
    PreparedStatement pst;

    @FXML
    void doshow(ActionEvent event) throws SQLException 
    {
    	pst=con.prepareStatement("select * from total_blood_record");
    	ResultSet records=pst.executeQuery();
    	if(records.next()==true)
    	{
    		String Op=records.getString("Op");
    		String On=records.getString("On");
    		String Ap=records.getString("Ap");
    		String An=records.getString("An");
    		String Bp=records.getString("Bp");
    		String Bn=records.getString("Bn");
    		String ABp=records.getString("ABp");
    		String ABn=records.getString("ABn");
    		opid.setText(Op);
    		onid.setText(On);
    		apid.setText(Ap);
    		anid.setText(An);
    		bpid.setText(Bp);
    		bnid.setText(Bn);
    		abpid.setText(ABp);
    		apnid.setText(ABn);
    		
    	}
		

    }

    @FXML
    void initialize() {
        con=DatabaseConnection3.doConnect();
    }

}
