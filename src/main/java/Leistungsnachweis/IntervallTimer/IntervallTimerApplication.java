package Leistungsnachweis.IntervallTimer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class IntervallTimerApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntervallTimerApplication.class, args);
	}
}
