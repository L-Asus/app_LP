package com.example.prueba.crud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jpos.iso.ISODate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "proj_LP")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    @Id
    private int id;
    private String email;
    private String mailPass;
    private String phone;
    private String countryPhone;
    private String tag;
    private String createAt;
    private boolean active;
}
