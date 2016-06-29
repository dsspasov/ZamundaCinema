package com.zamunda.cinema.repository;

import java.util.List;

import com.zamunda.cinema.model.Projection;
import com.zamunda.cinema.model.Reservation;

public interface ReservationRepository {
	public List<Projection> getAllProjectionsForHall(final int hallId);

	public List<Reservation> getAllReservationsForProjection(
			final int projectionId);
}
