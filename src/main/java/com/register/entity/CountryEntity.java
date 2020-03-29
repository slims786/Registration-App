package com.register.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "COUNTRY_MASTER")
public class CountryEntity {
	@Id
	@Column(name= "COUNTRY_ID")
   public Integer countryId;
   @Column(name= "COUNTRY_NAME")
   public String countryName;
   @Column(name= "COUNTRY_CODE")
   public Integer countryCode;
}
