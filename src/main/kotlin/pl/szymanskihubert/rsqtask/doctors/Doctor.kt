package pl.szymanskihubert.rsqtask.doctors

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Doctor (val firstName: String, val lastName: String, val specialization: String){

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = -1
}