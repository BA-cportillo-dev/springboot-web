package hn.bancatlan.cierrecajaempresarial;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@EnableAsync
@EnableTransactionManagement
@SpringBootApplication
public class CierreCajaEmpresarialApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
		return builder.sources(CierreCajaEmpresarialApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(CierreCajaEmpresarialApplication.class, args);
		//System.out.println("Estoy corriendo el cierre de caja.");
	}

}