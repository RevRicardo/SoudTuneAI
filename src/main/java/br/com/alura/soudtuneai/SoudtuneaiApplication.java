package br.com.alura.soudtuneai;

import br.com.alura.soudtuneai.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoudtuneaiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SoudtuneaiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.exibeMenu();
	}
}
