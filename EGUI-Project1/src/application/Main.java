package application;
	
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application {
	
	//tabla
	private final TableView<Task> table = new TableView<Task>();
	private final ObservableList<Task> data = FXCollections.observableArrayList(new Task("A","B", "C", "D"), new Task("A","B", "C", "D"));
	
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
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
			
			table.setEditable(true);
			
			TableColumn Caja = new TableColumn("Selected");
			
			Caja.setMinWidth(50);
			Caja.setCellValueFactory(new PropertyValueFactory<Task, String>("select"));
			
			
			TableColumn DueDate = new TableColumn("Due Date");
			DueDate.setMinWidth(200);
			DueDate.setCellValueFactory(new PropertyValueFactory<Task, String>("dueDate"));
			
			
			TableColumn Title = new TableColumn("Title");
			Title.setMinWidth(200);
			Title.setCellValueFactory(new PropertyValueFactory<Task, String>("title"));
			
			TableColumn Complete = new TableColumn("% Complete");
			Complete.setMinWidth(200);
			Complete.setCellValueFactory(new PropertyValueFactory<Task, String>("complete"));
			
			TableColumn Description = new TableColumn("Description");
			Description.setMinWidth(200);
			Description.setCellValueFactory(new PropertyValueFactory<Task, String>("description"));
			
			//window open
			table.setOnMousePressed((event) ->{
				try{
					FXMLLoader fxmlLoader =new FXMLLoader();
					fxmlLoader.setLocation(getClass().getResource("/SecondWindow.fxml"));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.setScene(new Scene(root1));
					stage.showAndWait();
				}catch (Exception e) {
					e.printStackTrace();
				}
			});
			
			table.setItems(data);
			table.getColumns().addAll(Caja, DueDate, Title, Complete, Description);
			VBox mid_box= new VBox(10);
			Button read= new Button("Read");
			
			mid_box.getChildren().addAll(read,table);
			root.setCenter(mid_box);
		
			
			
			//
			
			
			
			
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Task Manager");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	
	

	public static class Task {
		private 	final SimpleStringProperty dueDate;
		private  final SimpleStringProperty title;
		private  final SimpleStringProperty complete;
		private  final SimpleStringProperty description;
		private CheckBox select;
		
		private Task(String dDate, String t, String c, String d) {
			this.dueDate = new SimpleStringProperty(dDate);
			this.title = new SimpleStringProperty(t);
			this.complete = new SimpleStringProperty(c);
			this.description = new SimpleStringProperty(d);
			this.select = new CheckBox();
		}

		
		
		
		//GETTERS
		/**
		 * @return the dueDate
		 */
		public SimpleStringProperty getDueDate() {
			return dueDate;
		}

		/**
		 * @return the title
		 */
		public SimpleStringProperty getTitle() {
			return title;
		}

		/**
		 * @return the complete
		 */
		public SimpleStringProperty getComplete() {
			return complete;
		}

		/**
		 * @return the description
		 */
		public SimpleStringProperty getDescription() {
			return description;
		}

	
		public CheckBox getSelect() {
			return select;
		}




		//SETTERS	
		public void setDueDate(String dDate) {
			dueDate.set(dDate);
		}

		public void setTitle(String t) {
			title.set(t);
		}

		public void setComplete(String c) {
			complete.set(c);
		}

		public void setDescription(String d) {
			description.set(d);
		}
		
		public void setSelect(CheckBox select) {
			this.select = select;
		}
		
	}

}

