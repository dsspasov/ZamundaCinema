package com.zamunda.cinema.model;

import org.joda.time.DateTime;

public class Projection {
	private Long id;
	private DateTime startOfProjection;
	private DateTime endOfProjection;
	private Long hallId;
	private Long filmId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public DateTime getStartOfProjection() {
		return startOfProjection;
	}
	public void setStartOfProjection(DateTime startOfProjection) {
		this.startOfProjection = startOfProjection;
	}
	public DateTime getEndOfProjection() {
		return endOfProjection;
	}
	public void setEndOfProjection(DateTime endOfProjection) {
		this.endOfProjection = endOfProjection;
	}
	public Long getHallId() {
		return hallId;
	}
	public void setHallId(Long hallId) {
		this.hallId = hallId;
	}
	public Long getFilmId() {
		return filmId;
	}
	public void setFilmId(Long filmId) {
		this.filmId = filmId;
	}
	
	

}
