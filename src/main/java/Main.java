public class Main {
    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();


        shelter.enqueue(new Dog());
        shelter.enqueue(new Cat());
        shelter.enqueue(new Dog());
        shelter.enqueue(new Cat());


        Animal animal = shelter.dequeueAny();
        System.out.println("Dequeued Any: " + animal.getType());


        animal = shelter.dequeueCat();
        System.out.println("Dequeued Cat: " + animal.getType());


        animal = shelter.dequeueDog();
        System.out.println("Dequeued Dog: " + animal.getType());


        animal = shelter.dequeueAny();
        System.out.println("Dequeued Any: " + animal.getType());
    }
}
