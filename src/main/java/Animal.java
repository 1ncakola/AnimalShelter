import java.util.LinkedList;

class Animal {
    private String type;
    private int order;

    public Animal(String type) {
        this.type = type;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

    public String getType() {
        return type;
    }
}

class Dog extends Animal {
    public Dog() {
        super("dog");
    }
}

class Cat extends Animal {
    public Cat() {
        super("cat");
    }
}

class AnimalShelter {
    private LinkedList<Dog> dogs;
    private LinkedList<Cat> cats;
    private int order;

    public AnimalShelter() {
        dogs = new LinkedList<>();
        cats = new LinkedList<>();
        order = 0;
    }

    public void enqueue(Animal animal) {
        animal.setOrder(order++);
        if (animal instanceof Dog) {
            dogs.addLast((Dog) animal);
        } else if (animal instanceof Cat) {
            cats.addLast((Cat) animal);
        }
    }

    public Animal dequeueAny() {
        if (dogs.isEmpty() && cats.isEmpty()) return null;
        if (dogs.isEmpty()) return dequeueCat();
        if (cats.isEmpty()) return dequeueDog();

        Dog oldestDog = dogs.peek();
        Cat oldestCat = cats.peek();

        if (oldestDog.getOrder() < oldestCat.getOrder()) {
            return dequeueDog();
        } else {
            return dequeueCat();
        }
    }

    public Dog dequeueDog() {
        if (!dogs.isEmpty()) {
            return dogs.poll();
        }
        return null;
    }

    public Cat dequeueCat() {
        if (!cats.isEmpty()) {
            return cats.poll();
        }
        return null;
    }
}
