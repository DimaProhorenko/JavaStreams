package main;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> people = getPeople();
		
		List<Person> females = people.stream().filter(p -> p.getGender() == Gender.FEMALE).toList();
		
//		System.out.println(females);
		
//		List<Person> sorted = people.stream().sorted((p1, p2) -> p1.getAge() - p2.getAge()).toList();
//		List<Person> sorted = people.stream().sorted(Comparator.comparing(Person::getGender)).toList();
//		List<Person> sorted = people.stream().sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getGender)).toList();
//		
//		sorted.forEach(System.out::println);
		
//		boolean allMales = people.stream().allMatch(p -> p.getGender().equals(Gender.MALE));
//		boolean anyMales = people.stream().anyMatch(p -> p.getGender().equals(Gender.MALE));
//		boolean noMales = people.stream().noneMatch(p -> p.getGender().equals(Gender.MALE));
//		System.out.println(noMales);
		
//		people.stream()
//			  .max((p1, p2) -> p1.getAge() - p2.getAge())
//			  .ifPresent(p -> System.out.println(p));
		
		
//		people.stream()
//			  .min(Comparator.comparing(Person::getAge))
//			  .ifPresent(p -> System.out.println(p));
		
		Map<Gender, List<Person>> groupByGender = people.stream().collect(Collectors.groupingBy(Person::getGender));
		groupByGender.forEach((gender, persons) -> {
			System.out.println(gender);
			persons.forEach(System.out::println);
			System.out.println();
		});
		
			  
	}
	
	
	public static List<Person> getPeople() {
		return List.of(
				new Person("James Bond", 20, Gender.MALE),
				new Person("Dima", 23, Gender.MALE),
				new Person("Helen Marchelkova", 44, Gender.FEMALE),
				new Person("Sarah Harkov", 22, Gender.FEMALE)
		);
	}

}
