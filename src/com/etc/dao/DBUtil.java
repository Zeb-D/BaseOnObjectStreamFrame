package com.etc.dao;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {

	public static Connection getConn() {
		return getConn("src/db.properties");
	}

	public static Connection getConn(String propertiesFile) {
		Properties properties = new Properties();

		try {
			properties.load(new FileInputStream(new File(propertiesFile)));
		} catch (Exception e) {
			e.printStackTrace();
		}

		/**
		 * Access denied for user 'root 这是用户密码填写错误
		 */
		String host = properties.getProperty("mysql.host");
		String port = properties.getProperty("mysql.port");
		String database = properties.getProperty("mysql.database");
		String username = properties.getProperty("mysql.username");
		String password = properties.getProperty("mysql.password");

		return getConn(host, port, database, username, password);
	}

	public static Connection getConn(String host, String port, String database,
			String username, String password) {
		// 驱动名
		String driver = "com.mysql.jdbc.Driver";

		// 加载驱动
		// 没加载驱动报错No suitable driver found for
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 数据库访问url, 中文处理GBK编码 
		String url = "jdbc:mysql://" + host + ":" + port + "/" + database
				+ "?useUnicode=true&characterEncoding=GBK&user=" + username
				+ "&password=" + password;

		// 连接数据库
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

	public static void close(ResultSet resultSet) {
		try {
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Statement statement) {
		try {
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void close(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
