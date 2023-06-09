package com.dentalclinic.dentalappointments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@org.springframework.stereotype.Repository
public class Repository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<DentalAppointment> getAll() {
        return jdbcTemplate.query("SELECT id, name, surname, date, type, doctor FROM appointment",
                BeanPropertyRowMapper.newInstance(DentalAppointment.class));
    }

    public DentalAppointment getById(int id) {
        return jdbcTemplate.queryForObject("SELECT id, name, surname, date, type, doctor FROM appointment WHERE " +
                "id = ?", BeanPropertyRowMapper.newInstance(DentalAppointment.class), id);
    }

    public int save(List<DentalAppointment> appointments) {
        appointments.forEach(appointment -> jdbcTemplate
                .update("INSERT INTO appointment(name, surname, date, type, doctor) VALUES(?, ?, ?, ?, ?)",
                        appointment.getName(), appointment.getSurname(),
                        appointment.getDate(), appointment.getType(),appointment.getDoctor()
                ));

        return 1;
    }

    public int update(DentalAppointment appointment) {
        return jdbcTemplate.update("UPDATE appointment SET name=?, surname=?, date=?, type=?, doctor=? WHERE id=?",
                appointment.getName(), appointment.getSurname(), appointment.getDate(),
                appointment.getType(),appointment.getDoctor(), appointment.getId());
    }

    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM appointment WHERE id=?", id);
    }

}