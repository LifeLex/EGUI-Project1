package application;

import javafx.beans.property.SimpleStringProperty;

public class Task {
	private SimpleStringProperty dueDate;
	private SimpleStringProperty title;
	private SimpleStringProperty complete;
	private SimpleStringProperty description;
	
	private Task(String dDate, String t, String c, String d) {
		this.dueDate = new SimpleStringProperty(dDate);
		this.title = new SimpleStringProperty(t);
		this.complete = new SimpleStringProperty(c);
		this.description = new SimpleStringProperty(d);
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

	
	
	//SETTERS	
	public void setDueDate(SimpleStringProperty dueDate) {
		this.dueDate = dueDate;
	}

	public void setTitle(SimpleStringProperty title) {
		this.title = title;
	}

	public void setComplete(SimpleStringProperty complete) {
		this.complete = complete;
	}

	public void setDescription(SimpleStringProperty description) {
		this.description = description;
	}
	
}
