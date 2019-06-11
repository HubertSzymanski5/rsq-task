package pl.szymanskihubert.rsqtask.appointments

import java.time.LocalDateTime
import java.util.*

class AppointmentRepoMock : AppointmentsRepository {

    override fun <S : Appointment?> save(entity: S): S {
        return entity
    }

    override fun existsById(id: Long): Boolean {
        return id < 3L
    }

    override fun deleteById(id: Long) {
        // its void so do nothing
    }

    override fun findById(id: Long): Optional<Appointment> {
        if ( id > 3 ) return Optional.empty()
        else return Optional.of(Appointment(1,2, LocalDateTime.of(1,1,1,1,1)))
    }

    // not used interface methods

    override fun findAll(): MutableIterable<Appointment> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteAll(entities: MutableIterable<Appointment>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteAll() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : Appointment?> saveAll(entities: MutableIterable<S>): MutableIterable<S> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun count(): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findAllById(ids: MutableIterable<Long>): MutableIterable<Appointment> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(entity: Appointment) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}