package com.testbankcommonwelt.assesment.dto;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String phone;

    public UserDto(Long id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }
}
