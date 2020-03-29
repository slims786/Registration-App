package com.register.domain;

import java.util.Date;

import lombok.Data;

@Data
public class RegisterDomain {
    private String firstName;
    private String lastName;
    private String email;
    private Long phoneNum;
    private Date dob;
    private String gendar;
    private Integer country;
    private Integer state;
    private Integer city;
    private String pazzword;
}
