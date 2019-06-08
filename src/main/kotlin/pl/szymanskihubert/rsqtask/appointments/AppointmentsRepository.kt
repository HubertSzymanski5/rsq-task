package pl.szymanskihubert.rsqtask.appointments

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AppointmentsRepository : CrudRepository<Appointment, Long> {
}