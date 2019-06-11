package pl.szymanskihubert.rsqtask.appointments

import org.springframework.stereotype.Component
import pl.szymanskihubert.rsqtask.doctors.DoctorsRepository
import pl.szymanskihubert.rsqtask.patients.PatientsRepository
import java.time.LocalDateTime

@Component
class AppointmentService( val appointmentsRepository: AppointmentsRepository, val doctorsRepository: DoctorsRepository, val patientsRepository: PatientsRepository ) {

    // add a new appointment
    fun addNew( newAppointment: Appointment) : String {

        // check if patient exist
        if ( !patientsRepository.existsById( newAppointment.patientId) ) return "Patient not found"

        // check if doctor exist
        if ( !doctorsRepository.existsById( newAppointment.doctorId) ) return "Doctor not found"

        // if they exists add the appointment to the db
        appointmentsRepository.save( newAppointment )
        return "Appointment added"
    }

    // remove the appointment
    fun delete( id: Long ) : String {

        // if appointment does not exist return "Not Found"
        if ( !appointmentsRepository.existsById(id) ) return "Not Found"

        // else delete it and return "Deleted"
        appointmentsRepository.deleteById( id )
        return "Appointment Deleted"

    }

    // change date of the appointment
    fun update(appointmentId: Long, newDate: LocalDateTime) : String {
        // check if appointment exists
        if ( !appointmentsRepository.existsById( appointmentId ))
            return "Appointment not found"

        // find appointment by id
        var appointmentToUpdate = appointmentsRepository.findById(appointmentId).get()
        // update and save
        appointmentToUpdate.date = newDate
        appointmentsRepository.save( appointmentToUpdate )
        return "Appointment updated"
    }

    // get all appointments
    fun getAll(): List<Appointment> = this.appointmentsRepository.findAll().toList()

    // get all appointments of specific patient
    fun getAllOfPatient(patientId: Long): List<Appointment> {
        val appointments = this.appointmentsRepository.findAll()

        var patientAppointments = listOf<Appointment>()
        // else if there is patientId iterate through to find specific patients only
        for( appointment in appointments ) {
            if ( appointment.patientId == patientId ) patientAppointments += appointment
        }
        // return those appointments
        return patientAppointments
    }

}