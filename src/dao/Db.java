package dao;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

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
			return false;
		}
	}

}
