package com.zamunda.cinema.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.zamunda.cinema.model.Projection;
import com.zamunda.cinema.model.Reservation;
import com.zamunda.cinema.repository.rowmapper.ReservationRowMapper;

@Repository
public class ReservationRepositoryJdbc implements ReservationRepository {

	//private final RowMapper<Projection> projRowMapper = new MonitorEntryRowMapper();
	private final RowMapper<Reservation> resRowMapper = new ReservationRowMapper();
	@Autowired
	private JdbcTemplate jdbcTmpl;

	@Override
	public List<Projection> getAllProjectionsForHall(int hallId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservation> getAllReservationsForProjection(
			final int projectionId) {
		List<Reservation> reservations = jdbcTmpl
				.execute(new PreparedStatementCreator() {
					public PreparedStatement createPreparedStatement(
							Connection con) throws SQLException {

						String sql = "SELECT * FROM reservation WHERE projection_id = ?";
						PreparedStatement ps = con.prepareStatement(sql);
						ps.setInt(1, projectionId);

						return ps;
					}
				}, new PreparedStatementCallback<List<Reservation>>() {

					@Override
					public List<Reservation> doInPreparedStatement(
							PreparedStatement cs)
							throws SQLException, DataAccessException {
						cs.execute();
						ResultSet rs = cs.getResultSet();
						List<Reservation> me = new ArrayList<>();
						while (rs.next()) {
							me.add(resRowMapper.mapRow(rs, rs.getRow()));
						}
						return me;
					}
				});
		return reservations;
	}

}
