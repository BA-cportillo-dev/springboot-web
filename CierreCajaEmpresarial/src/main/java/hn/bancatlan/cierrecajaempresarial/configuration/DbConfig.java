package hn.bancatlan.cierrecajaempresarial.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
//Para compilación en Linux
@PropertySource(value = "file:/root/ConfigDbCierres/application.properties", ignoreResourceNotFound = true)
//Para compilación en Windows:
@PropertySource(value = "file:/C:\\ConfigDbCierres\\application.properties", ignoreResourceNotFound = true)
@Configuration
public class DbConfig {

    @Value("${url.endpoint.oraclecierre}")
    private String urlOracle;
    
}
