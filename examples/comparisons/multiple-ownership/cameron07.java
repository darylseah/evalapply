// Cameron '07

class Main {
    void main() {
        Project p1 = new Project();
        Project p2 = new Project();
        Worker w = new Worker();

        // Tasks can belong to either Projects or Workers
        Task t1 = new Task();
        p1.add(t1);
        w.add(t1);

        Task t2 = new Task();
        p2.add(t2);
        w.add(t2);

        // Effects
        p1.delay();
        p2.delay(); // No interference

        p2.delay(); // Interference
        w.delay();
    }
}

class Project {
    TaskList tasks;

    void delay() {
        for (Task t : tasks) { t.delay(); }
    }

    void add(Task t) {
        tasks.add(t);
    }
}

// Symmetrical to Project class
class Worker {
    TaskList tasks;

    void delay() {
        for (Task t : tasks) { t.delay(); }
    }

    void add(Task t) {
        tasks.add(t);
    }
}

class Task {
    // ...
}

class TaskList implements List {
    // ...
}
