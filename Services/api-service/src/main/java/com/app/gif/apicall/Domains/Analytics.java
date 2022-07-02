package com.app.gif.apicall.Domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Analytics {
    public Onload onload;
    public Onclick onclick;
    public Onsent onsent;
}
