package org.cit.shoppinglist.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.cit.shoppinglist.dao.SharedUserListDao;
import org.cit.shoppinglist.model.SharedUserList;
import org.cit.shoppinglist.model.UserList;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class SharedUserListDaoImpl implements SharedUserListDao {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	private JdbcTemplate jdbcTemplate;

	@Override
	public void saveSharedUserList(SharedUserList sharedUserList) {
		jdbcTemplate = new JdbcTemplate(dataSource);

		// insert UserListItem
		String sql = "INSERT INTO SharedUserList (UserListId, sharedByUserId, sharedToUserId) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, sharedUserList.getUserListId(), sharedUserList.getSharedByUserId(), sharedUserList.getSharedToUserId());

	}

	@Override
	public List<UserList> getSharedUserListsByUserId(int userId) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "SELECT ul.* FROM UserList ul,SharedUserList sul WHERE sul.UserListId = ul.Id and sul.SharedToUserId = " + userId;

		List<UserList> userList = jdbcTemplate.query(sql, new RowMapper<UserList>() {

			public UserList mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserList userList = new UserList();
				userList.setId(rs.getInt("Id"));
				userList.setUserId(rs.getInt("UserId"));
				userList.setName(rs.getString("Name"));
				
				return userList;
			}
		});
		
		return userList;
	}

	@Override
	public boolean checkListSharedToUser(int userListId, int userId) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		// String sql = "SELECT * FROM SharedUserList WHERE SharedToUserId =" +
		// userId + " AND UserListId = " + userListId;
		String sql = "SELECT EXISTS(SELECT * FROM  SharedUserList WHERE SharedToUserId = " + userId + " AND UserListId = " + userListId + ")";

		Boolean isListShared = jdbcTemplate.queryForObject(sql, Boolean.class);

		return isListShared;
	}
	
	@Override
	public void markUnmarkUserListItem(int userListItemId, boolean purchased) {
		jdbcTemplate = new JdbcTemplate(dataSource);

		String sql = "UPDATE UserListItem SET Purchased=? WHERE Id = ?";
		jdbcTemplate.update(sql, purchased, userListItemId);
		
	}

}
