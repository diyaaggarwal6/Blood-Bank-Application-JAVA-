package BloodIssuetbl;

import java.net.URL;
import java.util.ResourceBundle;

import BloodCollectionTable.DatabaseConnection3;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;

public class BloodIssueViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> combobg;

    @FXML
    private DatePicker dateid;

    @FXML
    private TableView<BloodIssueBean> tblgrid;

    @FXML
    void dolistall(ActionEvent event) 
    {
    	con=DatabaseConnection3.doConnect();
    	addcolumns();

    }

    @FXML
    void initialize() {
        assert combobg != null : "fx:id=\"combobg\" was not injected: check your FXML file 'BloodIssueView.fxml'.";
        assert dateid != null : "fx:id=\"dateid\" was not injected: check your FXML file 'BloodIssueView.fxml'.";
        assert tblgrid != null : "fx:id=\"tblgrid\" was not injected: check your FXML file 'BloodIssueView.fxml'.";

    }

}
