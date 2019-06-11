package pl.szymanskihubert.rsqtask.appointments

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Appointment( var patientId: Long, var doctorId: Long, var date: LocalDateTime) {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    var id: Long = -1

}