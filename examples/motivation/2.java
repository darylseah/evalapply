class Person {}

class Engine {
	public void start() { /* ... */ }
}

class Car {
	private Engine engine;
	private Person driver;

	public void start() {
		if (driver != null) {
			engine.start();
		}
	}

	public Engine getEngine() {
		return engine;
	}
}

class Main {
	public static void main() {
		Car car = new Car();
		car.start();
		car.getEngine().start();/*@\label{code:modular_reasoning_car_engine_2_engine_start}@*/
	}
}
