package com.fortna.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Getter   @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {

    @JsonProperty("firstname")
    private String firstName;
    @JsonProperty("lastname")
    private String lastName;


}
