package com.testbankcommonwelt.assesment.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
public class AppConfigDto {
    private Long id;
    private String config;
    private String value;
    private Timestamp updated_at;

    // ADD NEW PARAMETER NOT INJECTED
    private String config_draft;
    private String value_draft;
    private String status;
    private String description;
    private String type;
    private Timestamp created_at;
    private String created_by;
    private String updated_by;
    private String approved_by;
    private Timestamp approved_at;
    private String remarks;

    // APPROVE APP CONFIG , REJECT APP CONFIG
    public AppConfigDto(@NotNull String config, @NotNull String value, @NotNull Timestamp updated_at, @NotNull String status, @NotNull String updated_by, String remarks) {
        this.config = config;
        this.value = value;
        this.updated_at = updated_at;
        this.status = status;
        this.updated_by = updated_by;
        this.remarks = remarks;
    }

    // UPDATE APP CONFIG
    public AppConfigDto(@NotNull String config, @NotNull String value, @NotNull String updated_by) {
        this.config = config;
        this.value = value;
        this.updated_by = updated_by;
    }
}
