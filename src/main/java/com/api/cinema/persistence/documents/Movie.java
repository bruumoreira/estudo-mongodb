package com.api.cinema.persistence.documents;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Document("movie")
public class Movie implements Serializable {

    @Id
    private String id;
    private String movieName;
    private Integer movieCapacity;

}
