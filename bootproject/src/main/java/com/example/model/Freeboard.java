package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "freeboard")
public class Freeboard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long freeid;	// PK
	private String content;
	private String title;
	
}
