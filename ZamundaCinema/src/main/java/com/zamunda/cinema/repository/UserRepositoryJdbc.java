package com.zamunda.cinema.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zamunda.cinema.model.Hall;

@Repository
public class UserRepositoryJdbc implements UserRepository {

	// First we need to decide Oracle or MySQL
	@Autowired
	private NamedParameterJdbcTemplate jdbcTmpl;

	// Example of Add in DB
	@Override
	public Long addUser() {

		String seq = "select USER_SEQ.nextval from dual "; // If we are using
															// Oracle

//		Long userId = jdbcTmpl.query(seq, new ResultSetExtractor<Long>() { // If
//																			// we
//																			// are
//																			// using
//																			// Oracle
//			@Override
//			public Long extractData(ResultSet rs) throws SQLException, DataAccessException {
//				while (rs.next()) {
//					return rs.getLong(1);
//				}
//				return null;
//			}
//		});

		Map<String, Object> params = new HashMap<String, Object>();

		//params.put("id", userId);

		StringBuilder sql = new StringBuilder();
		sql.append("insert into USER (ID, ..., ...) ");
		sql.append("values(:id, :.. , :..) ");

		return null;
	}

	@Override
	public List<Hall> getHalls() {
		String sql = "select * from halls "; 
		List<Hall> allHalls = jdbcTmpl.query(sql, new ResultSetExtractor<List<Hall>>() {

			@Override
			public List<Hall> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				List<Hall> listOfAllHalls = new ArrayList<Hall>();
				while (rs.next()) {
					Hall hall = new Hall();
					hall.setId(rs.getLong("id"));
					hall.setName(rs.getString("name"));
					listOfAllHalls.add(hall);
				}
				return listOfAllHalls;
			}
		});
		return allHalls;
	}

}
