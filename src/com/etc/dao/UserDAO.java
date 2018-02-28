package com.etc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.etc.domain.User;

public class UserDAO {

	private static UserDAO userDAO;

	public static UserDAO getInstance() {
		if (userDAO == null) {
			userDAO = new UserDAO();
		}
		return userDAO;
	}

	public boolean validateUser(User user) {
		String sql = "select *  from t_user where username like ? and password like ?";

		Connection connection = DBUtil.getConn();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			ResultSet resultSet = statement.executeQuery();
			// 如果返回的resultSet为空
			if (!resultSet.next()) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {
		UserDAO userDAO = new UserDAO();
		System.out
				.println(userDAO.validateUser(new User("user0", "password0")));
	}
}
