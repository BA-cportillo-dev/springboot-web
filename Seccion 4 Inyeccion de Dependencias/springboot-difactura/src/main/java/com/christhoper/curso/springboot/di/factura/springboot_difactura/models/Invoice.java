package com.christhoper.curso.springboot.di.factura.springboot_difactura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@RequestScope
@JsonIgnoreProperties({"targetSource", "advisors"})
public class Invoice {

    @Autowired
    private Client client;

    @Value("${invoice.description}")
    private String descripcion;

    @Autowired
    private List<Item> items;

    public Invoice() {
        System.out.println("Creando el componente de la factura 1.");
        System.out.println(client);
        System.out.println(descripcion);
    }
    
    @PostConstruct
    public void init(){
        System.out.println("Creando el componente de la factura 2.");

        client.setName(client.getName().concat(" Pepe"));
        descripcion = descripcion.concat(" del cleinte: ").concat(client.getName()).concat(" ").
                concat(client.getLastName());
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Destruyendo el componente o bean invoice!");
    }

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getTotal(){
        return items.stream()
            .map(item -> item.getImporte())
            .reduce(0, (sum, importe) -> sum + importe);
    }
}
