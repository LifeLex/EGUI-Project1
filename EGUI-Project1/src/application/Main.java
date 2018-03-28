package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,800,600);
			//Start adding things to pane
			//TOP
			//Creacion Botones y Label
			HBox top_box= new HBox(40);
			Label filter= new Label("Filter");
			RadioButton all= new RadioButton("All");
			RadioButton overdue= new RadioButton("Overdue");
			RadioButton today= new RadioButton("Today");
			RadioButton thisWeek= new RadioButton("This Week");
			CheckBox not_completed= new CheckBox("Not Completed");
			//Colocacion botones y label
			top_box.getChildren().addAll(filter, all, overdue, today, thisWeek, not_completed);
			root.setTop(top_box);
			//Metodos para cada boton/check box
			
			//
			//MID
			TableView table = new TableView();
			
			
			TableColumn DueDate = new TableColumn("Due Date");
			DueDate.setMinWidth(100);
			TableColumn Title = new TableColumn("Title");
			Title.setMinWidth(100);
			TableColumn Complete = new TableColumn("% Complete");
			Complete.setMinWidth(100);
			TableColumn Description = new TableColumn("Description");
			Description.setMinWidth(100);
			
			table.getColumns().addAll(DueDate, Title, Complete, Description);
			VBox mid_box= new VBox(10);
			Button read= new Button("Read");
			
			mid_box.getChildren().addAll(read,table);
			root.setCenter(mid_box);
		
			
			
			//
			
			
			
			
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
