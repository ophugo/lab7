package mx.tec.lab.rest;

import mx.tec.lab.dto.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingRestController {
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	private static final String goodbyeTemplate = "Farewell, %s!";
	private final AtomicLong counter_goodbye = new AtomicLong();
	
	
	@RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
	
	@RequestMapping("/goodbye")
    public Greeting goodbye(@RequestParam(value = "name", defaultValue = "brother") String name) {
        return new Greeting(counter_goodbye.incrementAndGet(), String.format(goodbyeTemplate, name));
    }

}
