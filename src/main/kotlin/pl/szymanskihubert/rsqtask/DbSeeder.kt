package pl.szymanskihubert.rsqtask

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import pl.szymanskihubert.rsqtask.doctors.Doctor
import pl.szymanskihubert.rsqtask.doctors.DoctorsRepository
import pl.szymanskihubert.rsqtask.patients.Patient
import pl.szymanskihubert.rsqtask.patients.PatientsRepository

@Component
class DbSeeder(val doctorsRepository: DoctorsRepository, val patientsRepository: PatientsRepository) : CommandLineRunner {
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

        // add them to db
        this.doctorsRepository.saveAll(doctors)
        this.patientsRepository.saveAll(patients)
    }
}