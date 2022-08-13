package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import model.Task;
import utility.Log;

public class Db {

	private String server;
	private String port;
	private String ddbb;
	private String user;
	private String password;

	public Db() {
		this.server = "localhost";
		this.port = "3306";
		this.ddbb = "tasks_manager";
		this.user = "root";
		this.password = "";
	}

	private Connection connection;

	public boolean connect() {
		try {
			connection = (Connection) DriverManager.getConnection(
					"jdbc:mysql://" + this.server + ":" + this.port + "/" + this.ddbb, this.user, this.password);
			return true;
		} catch (Exception e) {
			Log.error(e);
			return false;
		}
	}

	private Statement statement;
	private ResultSet resultSet;

	public boolean createTask(Task task) {
		boolean result = false;
		if (connect()) {
			try {
				statement = (Statement) connection.createStatement();
				result = statement.execute(QueryBuilder.createTask(task));
				statement.close();
				result = true;
			} catch (SQLException e) {
				Log.error(e);
			}
		}
		return result;
	}

	public List<Task> readTasks() {
		List<Task> tasks = new ArrayList<Task>();
		if (connect()) {
			try {
				statement = (Statement) connection.createStatement();
				resultSet = statement.executeQuery(QueryBuilder.readAllTasks());
				while (resultSet.next()) {
					int id = resultSet.getInt("id");
					String title = resultSet.getString("title");
					String content = resultSet.getString("content");
					boolean isCompleted = resultSet.getBoolean("is_completed");
					LocalDateTime dateCreated = resultSet.getTimestamp(5).toLocalDateTime();
					Task task = new Task(id, title, content, isCompleted, dateCreated);
					tasks.add(task);
				}
				resultSet.close();
				statement.close();
			} catch (SQLException e) {
				Log.error(e);
			}
		}
		return tasks;
	}

	public Task readTask(int id) {
		Task task = new Task();
		if (connect()) {
			try {
				statement = (Statement) connection.createStatement();
				resultSet = statement.executeQuery(QueryBuilder.readTaskById(id));
				while (resultSet.next()) {
					int idReadFromDb = resultSet.getInt("id");
					String title = resultSet.getString("title");
					String content = resultSet.getString("content");
					boolean isCompleted = resultSet.getBoolean("is_completed");
					LocalDateTime dateCreated = resultSet.getTimestamp(5).toLocalDateTime();
					task.setId(idReadFromDb);
					task.setTitle(title);
					task.setContent(content);
					task.setCompleted(isCompleted);
					task.setDateCreated(dateCreated);
				}
				resultSet.close();
				statement.close();
			} catch (SQLException e) {
				Log.error(e);
			}
		}
		return task;
	}

	public boolean updateTask(Task task) {
		boolean result = false;
		if (connect()) {
			try {
				statement = (Statement) connection.createStatement();
				result = statement.execute(QueryBuilder.updateTask(task));
				statement.close();
				result = true;
			} catch (SQLException e) {
				Log.error(e);
			}
		}
		return result;
	}

	public boolean deleteTask(int id) {
		boolean result = false;
		if (connect()) {
			try {
				statement = (Statement) connection.createStatement();
				result = statement.execute(QueryBuilder.deleteTask(id));
				statement.close();
				result = true;
			} catch (SQLException e) {
				Log.error(e);
			}
		}
		return result;
	}

}
