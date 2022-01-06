package com.example.servingwebcontent.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.servingwebcontent.clas.Person;
import com.example.servingwebcontent.itf.DictionnaryItf;
import com.example.servingwebcontent.repo.PersonRepository;

@Service
public class DictionnaryService implements DictionnaryItf {

	// Map<Integer, Person> hm;

	@Autowired
	PersonRepository pr;

	public DictionnaryService() {
		// super();
		// hm = new HashMap<Integer, Person>();
		// hm.put(1, new Person(1, "Who", "Doctor", "0607080910", "Lille"));
		// hm.put(2, new Person(2, "Bond", "James", "0610101040", "Londres"));
		// hm.put(3, new Person(3, "Macron", "Emmanuel", "0799887766", "Paris"));
		// hm.put(4, new Person(4, "Ladjici", "Karim", "0755555555", "Ménilomtant"));
		// hm.put(5, new Person(5, "Itoo", "TooI", "0123456789", "Ailleurs"));
	}

	@Override
	public Collection<Person> getAll() {
		// return (Collection<Person>) (hm.values());
		return pr.findAll();
	}

	@Override
	public Person getFromId(int id) {
		// return hm.get(id);
		return pr.findById(id);
	}

	@Override
	public boolean deleteFromId(int id) {
		// if (hm.remove(id) != null)
		// return true;
		Person p = pr.findById(id);
		if (p != null) {
			pr.delete(p);
			return true;
		}
		return false;
	}

	@Override
	public void addPerson(Person p) {
		// hm.put(p.getId(), p);
		pr.save(p);
	}

	@Override
	public List<Person> getFromName(String name) {
		// return hm.values().stream().filter(e ->
		// e.getName().equals(name)).collect(Collectors.toList());
		return pr.findByName(name);
	}
}
