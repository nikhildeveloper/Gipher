package com.app.gif.apicall.Domains;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Meta {
    @JsonProperty("status")
    public int status;
    @JsonProperty("msg")
    public String msg;
    @JsonProperty("response_id")
    public String response_id;
}
