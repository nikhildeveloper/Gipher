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
public class Pagination {
    @JsonProperty("total_count")
    public int total_count;
    @JsonProperty("count")
    public int count;
    @JsonProperty("offset")
    public int offset;
}
