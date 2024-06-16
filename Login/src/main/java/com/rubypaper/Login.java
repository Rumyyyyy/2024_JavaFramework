package com.rubypaper;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Login {
    @Id
    @GeneratedValue
    private int no;
    private String id;
    private String pw;
}
