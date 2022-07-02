package com.app.gif.apicall.Domains;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonPropertyOrder({
    "data",
    "pagination",
    "meta"
})
public class Gif{
   @JsonProperty("data")
   public ArrayList<Data> data;
   @JsonProperty("pagination")
   public Pagination pagination;
   @JsonProperty("meta")
   public Meta meta; 
}
