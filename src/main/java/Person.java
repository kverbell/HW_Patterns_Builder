public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;

    public Person(String name, String surname) {
        if (name == null || surname == null) {
            throw new IllegalStateException("Нужно указать имя и фамилию");
        }
        this.name = name;
        this.surname = surname;
        this.age = -1;
    }

    public Person(String name, String surname, int age) {
        this(name, surname);
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
        this.age = age;
    }

    public boolean hasAge() {
        return age != -1;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        if (!hasAge()) {
            throw new IllegalStateException("Возраст неизвестен");
        }
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (hasAge()) {
            age++;
        }
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(this.surname)
                .setAge(0);
    }

    @Override
    public String toString() {
        return name + " " + surname + (hasAge() ? ", возраст: " + age : "") + (hasAddress() ? ", город: " + address : "");
    }

    @Override
    public int hashCode() {
        return (name + surname).hashCode();
    }
}

