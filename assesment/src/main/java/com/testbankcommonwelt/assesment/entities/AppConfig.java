package com.testbankcommonwelt.assesment.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "app_configs")
public class AppConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id")
    private Long id;

    @Column(name = "config")
    @JsonProperty("config")
    private String config;

    @Column(name = "value")
    @JsonProperty("value")
    private String value;

    @Column(name = "updated_at")
    @JsonProperty("updated_at")
    private Timestamp updatedAt;

    // ADD NEW PARAMETER NOT INJECTED

    @Column(name = "config_draft")
    @JsonProperty("config_draft")
    private String configDraft;

    @Column(name = "value_draft")
    @JsonProperty("value_draft")
    private String valueDraft;

    @Column(name = "status")
    @JsonProperty("status")
    private String status;

    @Column(name = "description")
    @JsonProperty("description")
    private String description;

    @Column(name = "type")
    @JsonProperty("type")
    private String type;

    @Column(name = "created_at")
    @JsonProperty("created_at")
    private Timestamp createdAt;

    @Column(name = "created_by")
    @JsonProperty("created_by")
    private String createdBy;

    @Column(name = "updated_by")
    @JsonProperty("updated_by")
    private String updatedBy;

    @Column(name = "approved_by")
    @JsonProperty("approved_by")
    private String approvedBy;

    @Column(name = "approved_at")
    @JsonProperty("approved_at")
    private Timestamp approvedAt;

    @Column(name = "remarks")
    @JsonProperty("remarks")
    private String remarks;

}
