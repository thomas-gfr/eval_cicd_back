package com.backend.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Employee {

	@Id
	@GeneratedValue
	private int id;

	private String firstName;

	private String lastName;

	private long contactNumber;

	@Temporal(TemporalType.DATE)
	private Date dob;

	private String email;

	private String password;
}