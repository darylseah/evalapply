class Num<owner> {
    int value;
    void add(Num<owner & ?> other) {
        value += other.value;
    }
}

Num a = new Num<world, world>(1);
Num b = new Num<world, world>(2);
a.add(b);
