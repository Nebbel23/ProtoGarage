package no.vi.protogarage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static no.vi.protogarage.config.Constants.GARAGE_NAME;

@SpringBootApplication
public class ProtoGarageApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(ProtoGarageApplication.class, args);
		System.out.println("\n\n" + GARAGE_NAME + " is running!\n");
	}
}