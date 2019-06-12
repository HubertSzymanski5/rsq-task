package pl.szymanskihubert.rsqtask.appointments

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import pl.szymanskihubert.rsqtask.appointments.obtains.AppointmentOBT
import pl.szymanskihubert.rsqtask.appointments.obtains.DateTime
import java.lang.Exception
import java.time.LocalDateTime

@RestController
@RequestMapping("/appointments")
class AppointmentController( val appointmentService: AppointmentService ) {

    // INDEX
    @GetMapping("")
    fun appointmentsGet( @RequestParam(required = false, defaultValue = "-1") patientId: Long) : ResponseEntity<List<Appointment>> {

        // return all if patientId has defaultValue of -1
        if ( patientId == -1L )
            return ResponseEntity.ok( this.appointmentService.getAll() )

        else {
            // else get list of appointments of specific patient
            val listOfPatient = this.appointmentService.getAllOfPatient( patientId )

            // check if its empty
            if ( listOfPatient.isEmpty() )
                // return notFound if it is empty
                return ResponseEntity.notFound().build()

            else
                // else return his appointments
                return ResponseEntity.ok( listOfPatient )
        }



    }

    // CREATE
    @PostMapping("")
    fun appointmentsCreateNew( app: AppointmentOBT ) : ResponseEntity<Unit> {

        try {
            val newAppointment = Appointment( app.patientId, app.doctorId, app.place, LocalDateTime.of(app.year, app.month, app.day, app.hour, app.minute))
            // if created successfully
            if ( this.appointmentService.addNew( newAppointment ) )
                return ResponseEntity.ok().build()

            // if not
            else
                return ResponseEntity.badRequest().build()
        } catch (e : Exception) {
            return ResponseEntity.badRequest().build()
        }

    }

    // UPDATE
    @PutMapping("/{id}")
    fun appointmentsDateUpdate( @PathVariable id: Long, newDate: DateTime) : ResponseEntity<Unit> {

        // variable to assign new date required by Appointment Class
        var newDateTime : LocalDateTime

        // try to create LocalDateTime from obtained data
        try {
            newDateTime = LocalDateTime.of( newDate.year, newDate.month, newDate.day, newDate.hour, newDate.minute )
        }
        // else return badRequest
        catch (e: Exception) {
            return ResponseEntity.badRequest().build()
        }

        // if successfully added
        if ( appointmentService.update( id, newDateTime ) )
            return ResponseEntity.ok().build()

        // else return 404 not found
            return ResponseEntity.notFound().build()


    }


    // DELETE
    @DeleteMapping("/{id}")
    fun deleteAppointmentWithId( @PathVariable id: Long ) : ResponseEntity<Unit> {
        if ( appointmentService.delete(id) )
            return ResponseEntity.ok().build()
        else
            return ResponseEntity.notFound().build()
    }

}
