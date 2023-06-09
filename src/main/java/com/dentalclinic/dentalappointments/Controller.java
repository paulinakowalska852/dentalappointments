package com.dentalclinic.dentalappointments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class Controller {@Autowired
private com.dentalclinic.dentalappointments.Repository appointmentRepository;

    @GetMapping("")
    public List<DentalAppointment> getAllAppointments() {
        return appointmentRepository.getAll();
    }

    @GetMapping("/{id}")
    public DentalAppointment getAppointmentById(@PathVariable("id") int id) {
        return appointmentRepository.getById(id);
    }

    @PostMapping("")
    public int addAppointment(@RequestBody List<DentalAppointment> appointments) {
        return appointmentRepository.save(appointments);
    }

    @PutMapping("/{id}")
    public int updateAppointment(@PathVariable("id") int id, @RequestBody DentalAppointment updatedAppointment) {
        DentalAppointment appointment = appointmentRepository.getById(id);

        if (appointment != null) {
            appointment.setName(updatedAppointment.getName());
            appointment.setSurname(updatedAppointment.getSurname());
            appointment.setDate(updatedAppointment.getDate());
            appointment.setType(updatedAppointment.getType());
            appointment.setDoctor(updatedAppointment.getDoctor());


            appointmentRepository.update(appointment);

            return 1;
        } else {
            return -1;
        }
    }

    @PatchMapping("/{id}")
    public int partiallyUpdateAppointment(@PathVariable("id") int id, @RequestBody DentalAppointment updatedAppointment) {
        DentalAppointment appointment = appointmentRepository.getById(id);

        if (appointment != null) {
            if (updatedAppointment.getName() != null) {
                appointment.setName(updatedAppointment.getName());
            }
            if (updatedAppointment.getSurname() != null) {
                appointment.setSurname(updatedAppointment.getSurname());
            }
            if (updatedAppointment.getDate() != null) {
                appointment.setDate(updatedAppointment.getDate());
            }
            if (updatedAppointment.getType() != null) {
                appointment.setType(updatedAppointment.getType());
            }
            if (updatedAppointment.getDoctor() != null) {
                appointment.setDoctor(updatedAppointment.getDoctor());
            }


            appointmentRepository.update(appointment);

            return 1;
        } else {
            return -1;
        }
    }

    @DeleteMapping("/{id}")
    public int deleteAppointment(@PathVariable("id") int id) {
        return appointmentRepository.delete(id);
    }
}