package pl.szymanskihubert.rsqtask

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RsqTaskApplication

fun main(args: Array<String>) {
	runApplication<RsqTaskApplication>(*args)
}
