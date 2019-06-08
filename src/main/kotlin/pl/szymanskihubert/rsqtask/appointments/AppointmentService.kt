package pl.szymanskihubert.rsqtask.appointments

import org.springframework.stereotype.Component
import pl.szymanskihubert.rsqtask.doctors.DoctorsRepository
import pl.szymanskihubert.rsqtask.patients.PatientsRepository
import java.util.*

@Component
class AppointmentService( val appointmentsRepository: AppointmentsRepository, val doctorsRepository: DoctorsRepository, val patientsRepository: PatientsRepository ) {

    // add a new appointment
    fun addNew() {
        throw NotImplementedError()
    }

    // remove the appointment
    fun delete() {
        throw NotImplementedError()
    }

    // change date of the appointment
    fun update( date: Date ) {
        throw NotImplementedError()
    }

    // get all appointments
    fun getAll(): List<Appointment> = this.appointmentsRepository.findAll().toList()

    // get all appointments of specific patient
    fun getAllOfPatient(patientId: Long): List<Appointment> {
        val appointments = this.appointmentsRepository.findAll()

        var patientAppointments: List<Appointment> = ArrayList<Appointment>()
        // else if there is patientId iterate through to find specific patients only
        for( appointment in appointments ) {
            if ( appointment.patientId == patientId ) patientAppointments += appointment
        }
        // return those appointments
        return patientAppointments
    }

}