package org.cit.shoppinglist.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.cit.shoppinglist.dao.ProductDao;
import org.cit.shoppinglist.model.Product;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class ProductDaoImpl implements ProductDao {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	private JdbcTemplate jdbcTemplate;

	@Override
	public void saveOrUpdate(Product product) {
		jdbcTemplate = new JdbcTemplate(dataSource);

		if (product.getId() > 0) {
			// update
			String sql = "UPDATE Product SET Name=?, Price=?, Description=? WHERE Id=?";
			jdbcTemplate.update(sql, product.getName(), product.getPrice(), product.getDescription(), product.getId());
		} else {
			// insert
			String sql = "INSERT INTO Product (Name, Price, Description)" + " VALUES (?, ?, ?)";
			jdbcTemplate.update(sql, product.getName(), product.getPrice(), product.getDescription());
		}
	}

	@Override
	public void delete(int productId) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "DELETE FROM Product WHERE Id=?";

		jdbcTemplate.update(sql, productId);
	}

	@Override
	public Product getById(int productId) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "SELECT * FROM Product WHERE Id=" + productId;

		return jdbcTemplate.query(sql, new ResultSetExtractor<Product>() {

			public Product extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Product product = new Product();
					product.setId(rs.getInt("Id"));
					product.setName(rs.getString("Name"));
					product.setPrice(rs.getDouble("Price"));
					product.setDescription(rs.getString("Description"));

					return product;
				}
				return null;
			}
		});
	}

	@Override
	public List<Product> getAllProducts() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "SELECT * FROM Product";

		List<Product> products = jdbcTemplate.query(sql, new RowMapper<Product>() {

			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
				product.setId(rs.getInt("Id"));
				product.setName(rs.getString("Name"));
				product.setPrice(rs.getDouble("Price"));
				product.setDescription(rs.getString("Description"));

				return product;
			}
		});

		return products;
	}

}
