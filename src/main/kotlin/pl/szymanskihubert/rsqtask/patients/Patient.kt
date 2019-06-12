package pl.szymanskihubert.rsqtask.patients

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Patient (val firstName: String,
               val lastName: String,
               val address: String) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = -1
}