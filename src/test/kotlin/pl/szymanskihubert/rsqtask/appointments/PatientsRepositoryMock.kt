package pl.szymanskihubert.rsqtask.appointments

import pl.szymanskihubert.rsqtask.patients.Patient
import pl.szymanskihubert.rsqtask.patients.PatientsRepository
import java.util.*

class PatientsRepositoryMock : PatientsRepository {

    override fun existsById(id: Long): Boolean {
        return id < 3L
    }

    // rest of interface - not needed

    override fun <S : Patient?> save(entity: S): S {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findAll(): MutableIterable<Patient> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteById(id: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteAll(entities: MutableIterable<Patient>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteAll() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : Patient?> saveAll(entities: MutableIterable<S>): MutableIterable<S> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun count(): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findAllById(ids: MutableIterable<Long>): MutableIterable<Patient> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findById(id: Long): Optional<Patient> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(entity: Patient) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}