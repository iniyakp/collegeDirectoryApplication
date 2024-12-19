package org.jsp.cda.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Faculty {
	@Id
	private int id;
	@OneToOne
	@MapsId
	private User user;
//	private String photo;
	@ManyToOne
	private Department department;
	private LocalDateTime officeHours;

}
