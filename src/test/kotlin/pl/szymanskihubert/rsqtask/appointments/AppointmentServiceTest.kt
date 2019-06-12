package pl.szymanskihubert.rsqtask.appointments

import org.junit.Test
import java.time.LocalDateTime

class AppointmentServiceTest {

    // val to access list of appointments
    val appointmentRepoMock = AppointmentsRepoMock()
    val appointmentService = AppointmentService( appointmentRepoMock, DoctorsRepositoryMock(), PatientsRepositoryMock() )

    @Test
    fun addNewWithCorrectData() {
        assert( appointmentService.addNew( Appointment( 1, 2, "Poznań", LocalDateTime.of(2023, 12, 21, 12, 30))) == true )
    }

    @Test
    fun addNewWithWrongDoctorId() {
        assert( appointmentService.addNew( Appointment( 1, 5, "Poznań", LocalDateTime.of(2020, 12, 12, 11, 15))) == false)
    }

    @Test
    fun addNewWithWrongPatientId() {
        assert( appointmentService.addNew( Appointment( 4, 1, "Poznań", LocalDateTime.of(2023, 12, 21, 12, 30))) == false )
    }

    @Test
    fun deleteCorrectId() {
        assert( appointmentService.delete( 2 ) == true )
    }

    @Test
    fun deleteWrongId() {
        assert( appointmentService.delete( 6 ) == false )
    }

    @Test
    fun updateGoodId() {
        val date = LocalDateTime.of( 2014, 2, 23, 13, 20)
        assert( appointmentService.update(2, date) == true )
    }

    @Test
    fun updateWrongId() {
        val date = LocalDateTime.of( 2014, 2, 23, 13, 20)
        assert( appointmentService.update(5, date) == false )
    }

    @Test
    fun getAllWithData() {
        // little setup
        var appointments = mutableListOf(
                Appointment(1,1, "Poznań", LocalDateTime.of(1,1,1,1,1)),
                Appointment(2,2, "Poznań", LocalDateTime.of(2,2,2,2,2))
        )
        appointmentRepoMock.appointments = appointments

        // not sure if this is a good practice
        // or if it even works -> well it works apparently
        assert( appointmentService.getAll() == appointments )

    }


    @Test
    fun getAllOfPatient() {
        // little setup
        var appointments = mutableListOf(
                Appointment(1,1, "Poznań", LocalDateTime.of(1,1,1,1,1)),
                Appointment(1,2, "Poznań", LocalDateTime.of(2,2,2,2,2))
        )
        appointmentRepoMock.appointments = appointments

        // not sure if this is a good practice
        assert( appointmentService.getAllOfPatient( 1L ) == appointments )
    }

    @Test
    fun getAllOfPatientCount() {
        // little setup
        var appointments = mutableListOf(
                Appointment(1,1, "Poznań", LocalDateTime.of(1,1,1,1,1)),
                Appointment(1,2, "Poznań", LocalDateTime.of(2,2,2,2,2)),
                Appointment(2,3, "Poznań", LocalDateTime.of(3,3,3,3,3)),
                Appointment(3,4, "Poznań", LocalDateTime.of(4,4,4,4,4))
        )
        appointmentRepoMock.appointments = appointments

        // not sure if this is a good practice
        assert( appointmentService.getAllOfPatient( 1L ).size == 2 )
    }

    @Test
    fun getAllOfPatientEmpty() {
        // little setup
        var appointments = mutableListOf(
                Appointment(1,1, "Poznań", LocalDateTime.of(1,1,1,1,1)),
                Appointment(1,2, "Poznań", LocalDateTime.of(2,2,2,2,2)),
                Appointment(2,3, "Poznań", LocalDateTime.of(3,3,3,3,3)),
                Appointment(3,4, "Poznań", LocalDateTime.of(4,4,4,4,4))
        )
        appointmentRepoMock.appointments = appointments

        // not sure if this is a good practice
        assert( appointmentService.getAllOfPatient( 5L ).isEmpty() )
    }
}