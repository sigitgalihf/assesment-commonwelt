package com.testbankcommonwelt.assesment.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "administration_activity_log")
public class LogActivityUser {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id")
    private Long id;
	
	@Column(name = "user_id")
    @JsonProperty("user_id")
    private String userId;
	
	@Column(name = "action")
    @JsonProperty("action")
	private String action;
	
	@Column(name = "activity")
    @JsonProperty("activity")
	private String activity;
	
	@Column(name = "ip")
    @JsonProperty("ip")
	private String ip;
	
	@Column(name = "user_agent")
    @JsonProperty("user_agent")
	private String userAgent;
	
	@Column(name = "object")
    @JsonProperty("object")
	private String object;
	
	@Column(name = "system_identity")
    @JsonProperty("system_identity")
	private String systemIdentity;

	@Column(name = "entity_before")
	@JsonProperty("entity_before")
	private String entityBefore;

	@Column(name = "entity_after")
	@JsonProperty("entity_after")
	private String entityAfter;
	
	@Column(name = "created_at")
    @JsonProperty("created_at")
	private Timestamp createdAt;
}
