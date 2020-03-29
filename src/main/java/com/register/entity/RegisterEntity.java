package com.register.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name="Register_Master")
@Data
public class RegisterEntity {
	@Id
	@Column(name="RID")
	@GeneratedValue
	private Integer rid;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="EMAIL",unique= true)
	private String email;
	@Column(name="PHONE_NUM")
	private Long phoneNum;
	@Temporal(TemporalType.DATE)
	@Column(name="DOB")
	private Date dob;
	@Column(name="GENDER")
	private String gendar;
	@Column(name="COUNTRY")
	private Integer country;
	@Column(name="STATE")
	private Integer state;
	@Column(name="CITY")
	private Integer city;
	@Column(name="PAZZWORD")
	private Long password;
	@Column(name="STATUS")
	private char status;
	@Temporal(TemporalType.DATE )
	@Column(name="CREATED_DATE",updatable=false)
	private Date created_date;
	@Temporal(TemporalType.DATE)
	@Column(name="UPDATED_DATE",insertable=false)
	private Date updated_date;
}
