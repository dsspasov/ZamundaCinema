package com.zamunda.cinema.model;

import org.joda.time.DateTime;

public class Reservation {
	private int id;
	private int userId;
	private int projectionId;
	private int seatId;
	private int status;
	private int seatPrice;
	private DateTime blockedTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProjectionId() {
		return projectionId;
	}

	public void setProjectionId(int projectionId) {
		this.projectionId = projectionId;
	}

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getSeatPrice() {
		return seatPrice;
	}

	public void setSeatPrice(int seatPrice) {
		this.seatPrice = seatPrice;
	}

	public DateTime getBlockedTime() {
		return blockedTime;
	}

	public void setBlockedTime(DateTime blockedTime) {
		this.blockedTime = blockedTime;
	}
}
