package models;

import java.util.Date;

public class Post {

	private String _id;
	private String userId;
	private String title;
	private String descr;
	private String qualifications;
	private String payment;
	private Date startDate;
	private Date endDate;
	private String additionalInfo;
	private String whatIsOffered;
	private String contactEmail;

	public Post(String _id, String userId, String title, String descr, String qualifications, String payment,
			Date startDate, Date endDate, String additionalInfo, String whatIsOffered, String contactEmail) {
		super();
		this._id = _id;
		this.userId = userId;
		this.title = title;
		this.descr = descr;
		this.qualifications = qualifications;
		this.payment = payment;
		this.startDate = startDate;
		this.endDate = endDate;
		this.additionalInfo = additionalInfo;
		this.whatIsOffered = whatIsOffered;
		this.contactEmail = contactEmail;
	}

	public String get_id() {
		return _id;
	}

	public String getUser() {
		return userId;
	}

	public String getTitle() {
		return title;
	}

	public String getDescr() {
		return descr;
	}

	public String getQualifications() {
		return qualifications;
	}

	public String getPayment() {
		return payment;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public String getWhatIsOffered() {
		return whatIsOffered;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	@Override
	public String toString() {
		return "Post [_id=" + _id + ", userId=" + userId + ", title=" + title + ", descr=" + descr + ", qualifications="
				+ qualifications + ", payment=" + payment + ", startDate=" + startDate + ", endTime=" + endDate
				+ ", additionalInfo=" + additionalInfo + ", whatIsOffered=" + whatIsOffered + ", contactEmail="
				+ contactEmail + "]";
	}

}
