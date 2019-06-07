package pl.szymanskihubert.rsqtask.patients

import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping("/patients")
class PatientController ( val patientsRepository: PatientsRepository ) {

    // INDEX
    @GetMapping("")
    fun patientsFindAll(): MutableIterable<Patient> = this.patientsRepository.findAll()

    // SHOW
    @GetMapping("/{id}")
    fun patientsFindById(@PathVariable id: Long): Optional<Patient> = this.patientsRepository.findById(id)

    // CREATE
    @PostMapping("")
    fun patientsAddNew( newDoctor: Patient) = this.patientsRepository.save(newDoctor)

    // UPDATE
    @PutMapping("/{id}")
    fun patientsUpdateById(@PathVariable id: Long, updatedDoctor: Patient) {
        // find specific patient to update
        var patient = this.patientsRepository.findById(id).get()
        // give him updated info
        patient = updatedDoctor
        // save in repo
        this.patientsRepository.save(patient)
    }

    // DELETE
    @DeleteMapping("/{id}")
    fun patientsDeleteById(@PathVariable id: Long) = this.patientsRepository.deleteById(id)

}