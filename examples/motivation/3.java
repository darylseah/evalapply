// Modified Clarke '99, Boyapati's syntax
class Person {}

class Engine<EngineOwner> {
    void start() {
        // ...
    }
}

class Car<CarOwner, DriverOwner> {
    Engine<this> engine;
    Person<DriverOwner> driver;

    void start() {
        if (driver != null) {
            getEngine().start();
        }
    }

    Engine<this> getEngine() { return engine; }
}

class Main {
    public static void main() {
        Car<world> car = new Car<world>();
        car.start();
        car.getEngine().start(); // should this be allowed?
    }
}