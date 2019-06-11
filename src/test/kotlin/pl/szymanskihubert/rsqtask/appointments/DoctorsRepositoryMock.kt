package pl.szymanskihubert.rsqtask.appointments

import pl.szymanskihubert.rsqtask.doctors.Doctor
import pl.szymanskihubert.rsqtask.doctors.DoctorsRepository
import java.util.*

class DoctorsRepositoryMock : DoctorsRepository {

    override fun existsById(id: Long): Boolean {
        return id < 3L
    }

    // rest of interface - not needed

    override fun <S : Doctor?> save(entity: S): S {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findAll(): MutableIterable<Doctor> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteById(id: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteAll(entities: MutableIterable<Doctor>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteAll() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : Doctor?> saveAll(entities: MutableIterable<S>): MutableIterable<S> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun count(): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findAllById(ids: MutableIterable<Long>): MutableIterable<Doctor> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findById(id: Long): Optional<Doctor> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(entity: Doctor) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}