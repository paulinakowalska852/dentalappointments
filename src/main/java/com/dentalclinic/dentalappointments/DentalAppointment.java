package com.dentalclinic.dentalappointments;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DentalAppointment {
    private int id;
    private String name;
    private String surname;
    private Date date;
    private String type;
    private String doctor;
}
