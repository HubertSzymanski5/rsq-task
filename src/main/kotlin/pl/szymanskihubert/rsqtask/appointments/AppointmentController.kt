package pl.szymanskihubert.rsqtask.appointments

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/appointments")
class AppointmentController( val appointmentService: AppointmentService ) {

    // INDEX
    @GetMapping("")
    fun appointmentsGetAll( @RequestParam(required = false, defaultValue = "-1") patientId: Long) : List<Appointment> {
        when ( patientId == -1L) {
            true -> return this.appointmentService.getAll()
            false -> return this.appointmentService.getAllOfPatient( patientId )
        }
    }

    // CREATE

    // UPDATE

    // DELETE

}
