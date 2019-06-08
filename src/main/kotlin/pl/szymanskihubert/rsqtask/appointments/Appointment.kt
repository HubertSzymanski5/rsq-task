package pl.szymanskihubert.rsqtask.appointments

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Appointment( var patientId: Long, var doctorId: Long, var date: Date) {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    var id: Long = -1
    
}