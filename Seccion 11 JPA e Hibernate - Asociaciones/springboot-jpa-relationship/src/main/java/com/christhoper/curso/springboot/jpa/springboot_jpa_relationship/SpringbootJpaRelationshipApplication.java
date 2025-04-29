package com.christhoper.curso.springboot.jpa.springboot_jpa_relationship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.christhoper.curso.springboot.jpa.springboot_jpa_relationship.entities.Address;
import com.christhoper.curso.springboot.jpa.springboot_jpa_relationship.entities.Client;
import com.christhoper.curso.springboot.jpa.springboot_jpa_relationship.entities.Invoice;
import com.christhoper.curso.springboot.jpa.springboot_jpa_relationship.repositories.ClientRepository;
import com.christhoper.curso.springboot.jpa.springboot_jpa_relationship.repositories.InvoiceRepository;


@SpringBootApplication
public class SpringbootJpaRelationshipApplication implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private InvoiceRepository invoiceRepository;

	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaRelationshipApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//manyToOne();
		//manyToOneFindByIdClient();
		//oneToMany();
		//oneToManyFindById();
		//removeAddress();
		//removeAddressFindById();
		oneToManyInvoiceBidireccional();
	}

	@Transactional
	public void oneToManyInvoiceBidireccional(){
		Client client = new Client("Fran", "Moras");

		Invoice invoice1 = new Invoice("compras de la casa", 5000L);
		Invoice invoice2 = new Invoice("compras de oficina", 8000L);

		List<Invoice> invoices = new ArrayList<>();
		invoices.add(invoice1);
		invoices.add(invoice2);
		client.setInvoices(invoices);

		invoice1.setClient(client);
		invoice2.setClient(client);

		clientRepository.save(client);
		
		System.out.println(client);
	}

	@Transactional
	public void oneToManyFindById(){
		Optional<Client> optionalClient = clientRepository.findById(2L);
		optionalClient.ifPresent(client -> {
			Address address1 = new Address("El verjel", "1234");
			Address address2 = new Address("Vasco de Gama", "9875");

			client.setAddresses(Arrays.asList(address1, address2));

			clientRepository.save(client);

			System.out.println(client);
		});
	}

	@Transactional
	public void removeAddressFindById(){
		Optional<Client> optionalClient = clientRepository.findById(2L);
		optionalClient.ifPresent(client -> {
			Address address1 = new Address("El verjel", "1234");
			Address address2 = new Address("Vasco de Gama", "9875");

			client.setAddresses(Arrays.asList(address1, address2));

			clientRepository.save(client);

			System.out.println("Dirección 2: " + address2);

			Optional<Client> optionalClient2 = clientRepository.findOne(2L);
			optionalClient2.ifPresent(clientDB -> {
				Address addressBD = new Address();
				addressBD = clientDB.getAddresses().stream().filter(a-> a.getStreet().equals(address2.getStreet()) && a.getNumber().equals(address2.getNumber())).findFirst().orElseThrow();
				clientDB.getAddresses().remove(addressBD);
				clientRepository.save(clientDB);
				System.out.println("Se eliminó:");
				System.out.println(clientDB);
			});
		});
	}

	@Transactional
	public void removeAddress(){
		Client client = new Client("Fran", "Moras");

		Address address1 = new Address("El verjel", "1234");
		Address address2 = new Address("Vasco de Gama", "9875");

		client.getAddresses().add(address1);
		client.getAddresses().add(address2);

		clientRepository.save(client);

		//System.out.println(client);
		System.out.println(address2);

		Optional<Client> optionalClient = clientRepository.findById(3L);
		optionalClient.ifPresent(clientDB -> {
			clientDB.getAddresses().remove(address1);
			clientRepository.save(clientDB);
			System.out.println(clientDB);
		});
	}

	@Transactional
	public void oneToMany(){
		Client client = new Client("Fran", "Moras");

		Address address1 = new Address("El verjel", "1234");
		Address address2 = new Address("Vasco de Gama", "9875");

		client.getAddresses().add(address1);
		client.getAddresses().add(address2);

		clientRepository.save(client);

		System.out.println(client);
	}
	
	@Transactional
	public void manyToOne(){
		
		Client client = new Client("John", "Doe");
		clientRepository.save(client);

		Invoice invoice = new Invoice("compras de oficina", 2000L);
		invoice.setClient(client);
		Invoice invoiceDB = invoiceRepository.save(invoice);
		System.out.println(invoiceDB);
	}

	@Transactional
	public void manyToOneFindByIdClient(){
		
		Optional<Client> optionalClient = clientRepository.findById(1L);

		if (optionalClient.isPresent()) {
			Client client = optionalClient.orElseThrow();
			System.out.println(client);
			
			Invoice invoice = new Invoice("compras de oficina", 2000L);
			invoice.setClient(client);
			Invoice invoiceDB = invoiceRepository.save(invoice);
			System.out.println(invoiceDB);
		} else {
			System.out.println("No existe el cliente");
		}

	}
}
