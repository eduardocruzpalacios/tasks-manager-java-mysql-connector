package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		if (connect()) {
			try {
				statement = (Statement) connection.createStatement();
				resultSet = statement.executeQuery(QueryBuilder.readAllTasks());
				List<Task> tasks = new ArrayList<Task>();
				while (resultSet.next()) {
					Task task = new Task();
					task.setId(resultSet.getInt("id"));
					task.setTitle(resultSet.getString("title"));
					task.setContent(resultSet.getString("content"));
					task.setCompleted(resultSet.getBoolean("is_completed"));
					task.setDateCreated(resultSet.getTimestamp(5).toLocalDateTime());
					tasks.add(task);
				}
				resultSet.close();
				statement.close();
				return tasks;
			} catch (SQLException e) {
				Log.error(e);
			}
		}
		return null;
	}

	public Task readTask(int id) {
		if (connect()) {
			try {
				statement = (Statement) connection.createStatement();
				resultSet = statement.executeQuery(QueryBuilder.readTaskById(id));
				Task task = new Task();
				while (resultSet.next()) {
					task.setId(resultSet.getInt("id"));
					task.setTitle(resultSet.getString("title"));
					task.setContent(resultSet.getString("content"));
					task.setCompleted(resultSet.getBoolean("is_completed"));
					task.setDateCreated(resultSet.getTimestamp(5).toLocalDateTime());
				}
				resultSet.close();
				statement.close();
				return task;
			} catch (SQLException e) {
				Log.error(e);
			}
		}
		return null;
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
