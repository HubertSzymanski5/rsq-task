package pl.szymanskihubert.rsqtask.appointments

import org.springframework.stereotype.Component
import pl.szymanskihubert.rsqtask.doctors.DoctorsRepository
import pl.szymanskihubert.rsqtask.patients.PatientsRepository
import java.time.LocalDateTime

@Component
class AppointmentService( val appointmentsRepository: AppointmentsRepository,
                          val doctorsRepository: DoctorsRepository,
                          val patientsRepository: PatientsRepository ) {

    // add a new appointment
    fun addNew( newAppointment: Appointment) : Boolean {

        // check if patient exist
        if ( !patientsRepository.existsById( newAppointment.patientId) ) return false

        // check if doctor exist
        if ( !doctorsRepository.existsById( newAppointment.doctorId) ) return false

        // if they exists add the appointment to the db
        appointmentsRepository.save( newAppointment )
        return true
    }

    // remove the appointment
    fun delete( id: Long ) : Boolean {

        // if appointment does not exist return false
        if ( !appointmentsRepository.existsById(id) ) return false

        // else delete it and return true
        appointmentsRepository.deleteById( id )
        return true
    }

    // change date of the appointment
    fun update(appointmentId: Long, newDate: LocalDateTime) : Boolean {
        // check if appointment exists
        if ( !appointmentsRepository.existsById( appointmentId ))
            return false

        // find appointment by id
        var appointmentToUpdate = appointmentsRepository.findById(appointmentId).get()
        // update and save
        appointmentToUpdate.date = newDate
        appointmentsRepository.save( appointmentToUpdate )
        return true
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