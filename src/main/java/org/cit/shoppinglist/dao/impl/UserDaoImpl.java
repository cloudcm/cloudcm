package org.cit.shoppinglist.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.cit.shoppinglist.dao.UserDao;
import org.cit.shoppinglist.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class UserDaoImpl implements UserDao {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	private JdbcTemplate jdbcTemplate;

	@Override
	public int createUser(final User user) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		// insert User
		final String sql = "INSERT INTO User (FirstName, LastName, Username, Password, Enabled) VALUES (?, ?, ?, ?, ?)";

		KeyHolder holder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, user.getFirstName());
				ps.setString(2, user.getLastName());
				ps.setString(3, user.getUsername());
				ps.setString(4, user.getPassword());
				ps.setBoolean(5, true);
				return ps;
			}
		}, holder);

		int userId = holder.getKey().intValue();

		// insert User Role
		String roleSql = "INSERT INTO UserRole (UserId, Role) VALUES (?, ?)";
		jdbcTemplate.update(roleSql, userId, User.ROLE_USER);

		return userId;
	}
	
	@Override
	public User getUserbyUsername(String username) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "SELECT * FROM User WHERE Username= '" + username + "'";

		return jdbcTemplate.query(sql, new ResultSetExtractor<User>() {

			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					User user = new User();
					user.setId(rs.getInt("Id"));
					user.setFirstName(rs.getString("FirstName"));
					user.setLastName(rs.getString("LastName"));
					user.setUsername(rs.getString("Username"));
					user.setPassword(rs.getString("Password"));
					user.setEnabled(rs.getBoolean("Enabled"));

					return user;
				}
				
				return null;
			}
		});
	}
}
