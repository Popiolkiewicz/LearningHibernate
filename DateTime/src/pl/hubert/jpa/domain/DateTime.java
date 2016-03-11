package pl.hubert.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Hubert
 *
 */
@Entity
@Table(name = "datetime")
public class DateTime {

	@Id
	@GeneratedValue
	private Long id;

	private java.sql.Date date;
	private java.sql.Time time;
	private java.sql.Timestamp timestamp;

	@Temporal(TemporalType.DATE)
	private java.util.Date dateDate;
	@Temporal(TemporalType.TIME)
	private java.util.Date dateTime;
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date dateTimestamp;

	@Temporal(TemporalType.DATE)
	private java.util.Calendar calendarDate;
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Calendar calendarTimestamp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public java.sql.Date getDate() {
		return date;
	}

	public void setDate(java.sql.Date date) {
		this.date = date;
	}

	public java.sql.Time getTime() {
		return time;
	}

	public void setTime(java.sql.Time time) {
		this.time = time;
	}

	public java.sql.Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(java.sql.Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public java.util.Date getDateDate() {
		return dateDate;
	}

	public void setDateDate(java.util.Date dateDate) {
		this.dateDate = dateDate;
	}

	public java.util.Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(java.util.Date dateTime) {
		this.dateTime = dateTime;
	}

	public java.util.Date getDateTimestamp() {
		return dateTimestamp;
	}

	public void setDateTimestamp(java.util.Date dateTimestamp) {
		this.dateTimestamp = dateTimestamp;
	}

	public java.util.Calendar getCalendarDate() {
		return calendarDate;
	}

	public void setCalendarDate(java.util.Calendar calendarDate) {
		this.calendarDate = calendarDate;
	}

	public java.util.Calendar getCalendarTimestamp() {
		return calendarTimestamp;
	}

	public void setCalendarTimestamp(java.util.Calendar calendarTimestamp) {
		this.calendarTimestamp = calendarTimestamp;
	}
}
