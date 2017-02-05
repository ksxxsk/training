package gayle.stackqueue.questions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * An animal shelter, which holds only dogs and cats, operates on a strictly"first in, first
 * out" basis. People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
 * or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of
 * that type). They cannot select which specific animal they would like. Create the data structures to
 * maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog,
 * and dequeueCat. You may use the built-in Linked List data structure.
 * Hints: #22, #56, #63
 */
public class AnimalShelter {

    static abstract class Animal {
        private int order;

        public Animal() {
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }
    }

    public static class Cat extends Animal {
    }

    public static class Dog extends Animal {
    }

    public static class AnimalQueue {

        private final Queue<Cat> cats;
        private final Queue<Dog> dogs;
        private int order = 0;

        public AnimalQueue() {
            cats = new LinkedList<>();
            dogs = new LinkedList<>();
        }

        public void enqueue(Animal animal) {
            animal.setOrder(order++);
            if (animal instanceof Cat) {
                cats.offer((Cat) animal);
            }
            if (animal instanceof Dog) {
                dogs.offer((Dog) animal);
            } else
                throw new IllegalArgumentException();
        }

        public Cat dequeueCat() {
            return cats.poll();
        }

        public Dog dequeueDog() {
            return dogs.poll();
        }

        public Animal dequeueAny() {
            return dogs.peek().getOrder() > cats.peek().getOrder() ? dequeueCat() : dequeueDog();
        }
    }
}
