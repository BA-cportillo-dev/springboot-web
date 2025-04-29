package com.christhoper.curso.springboot.jpa.springboot_jpa;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.christhoper.curso.springboot.jpa.springboot_jpa.dto.PersonDto;
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
		//create();
		update();
		//delete();
		//delete2();
		//personalizedQueries();
		//personalizedQueries2();
		//personalizedQueriesDistinct();
	}

	@Transactional(readOnly = true)
	public void personalizedQueriesDistinct(){
		System.out.println("===================== Consultas con nombres de personas =====================");
		List<String> names = repository.findAllNames();
		names.forEach(System.out::println);
		
		System.out.println("===================== Consultas con nombres unicos de personas =====================");
		names = repository.findAllNamesDistinct();
		names.forEach(System.out::println);
		
		System.out.println("===================== Consultas con lenguajes de programación unicos de personas =====================");
		List<String> programmingLanguage = repository.findAllprogrammingLanguageDistinct();
		programmingLanguage.forEach(System.out::println);
		
		System.out.println("===================== Consultas cuenta lenguajes de programación unicos de personas =====================");
		Long totalLanguages = repository.findAllprogrammingLanguageDistinctCount();
		System.out.println("Total de lenguajes de programación: " + totalLanguages);
	}

	@Transactional(readOnly = true)
	public void personalizedQueries2(){
		System.out.println("===================== consulta por objeto persona y lenguaje de programación =====================");
		List<Object[]> personsRegs = repository.findAllMixPerson();

		personsRegs.forEach(reg -> {
			System.out.println("programmingLanguage=" + reg[1] + ", Peron=" + reg[0]);
		});

		System.out.println("consulta que puebla y devuelve objeto entity de una instancia personalizada");
		List<Person> persons = repository.findAllObjectPersonPersonalized();
		persons.forEach(System.out::println);

		System.out.println("consulta que puebla y devuelve objeto dto de una clase personalizada dto");
		List<PersonDto> personDto = repository.findAllPersonDto();
		personDto.forEach(System.out::println);
	}

	@Transactional(readOnly = true)
	public void personalizedQueries(){

		Scanner scanner = new Scanner(System.in);
		System.out.println("===================== consulta solo el nombre por el id =====================");
		System.out.println("Ingrese el id a consultar:");
		Long id = scanner.nextLong();
		scanner.close();

		String name = repository.getNameById(id);
		System.out.println(name);

		Long idDb = repository.getIdById(id);
		System.out.println(idDb);

		String fullName = repository.getFullNameById(id);
		System.out.println(fullName);
	}

	@Transactional
	public void delete(){

		repository.findAll().forEach(System.out::println);

		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el id a eliminar:");
		Long id = scanner.nextLong();
		repository.deleteById(id);

		repository.findAll().forEach(System.out::println);

		scanner.close();
	}

	@Transactional
	public void delete2(){

		repository.findAll().forEach(System.out::println);

		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el id a eliminar:");
		Long id = scanner.nextLong();

		Optional<Person> optionalPerson = repository.findById(id);

		optionalPerson.ifPresentOrElse(
		repository::delete, 
		() -> System.out.println("Lo sentimos no existe la persona con ese id!"));

		repository.findAll().forEach(System.out::println);

		scanner.close();
	}

	@Transactional
	public void update(){

		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el id de la persona:");
		Long id = scanner.nextLong();

		Optional<Person> optionalPerson = repository.findById(id);

		//optionalPerson.ifPresent(person -> {
		if (optionalPerson.isPresent()) {
			Person personDB = optionalPerson.orElseThrow();

			System.out.println(personDB);
			System.out.println("Ingrese el lenguaje de programacion:");
			String programmingLanguaje = scanner.next();

			personDB.setProgrammingLanguage(programmingLanguaje);
			Person personUpdate = repository.save(personDB);

			System.out.println(personUpdate);
		} else {
			System.out.println("El usuario no esta presente! no existe!");
		}
		//});

		scanner.close();
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
