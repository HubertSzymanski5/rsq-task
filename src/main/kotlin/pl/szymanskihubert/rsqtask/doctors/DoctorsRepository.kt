package pl.szymanskihubert.rsqtask.doctors

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface DoctorsRepository :CrudRepository<Doctor, Long> {
}