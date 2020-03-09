package org.example.Structural;

abstract class Game{
    abstract void initialize();
    abstract void start();
    abstract void end();

    public final void play(){
        initialize();
        start();
        end();
    }
}

class Chess extends Game{
    @Override
    void initialize(){
        System.out.println("Chess has been Initialized");
    }
    @Override
    void start(){
        System.out.println("Chess has beenStarted");
    }
    @Override
    void end(){
        System.out.println("Chess has been Finished");
    }
}

class BasketBall extends Game{
    @Override
    void initialize(){
        System.out.println("BasketBall has been Initialized");
    }
    @Override
    void start(){
        System.out.println("BasketBall has been Started");
    }
    @Override
    void end(){
        System.out.println("BasketBall has been Finished");
    }
}

public class Template{
    public static void main(String[] args) throws InstantiationException,IllegalAccessException,ClassNotFoundException {
        Class chess = Class.forName("org.example.structural.Chess");
        Game gameSelect = (Game)chess.newInstance();
        gameSelect.play();
    }
}