package com.vazulsolutions.com.art.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import lombok.Data;


@Entity
@Table(name = "Artists")
@Data
public class Artist implements Serializable {

	private static final long serialVersionUID = 5009018150902125073L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("ConstituentID")
	@Positive
	long constituentId;

	@NotBlank
	@JsonProperty("DisplayName")
	String displayName;

	@NotBlank
	@JsonProperty("ArtistBio")
	String artistBio;

	@JsonProperty("Nationality")
	String nationality;

	@JsonProperty("Gender")
	@Pattern(regexp = "Male|Female")
	String gender;

	@JsonProperty("BeginDate")
	Integer beginDate;

	@JsonProperty("EndDate")
	Integer endDate;

	@JsonProperty("Wiki QID")
	String wikiQid;

	@JsonProperty("ULAN")
	Integer uLan;
}
