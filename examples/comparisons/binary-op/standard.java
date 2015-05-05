class Num {
    int value;
    void add(Num other) {
        value += other.value;
    }
}

Num a = new Num(1);
Num b = new Num(2);
a.add(b);
