package com.zamunda.cinema.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.joda.time.DateTime;
import org.springframework.jdbc.core.RowMapper;

import com.zamunda.cinema.model.Reservation;

public class ReservationRowMapper implements RowMapper<Reservation> {

	@Override
	public Reservation mapRow(ResultSet rs, int rowNum) throws SQLException {
		Reservation entry = new Reservation();
		entry.setId(rs.getInt("ID"));
		entry.setUserId(rs.getInt("USER_ID"));
		entry.setProjectionId(rs.getInt("PROJECTION_ID"));
		entry.setSeatId(rs.getInt("SEAT_ID"));
		entry.setStatus(rs.getInt("STATUS"));
		entry.setSeatPrice(rs.getInt("SEAT_PRICE"));
		entry.setBlockedTime(new DateTime(rs.getDate("M_TIMESTAMP")));
		return entry;
	}

}
