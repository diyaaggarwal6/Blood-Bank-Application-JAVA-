module BloodBank 
{
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.controls;
	requires java.sql;
	requires javafx.base;
	requires java.desktop;
	
	opens application to javafx.graphics, javafx.fxml;
	opens donorregister to javafx.graphics, javafx.fxml;
	opens BloodCollection to javafx.graphics, javafx.fxml;
	opens Login to javafx.graphics, javafx.fxml;
	opens table to javafx.graphics, javafx.fxml,javafx.base;
	opens BloodCollectionTable to javafx.graphics, javafx.fxml,javafx.base;
	opens ContolPanel to javafx.graphics, javafx.fxml;
	opens history to javafx.graphics, javafx.fxml;
	opens BloodUnits to javafx.graphics, javafx.fxml;
	opens IssueBlood to javafx.graphics, javafx.fxml;
	opens BloodIssuedata to javafx.graphics, javafx.fxml,javafx.base;
	opens developer to javafx.graphics, javafx.fxml;

}