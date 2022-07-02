package com.stackroute.project.wishlist.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection ="Favorites")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Favorite implements Serializable {

    @Id
    private long id;

    private Integer userId;

    private String url;
}

