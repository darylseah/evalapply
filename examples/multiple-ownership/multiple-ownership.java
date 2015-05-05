class Task { /* ... */ }
class TaskList { /* ... */ }

class Project {
	TaskList tasks;
	void delay() {
		for (Task t : tasks) { t.delay(); }
	}
}

class Worker { // Symmetric
	TaskList tasks;
	void delay() {
		for (Task t : tasks) { t.delay(); }
	}
}
