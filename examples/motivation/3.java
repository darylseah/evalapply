class Person {}

class Engine<EngineOwner> {
	void start() { /* ... */ }
}

class Car<CarOwner, DriverOwner> { /*@
		\label{code:ownership_types_car_engine_1_parametric_owner} @*/
	Engine<this> engine;
	Person<DriverOwner> driver;

	void start() {
		if (driver != null) {
			getEngine().start();
		}
	}

	Engine<this> getEngine() {
		return engine;
	}
}

class Main {
	static void main() {
		Car<this, world> car = new Car<this, world>();
		car.start();
		car.getEngine().start();/*@\label{code:ownership_types_car_engine_1_engine_start}@*/
	}
}
