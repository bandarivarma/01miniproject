package in.ashokit.entities;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class UserAccount {
	@Id
	@GeneratedValue
	private Integer userId;
	private String fullName;
	private String email;
	private Long phno;
	private String gender;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dob;
	private long ssn;
	private String activeSw;
	@CreationTimestamp
	@Column(updatable =false)
	private LocalDate createdDate;
	@UpdateTimestamp
	@Column(insertable =false)
	private LocalDate updatedDate;
	public UserAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserAccount(Integer userId, String fullName, String email, Long phno, String gender, LocalDate dob, long ssn,
			String activeSw, LocalDate createdDate, LocalDate updatedDate) {
		super();
		this.userId = userId;
		this.fullName = fullName;
		this.email = email;
		this.phno = phno;
		this.gender = gender;
		this.dob = dob;
		this.ssn = ssn;
		this.activeSw = activeSw;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhno() {
		return phno;
	}
	public void setPhno(Long phno) {
		this.phno = phno;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public long getSsn() {
		return ssn;
	}
	public void setSsn(long ssn) {
		this.ssn = ssn;
	}
	public String getActiveSw() {
		return activeSw;
	}
	public void setActiveSw(String activeSw) {
		this.activeSw = activeSw;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDate getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}
	@Override
	public String toString() {
		return "UserAccount [userId=" + userId + ", fullName=" + fullName + ", email=" + email + ", phno=" + phno
				+ ", gender=" + gender + ", dob=" + dob + ", ssn=" + ssn + ", activeSw=" + activeSw + ", createdDate="
				+ createdDate + ", updatedDate=" + updatedDate + "]";
	}
	
	
}
