class Project {
	void add(Task<this & ?> t) { /* ... */ }
}
new Project().add(new Task<p1 & w1>());
