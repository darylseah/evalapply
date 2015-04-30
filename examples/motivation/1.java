// Clarke '99
class Person {}

class Engine {
    void start() {
        // ...
    }
}

class Car {
    Engine engine;
    Person driver;

    void start() {
        if (driver != null) {
            engine.start();
        }
    }
}

class Main {
    static void main() {
        Car car = new Car();
        car.start();
        car.engine.start(); // should this be allowed?
    }
}
