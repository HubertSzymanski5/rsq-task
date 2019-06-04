package pl.szymanskihubert.rsqtask.doctors

import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/doctors")
class DoctorController (val doctorsRepository: DoctorsRepository) {

    // INDEX
    @GetMapping("")
    fun doctorsFindAll(): MutableIterable<Doctor> = this.doctorsRepository.findAll()

    // SHOW
    @GetMapping("/{id}")
    fun doctorsFindById(@PathVariable id: Long): Optional<Doctor> = this.doctorsRepository.findById(id)

    // CREATE
    @PostMapping("")
    fun doctorsAddNew( newDoctor: Doctor) = this.doctorsRepository.save(newDoctor)

    // UPDATE
    @PutMapping("/{id}")
    fun doctorsUpdateById(@PathVariable id: Long, updatedDoctor: Doctor) {
        // find specific doctor to update
        var doctor = this.doctorsRepository.findById(id).get()
        // give him updated info
        doctor = updatedDoctor
        // save in repo
        this.doctorsRepository.save(doctor)
    }

    // DELETE
    @DeleteMapping("/{id}")
    fun doctorDeleteById(@PathVariable id: Long) = this.doctorsRepository.deleteById(id)
}