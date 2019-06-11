package pl.szymanskihubert.rsqtask.appointments

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/appointments")
class AppointmentController( val appointmentService: AppointmentService ) {

    // INDEX
    @GetMapping("")
    fun appointmentsGet( @RequestParam(required = false, defaultValue = "-1") patientId: Long) : List<Appointment> {
        when ( patientId == -1L) {
            // return all if default patientId is provided (-1)
            true -> return this.appointmentService.getAll()
            // return specific appointments of one patient
            false -> return this.appointmentService.getAllOfPatient( patientId )
        }
    }

    // CREATE
    @PostMapping("")
    fun appointmentsCreateNew( newAppointment: Appointment ) {
        this.appointmentService.addNew( newAppointment )
    }

    // UPDATE

    // DELETE

}
