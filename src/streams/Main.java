package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<Person> persons = getList();

		// imperative approach
		List<Person> male = new ArrayList<Person>();
		for (Person person : persons) {
			if (person.getGender().equals(Gender.MALE)) {
				male.add(person);
			}
		}

		// male.forEach(System.out::println);

		// declarative approach

		// filter
		List<Person> males = persons.stream().filter(person -> person.getGender().equals(Gender.MALE))
				.collect(Collectors.toList());
		// males.forEach(System.out::println);

		// sorted
		List<Person> nameSorted = persons.stream().sorted(Comparator.comparing(Person::getAge))
				.collect(Collectors.toList());
		// nameSorted.forEach(System.out::println);

		boolean allMatch = persons.stream().allMatch(p -> p.getAge() > 15);
		// System.out.println(allMatch);

		boolean anyMatch = persons.stream().anyMatch(p -> p.getAge() > 122);
		// System.out.println(anyMatch);

		boolean noneMatch = persons.stream().noneMatch(pe -> pe.getName().equals("rana"));
		//System.out.println(noneMatch);
		
		//max
		persons.stream().max(Comparator.comparing(Person::getAge))
		                .ifPresent(System.out::println);
		
		//min
				persons.stream().min(Comparator.comparing(Person::getAge))
				                .ifPresent(System.out::println);
		
		// group
		Map<Gender, List<Person>>groupbyGender=persons.stream()
				.collect(Collectors.groupingBy(Person::getGender));
		groupbyGender.forEach((gender,people)->{
			System.out.println(gender);
			
			people.forEach(System.out::println);
		});

	}

	private static List<Person> getList() {
		Person p = new Person("Nasim", Gender.MALE, 25);
		Person p1 = new Person("Kabir", Gender.MALE, 28);
		Person p2 = new Person("Raihan", Gender.MALE, 24);
		Person p3 = new Person("Nayeem", Gender.MALE, 16);
		Person p4 = new Person("Borshon", Gender.MALE, 24);
		Person p5 = new Person("Tahsin", Gender.MALE, 26);
		Person p6 = new Person("Pappu", Gender.MALE, 27);
		Person p7 = new Person("sohel", Gender.MALE, 28);
		Person p8 = new Person("Robi", Gender.MALE, 100);
		Person p9 = new Person("Sagor", Gender.MALE, 99);
		Person p10 = new Person("Rashed", Gender.MALE, 122);

		List<Person> person = Arrays.asList(p, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
		return person;
	}

}
