package org.example.Behavioral;

interface Bird{
    public void fly();
    public void makeSound();
}

class Peacock implements Bird{
    @Override
    public void fly() {
        System.out.println("Peacock is flying !!");
    }

    @Override
    public void makeSound() {
        System.out.println("Peacock is screaming....");
    }
}

interface Duck{
    public void squeak();
}

class PlasticDuck implements Duck{
    @Override
    public void squeak() {
        System.out.println("Duck Squeakkk !!");
    }
}

class BirdAdapter implements Duck{
    Bird bird;
    public BirdAdapter(){}

    public BirdAdapter(Bird bird){
        this.bird = bird;
    }

    @Override
    public void squeak() {
        bird.makeSound();
    }
}

public class Adapter{
    public static void main(String args[]){
        Peacock peacock = new Peacock();
        Duck duck = new PlasticDuck();
        Duck birdAdapter = new BirdAdapter(peacock);

        System.out.println("About Peacock : ");
        peacock.makeSound();
        peacock.fly();

        System.out.println("About Duck : ");
        duck.squeak();

        System.out.println("Bird Adapter : ");
        birdAdapter.squeak();
    }
}