package com.microservies.kafka.beans;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class User {
    String firstName;
    String lastName;
}
