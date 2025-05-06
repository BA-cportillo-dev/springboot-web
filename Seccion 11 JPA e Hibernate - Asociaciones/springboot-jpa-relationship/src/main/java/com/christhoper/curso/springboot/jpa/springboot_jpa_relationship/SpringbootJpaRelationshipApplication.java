package com.christhoper.curso.springboot.jpa.springboot_jpa_relationship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.christhoper.curso.springboot.jpa.springboot_jpa_relationship.entities.Address;
import com.christhoper.curso.springboot.jpa.springboot_jpa_relationship.entities.Client;
import com.christhoper.curso.springboot.jpa.springboot_jpa_relationship.entities.ClientDetails;
import com.christhoper.curso.springboot.jpa.springboot_jpa_relationship.entities.Course;
import com.christhoper.curso.springboot.jpa.springboot_jpa_relationship.entities.Invoice;
import com.christhoper.curso.springboot.jpa.springboot_jpa_relationship.entities.Student;
import com.christhoper.curso.springboot.jpa.springboot_jpa_relationship.repositories.ClientDetailsRepository;
import com.christhoper.curso.springboot.jpa.springboot_jpa_relationship.repositories.ClientRepository;
import com.christhoper.curso.springboot.jpa.springboot_jpa_relationship.repositories.CourseRepository;
import com.christhoper.curso.springboot.jpa.springboot_jpa_relationship.repositories.InvoiceRepository;
import com.christhoper.curso.springboot.jpa.springboot_jpa_relationship.repositories.StudentRepository;

@SpringBootApplication
public class SpringbootJpaRelationshipApplication implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private InvoiceRepository invoiceRepository;

	@Autowired
	private ClientDetailsRepository clientDetailsRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaRelationshipApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// manyToOne();
		// manyToOneFindByIdClient();
		// oneToMany();
		// oneToManyFindById();
		// removeAddress();
		// removeAddressFindById();
		// oneToManyInvoiceBidireccional();
		// oneToManyInvoiceBidireccionalFindById();
		// removeInvoiceBidireccionalFindById();
		// removeInvoiceBidireccional();
		// oneToOne();
		// oneToOneFindById();
		// oneToOneBidireccional();
		// oneToOneBidireccionalFindById();
		// manyToMany();
		// manyToManyFind();
		// manyToManyRemoveFind();
		// manyToManyRemove();
		// manyToManyBidireccional();
		// manyToManyBidireccionalRemove();
		// manyToManyBidireccionalFind();
		manyToManyRemoveBidireccionalFind();
	}

	@Transactional
	public void manyToManyRemoveBidireccionalFind() {
		Student student1 = studentRepository.findOneWithCourses(1L).orElseThrow();
		Student student2 = studentRepository.findOneWithCourses(2L).orElseThrow();

		Course course1 = courseRepository.findOneWithStudents(1L).orElseThrow();
		Course course2 = courseRepository.findOneWithStudents(2L).orElseThrow();

		// student1.setCourses(Set.of(course1, course2));
		// student2.setCourses(Set.of(course2));

		student1.addCourse(course1);
		student1.addCourse(course2);
		student2.addCourse(course2);

		studentRepository.saveAll(Set.of(student1, student2));

		System.out.println(student1);
		System.out.println(student2);

		Optional<Student> studentOptionalDb = studentRepository.findOneWithCourses(1L);
		if (studentOptionalDb.isPresent()) {

			Student studentDb = studentOptionalDb.get();
			Optional<Course> courseOptional = courseRepository.findOneWithStudents(1L);
			
			if (courseOptional.isPresent()) {
				Course courseDb = courseOptional.get();
				studentDb.removeCourse(courseDb);
				
				studentRepository.save(studentDb);

				System.out.println("Se eliminó:");
				System.out.println(studentDb);
			} else {
				System.out.println("No existe el curso");
			}
		}
	}

	@Transactional
	public void manyToManyBidireccionalFind() {
		Student student1 = studentRepository.findOneWithCourses(1L).orElseThrow();
		Student student2 = studentRepository.findOneWithCourses(2L).orElseThrow();

		Course course1 = courseRepository.findOneWithStudents(1L).orElseThrow();
		Course course2 = courseRepository.findOneWithStudents(2L).orElseThrow();

		// student1.setCourses(Set.of(course1, course2));
		// student2.setCourses(Set.of(course2));

		student1.addCourse(course1);
		student1.addCourse(course2);
		student2.addCourse(course2);

		studentRepository.saveAll(Set.of(student1, student2));

		System.out.println(student1);
		System.out.println(student2);
	}

	@Transactional
	public void manyToManyBidireccionalRemove() {
		Student student1 = new Student("Jano", "Pura");
		Student student2 = new Student("Erba", "Doe");

		Course course1 = new Course("Curso de java master", "Christhoper");
		Course course2 = new Course("Curso Spring Boot", "Pedro");

		// student1.setCourses(Set.of(course1, course2));
		// student2.setCourses(Set.of(course2));
		student1.addCourse(course1);
		student1.addCourse(course2);
		student2.addCourse(course2);

		studentRepository.saveAll(Set.of(student1, student2));

		System.out.println(student1);
		System.out.println(student2);

		Optional<Student> studentOptionalDb = studentRepository.findOneWithCourses(3L);
		if (studentOptionalDb.isPresent()) {

			Student studentDb = studentOptionalDb.get();
			Optional<Course> courseOptional = courseRepository.findOneWithStudents(3L);
			
			if (courseOptional.isPresent()) {
				Course courseDb = courseOptional.get();
				studentDb.removeCourse(courseDb);
				
				studentRepository.save(studentDb);

				System.out.println("Se eliminó:");
				System.out.println(studentDb);
			} else {
				System.out.println("No existe el curso");
			}
		}
	}
	
	@Transactional
	public void manyToManyBidireccional() {
		Student student1 = new Student("Jano", "Pura");
		Student student2 = new Student("Erba", "Doe");

		Course course1 = new Course("Curso de java master", "Christhoper");
		Course course2 = new Course("Curso Spring Boot", "Pedro");

		// student1.setCourses(Set.of(course1, course2));
		// student2.setCourses(Set.of(course2));
		student1.addCourse(course1);
		student1.addCourse(course2);
		student2.addCourse(course2);

		studentRepository.saveAll(Set.of(student1, student2));

		System.out.println(student1);
		System.out.println(student2);
	}

	@Transactional
	public void manyToManyRemove() {
		Student student1 = new Student("Jano", "Pura");
		Student student2 = new Student("Erba", "Doe");

		Course course1 = new Course("Curso de java master", "Christhoper");
		Course course2 = new Course("Curso Spring Boot", "Pedro");

		student1.setCourses(Set.of(course1, course2));
		student2.setCourses(Set.of(course2));

		studentRepository.saveAll(Set.of(student1, student2));

		System.out.println(student1);
		System.out.println(student2);

		Optional<Student> studentOptionalDb = studentRepository.findOneWithCourses(3L);
		if (studentOptionalDb.isPresent()) {

			Student studentDb = studentOptionalDb.get();
			Optional<Course> courseOptional = courseRepository.findById(3L);
			
			if (courseOptional.isPresent()) {
				Course courseDb = courseOptional.get();
				studentDb.getCourses().remove(courseDb);
				
				studentRepository.save(studentDb);

				System.out.println("Se eliminó:");
				System.out.println(studentDb);
			} else {
				System.out.println("No existe el curso");
			}
		}
	}

	@Transactional
	public void manyToManyRemoveFind() {
		Student student1 = studentRepository.findById(1L).orElseThrow();
		Student student2 = studentRepository.findById(2L).orElseThrow();

		Course course1 = courseRepository.findById(1L).orElseThrow();
		Course course2 = courseRepository.findById(2L).orElseThrow();

		student1.setCourses(Set.of(course1, course2));
		student2.setCourses(Set.of(course2));

		studentRepository.saveAll(Set.of(student1, student2));

		System.out.println(student1);
		System.out.println(student2);

		Optional<Student> studentOptionalDb = studentRepository.findOneWithCourses(1L);
		if (studentOptionalDb.isPresent()) {

			Student studentDb = studentOptionalDb.get();
			Optional<Course> courseOptional = courseRepository.findById(2L);
			
			if (courseOptional.isPresent()) {
				Course courseDb = courseOptional.get();
				studentDb.getCourses().remove(courseDb);
				
				studentRepository.save(studentDb);

				System.out.println("Se eliminó:");
				System.out.println(studentDb);
			} else {
				System.out.println("No existe el curso");
			}
		}
	}

	@Transactional
	public void manyToManyFind() {
		Student student1 = studentRepository.findById(1L).orElseThrow();
		Student student2 = studentRepository.findById(2L).orElseThrow();

		Course course1 = courseRepository.findById(1L).orElseThrow();
		Course course2 = courseRepository.findById(2L).orElseThrow();

		student1.setCourses(Set.of(course1, course2));
		student2.setCourses(Set.of(course2));

		studentRepository.saveAll(Set.of(student1, student2));

		System.out.println(student1);
		System.out.println(student2);
	}

	@Transactional
	public void manyToMany() {
		Student student1 = new Student("Jano", "Pura");
		Student student2 = new Student("Erba", "Doe");

		Course course1 = new Course("Curso de java master", "Christhoper");
		Course course2 = new Course("Curso Spring Boot", "Pedro");

		student1.setCourses(Set.of(course1, course2));
		student2.setCourses(Set.of(course2));

		studentRepository.saveAll(Set.of(student1, student2));

		System.out.println(student1);
		System.out.println(student2);
	}

	@Transactional
	public void oneToOneBidireccionalFindById() {
		Optional<Client> clientOptional = clientRepository.findOne(2L);

		clientOptional.ifPresent(client -> {
			ClientDetails clientDetails = new ClientDetails(true, 5000);

			client.setClientDetails(clientDetails);

			clientRepository.save(client);

			System.out.println(client);
		});

	}

	@Transactional
	public void oneToOneBidireccional() {
		Client client = new Client("Erba", "Pura");

		ClientDetails clientDetails = new ClientDetails(true, 5000);

		client.setClientDetails(clientDetails);

		clientRepository.save(client);

		System.out.println(client);
	}

	@Transactional
	public void oneToOneFindById() {
		ClientDetails clientDetails = new ClientDetails(true, 5000);
		clientDetailsRepository.save(clientDetails);

		Optional<Client> clientOptional = clientRepository.findOne(2L); // new Client("Erba", "Pura");
		clientOptional.ifPresent(client -> {
			client.setClientDetails(clientDetails);
			clientRepository.save(client);
			System.out.println(client);
		});
	}

	@Transactional
	public void oneToOne() {
		ClientDetails clientDetails = new ClientDetails(true, 5000);
		clientDetailsRepository.save(clientDetails);

		Client client = new Client("Erba", "Pura");
		client.setClientDetails(clientDetails);
		clientRepository.save(client);

		System.out.println(client);
	}

	@Transactional
	public void removeInvoiceBidireccional() {
		Client client = new Client("Fran", "Moras");

		Invoice invoice1 = new Invoice("compras de la casa remove", 5000L);
		Invoice invoice2 = new Invoice("compras de oficina remove", 8000L);

		client.addInvoice(invoice1).addInvoice(invoice2);

		clientRepository.save(client);

		System.out.println(client);

		Optional<Client> optionalClientBd = clientRepository.findOne(3L);

		optionalClientBd.ifPresent(clientDb -> {
			Invoice invoice3 = new Invoice("compras de la casa remove", 5000L);
			invoice3.setId(1L);

			Optional<Invoice> invoiceOptional = Optional.of(invoice3); // invoiceRepository.findById(2L);
			invoiceOptional.ifPresent(invoice -> {
				clientDb.removeInvoice(invoice);
				clientRepository.save(clientDb);
				System.out.println("Se eliminó:");
				System.out.println(clientDb);
			});
		});
	}

	@Transactional
	public void removeInvoiceBidireccionalFindById() {
		Optional<Client> optionalClient = clientRepository.findOne(1L);

		optionalClient.ifPresent(client -> {
			Invoice invoice1 = new Invoice("compras de la casa remove", 5000L);
			Invoice invoice2 = new Invoice("compras de oficina remove", 8000L);

			client.addInvoice(invoice1).addInvoice(invoice2);

			clientRepository.save(client);

			System.out.println(client);
		});

		Optional<Client> optionalClientBd = clientRepository.findOne(1L);

		optionalClientBd.ifPresent(client -> {
			Invoice invoice3 = new Invoice("compras de la casa remove", 5000L);
			invoice3.setId(1L);

			Optional<Invoice> invoiceOptional = Optional.of(invoice3); // invoiceRepository.findById(2L);
			invoiceOptional.ifPresent(invoice -> {
				client.removeInvoice(invoice);
				clientRepository.save(client);
				System.out.println("Se eliminó:");
				System.out.println(client);
			});
		});
	}

	@Transactional
	public void oneToManyInvoiceBidireccionalFindById() {
		Optional<Client> optionalClient = clientRepository.findOne(1L);

		optionalClient.ifPresent(client -> {
			Invoice invoice1 = new Invoice("compras de la casa", 5000L);
			Invoice invoice2 = new Invoice("compras de oficina", 8000L);

			client.addInvoice(invoice1).addInvoice(invoice2);

			clientRepository.save(client);

			System.out.println(client);
		});
	}

	@Transactional
	public void oneToManyInvoiceBidireccional() {
		Client client = new Client("Fran", "Moras");

		Invoice invoice1 = new Invoice("compras de la casa", 5000L);
		Invoice invoice2 = new Invoice("compras de oficina", 8000L);

		Set<Invoice> invoices = new HashSet<>();
		invoices.add(invoice1);
		invoices.add(invoice2);
		client.setInvoices(invoices);

		invoice1.setClient(client);
		invoice2.setClient(client);

		clientRepository.save(client);

		System.out.println(client);
	}

	@Transactional
	public void oneToManyFindById() {
		Optional<Client> optionalClient = clientRepository.findById(2L);
		optionalClient.ifPresent(client -> {
			Address address1 = new Address("El verjel", "1234");
			Address address2 = new Address("Vasco de Gama", "9875");

			Set<Address> addresses = new HashSet<>();
			addresses.add(address1);
			addresses.add(address2);
			client.setAddresses(addresses);

			clientRepository.save(client);

			System.out.println(client);
		});
	}

	@Transactional
	public void removeAddressFindById() {
		Optional<Client> optionalClient = clientRepository.findById(2L);
		optionalClient.ifPresent(client -> {
			Address address1 = new Address("El verjel", "1234");
			Address address2 = new Address("Vasco de Gama", "9875");

			Set<Address> addresses = new HashSet<>();
			addresses.add(address1);
			addresses.add(address2);
			client.setAddresses(addresses);

			clientRepository.save(client);

			System.out.println("Dirección 2: " + address2);

			Optional<Client> optionalClient2 = clientRepository.findOneWithAddresses(2L);
			optionalClient2.ifPresent(clientDB -> {
				Address addressBD = new Address();
				addressBD = clientDB.getAddresses().stream().filter(
						a -> a.getStreet().equals(address2.getStreet()) && a.getNumber().equals(address2.getNumber()))
						.findFirst().orElseThrow();
				clientDB.getAddresses().remove(addressBD);
				clientRepository.save(clientDB);
				System.out.println("Se eliminó:");
				System.out.println(clientDB);
			});
		});
	}

	@Transactional
	public void removeAddress() {
		Client client = new Client("Fran", "Moras");

		Address address1 = new Address("El verjel", "1234");
		Address address2 = new Address("Vasco de Gama", "9875");

		client.getAddresses().add(address1);
		client.getAddresses().add(address2);

		clientRepository.save(client);

		System.out.println(address2);

		Optional<Client> optionalClient = clientRepository.findById(3L);
		optionalClient.ifPresent(clientDB -> {
			clientDB.getAddresses().remove(address1);
			clientRepository.save(clientDB);
			System.out.println(clientDB);
		});
	}

	@Transactional
	public void oneToMany() {
		Client client = new Client("Fran", "Moras");

		Address address1 = new Address("El verjel", "1234");
		Address address2 = new Address("Vasco de Gama", "9875");

		client.getAddresses().add(address1);
		client.getAddresses().add(address2);

		clientRepository.save(client);

		System.out.println(client);
	}

	@Transactional
	public void manyToOne() {

		Client client = new Client("John", "Doe");
		clientRepository.save(client);

		Invoice invoice = new Invoice("compras de oficina", 2000L);
		invoice.setClient(client);
		Invoice invoiceDB = invoiceRepository.save(invoice);
		System.out.println(invoiceDB);
	}

	@Transactional
	public void manyToOneFindByIdClient() {

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
