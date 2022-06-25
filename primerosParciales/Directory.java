package primerosParciales;

import java.util.Arrays;
import java.util.Comparator;

public class Directory{
    private final Person[] persons;
    private int dim;

    public Directory(int limit){
        this.persons = new Person[limit];
    }

    public Directory addPerson(Person person) throws ReachedLimitException {
        if(dim == persons.length) {
            throw new ReachedLimitException(dim);
        }
        persons[dim++] = person;
        return this;
    }
    protected Person[] persons(Comparator<Person> cmp) {
        Person[] personsCopy = Arrays.copyOf(persons, dim);
        Arrays.sort(personsCopy, cmp);
        return personsCopy;
    }
    public Person[] persons() {
        return persons(Comparator.naturalOrder());
    }
}
