package org.cit.shoppinglist.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.cit.shoppinglist.dao.UserListDao;
import org.cit.shoppinglist.model.SharedUserList;
import org.cit.shoppinglist.model.UserList;
import org.cit.shoppinglist.model.UserListItem;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class UserListDaoImpl implements UserListDao {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	private JdbcTemplate jdbcTemplate;

	@Override
	public int createUserList(final UserList userList) {
		jdbcTemplate = new JdbcTemplate(dataSource);

		// insert User List
		final String sql = "INSERT INTO UserList (Name, UserId) VALUES (?, ?)";
		
		KeyHolder holder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, userList.getName());
				ps.setInt(2, userList.getUserId());
				return ps;
			}
		}, holder);

		int userListId = holder.getKey().intValue();
		
		return userListId;
	}
	
	@Override
	public UserList getUserListByUserId(int userId) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "SELECT * FROM UserList WHERE UserId=" + userId;

		return jdbcTemplate.query(sql, new ResultSetExtractor<UserList>() {

			public UserList extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					UserList userList = new UserList();
					userList.setId(rs.getInt("Id"));
					userList.setUserId(rs.getInt("UserId"));
					userList.setName(rs.getString("Name"));

					return userList;
				}
				
				return null;
			}
		});
	}
	
	@Override
	public List<UserListItem> getUserListItemsByUserListId(int userListId) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		String sql = "SELECT * FROM UserListItem WHERE UserListId = " + userListId;

		List<UserListItem> userListItems = jdbcTemplate.query(sql, new RowMapper<UserListItem>() {

			public UserListItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserListItem userListItem = new UserListItem();
				userListItem.setId(rs.getInt("Id"));
				userListItem.setItem(rs.getString("Item"));
				userListItem.setUserListId(rs.getInt("UserListId"));
				userListItem.setPurchased(rs.getBoolean("Purchased"));

				return userListItem;
			}
		});

		return userListItems;
	}
	
	@Override
	public void deleteUserListItem(int userListItemId) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "DELETE FROM UserListItem WHERE Id=?";

		jdbcTemplate.update(sql, userListItemId);
	}
	
	@Override
	public void saveUserListItem(UserListItem userListItem) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		if(userListItem.getId() > 0) {
			String sql = "UPDATE UserListItem SET UserListId=?, Item=?, Purshased=? WHERE Id = ?";
			jdbcTemplate.update(sql, userListItem.getUserListId(), userListItem.getItem(), userListItem.isPurchased(), userListItem.getId());
		} else {
			// insert UserListItem
			String sql = "INSERT INTO UserListItem (UserListId, Item, Purchased) VALUES (?, ?, ?)";
			jdbcTemplate.update(sql, userListItem.getUserListId(), userListItem.getItem(), userListItem.isPurchased());
		}
	}
	
	@Override
	public void saveSharedUserList(SharedUserList sharedUserList) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		// insert UserListItem
		String sql = "INSERT INTO SharedUserList (UserListId, sharedByUserId, sharedToUserId) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, sharedUserList.getUserListId(), sharedUserList.getSharedByUserId(), sharedUserList.getSharedToUserId());
	}
	
	@Override
	public boolean checkListSharedToUser(int userListId, int userId) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		//String sql = "SELECT * FROM SharedUserList WHERE SharedToUserId =" + userId + " AND UserListId = " + userListId;
		String sql = "SELECT EXISTS(SELECT * FROM  SharedUserList WHERE SharedByUserId = " + userId + " AND UserListId = " + userListId + ")";
		
		Boolean isListShared = jdbcTemplate.queryForObject(sql, Boolean.class);
		
		return isListShared;
	}
	
}
