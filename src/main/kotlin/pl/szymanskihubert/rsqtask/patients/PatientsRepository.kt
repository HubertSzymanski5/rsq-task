package pl.szymanskihubert.rsqtask.patients

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PatientsRepository : CrudRepository<Patient, Long> {
}