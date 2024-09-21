package com.christhoper.curso.springboot.jpa.springboot_jpa;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.christhoper.curso.springboot.jpa.springboot_jpa.entities.Person;
import com.christhoper.curso.springboot.jpa.springboot_jpa.repositories.PersonRepository;

@SpringBootApplication
public class SpringbootJpaApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//findOne();
		create();
	}

	@Transactional
	public void create(){

		Scanner scanner = new Scanner(System.in);

		System.out.println("Ingrese el nombre:");
		String name = scanner.next();
		System.out.println("Ingrese el apellido:");
		String lastname = scanner.next();
		System.out.println("Ingrese el lenguaje de programacion:");
		String programmingLanguaje = scanner.next();
		scanner.close();

		Person person = new Person(null, name, lastname, programmingLanguaje);

		Person personNew = repository.save(person);
		System.out.println(personNew);

		repository.findById(personNew.getId()).ifPresent(System.out::println);
	}

	@Transactional(readOnly = true)
	public void findOne(){
		// Person person = null;
		// Optional<Person> optionalPerson = repository.findById(8L);
		// if (optionalPerson.isPresent()) {
		// 	person = optionalPerson.get();
		// 	System.out.println(person);
		// }else{
		// 	System.out.println("No esta.");
		// }
		//repository.findById(1L).ifPresent(System.out::println);
		//repository.findOne(1L).ifPresent(System.out::println);
		//repository.findOneName("Pepe").ifPresent(System.out::println);
		//repository.findOneLikeName("Pe").ifPresent(System.out::println);
		repository.findByNameContaining("Pe").ifPresent(System.out::println);
	}

	public void list() {
		//List<Person> persons = (List<Person>)repository.findAll();
		//List<Person> persons = (List<Person>)repository.findByProgrammingLanguage("Java");
		//List<Person> persons = (List<Person>)repository.buscarByProgrammingLanguage("Java", "Andres");
		List<Person> persons = (List<Person>)repository.findByProgrammingLanguageAndName("Java", "Andres");

		persons.stream().forEach(person -> {
			System.out.println(person);
		});
		
		List<Object[]> personsValues = repository.obtenerPersonData();
		personsValues.stream().forEach(person -> {
			System.out.println(person[0] + " es experto en " + person[1]);
		});
	}
}
