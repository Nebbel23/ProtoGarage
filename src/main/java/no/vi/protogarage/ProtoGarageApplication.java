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
		
		
		//TODO Git public maken
		//TODO Git opschonen
		
		//TODO alles pdf maken
		
		//TODO MariaDB props
		
		/*  voor MySQL
		
spring.datasource.url= jdbc:mysql://localhost:3306/testdb?useSSL=false
spring.datasource.username= root
spring.datasource.password= 123456
spring.jpa.properties.hibernate.dialect= org.hibernate.dialect.MySQL5InnoDBDialect
# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto= update
		 */
	}
}