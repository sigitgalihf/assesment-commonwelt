package com.testbankcommonwelt.assesment.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;


@Data
@RequiredArgsConstructor
public class UserRequest {
    @NonNull
    private String name;

    @NonNull
    private String phone;
}
