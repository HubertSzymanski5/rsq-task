package pl.szymanskihubert.rsqtask

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import pl.szymanskihubert.rsqtask.appointments.Appointment
import pl.szymanskihubert.rsqtask.appointments.AppointmentsRepository
import pl.szymanskihubert.rsqtask.doctors.Doctor
import pl.szymanskihubert.rsqtask.doctors.DoctorsRepository
import pl.szymanskihubert.rsqtask.patients.Patient
import pl.szymanskihubert.rsqtask.patients.PatientsRepository
import java.util.*

@Component
class DbSeeder(val doctorsRepository: DoctorsRepository, val patientsRepository: PatientsRepository, val appointmentsRepository: AppointmentsRepository) : CommandLineRunner {
    override fun run(vararg args: String?) {
        // clear dbs
        this.doctorsRepository.deleteAll()
        this.patientsRepository.deleteAll()

        // create few doctors
        val doctors = listOf(
                Doctor("Andrzej", "Andrzejewski", "dentist"),
                Doctor("Bartek", "Bartoszewski", "heart surgeon")
        )
        // create few patients
        val patients = listOf(
                Patient("Marcin", "Makuszewski", "Warszawa Długa 3201a"),
                Patient("Cezary", "Czarnecki", "Poznań Średnia 203")
        )

        val appointments = listOf(
                Appointment( 3, 2, Date(19, 4, 20, 12, 30)),
                Appointment( 4, 1, Date(19, 4, 21, 13, 0))
        )

        // add them to db
        this.doctorsRepository.saveAll(doctors)
        this.patientsRepository.saveAll(patients)
        this.appointmentsRepository.saveAll(appointments)
    }
}