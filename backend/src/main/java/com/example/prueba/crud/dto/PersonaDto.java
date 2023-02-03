package com.example.prueba.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jpos.iso.ISODate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDto {
    private int id;
    private String email;
    private String mailPass;
    private String phone;
    private String countryPhone;
    private String tag;
    private String createAt;
    private boolean active;
}
