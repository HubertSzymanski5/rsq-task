package pl.szymanskihubert.rsqtask.appointments

import org.junit.Test
import java.time.LocalDateTime

class AppointmentServiceTest {

    val appointmentService = AppointmentService(AppointmentRepoMock(), DoctorsRepositoryMock(), PatientsRepositoryMock() )

    @Test
    fun addNewWithCorrectData() {
        assert( appointmentService.addNew( Appointment( 1, 2, LocalDateTime.of(2023, 12, 21, 12, 30))) == "Appointment added" )
    }

    @Test
    fun addNewWithWrongDoctorId() {
        assert( appointmentService.addNew( Appointment( 1, 5, LocalDateTime.of(2020, 12, 12, 11, 15))) == "Doctor not found" )
    }

    @Test
    fun addNewWithWrongPatientId() {
        assert( appointmentService.addNew( Appointment( 4, 1, LocalDateTime.of(2023, 12, 21, 12, 30))) == "Patient not found" )
    }

    @Test
    fun deleteCorrectId() {
        assert( appointmentService.delete( 2 ) == "Appointment Deleted")
    }

    @Test
    fun deleteWrongId() {
        assert( appointmentService.delete( 6 ) == "Not Found")
    }

    @Test
    fun updateGoodId() {
        val date = LocalDateTime.of( 2014, 2, 23, 13, 20)
        assert( appointmentService.update(2, date) == "Appointment updated" )
    }

    @Test
    fun updateWrongId() {
        val date = LocalDateTime.of( 2014, 2, 23, 13, 20)
        assert( appointmentService.update(5, date) == "Appointment not found" )
    }

    @Test
    fun getAll() {

    }

    @Test
    fun getAllOfPatient() {
    }

    @Test
    fun getAppointmentsRepository() {
    }

    @Test
    fun getDoctorsRepository() {
    }

    @Test
    fun getPatientsRepository() {
    }
}