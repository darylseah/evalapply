class Num<owner, otherOwner> {
    int value;
    void add(Num<otherOwner, this> other) {
        value += other.value;
    }
}

Num a = new Num<world, world>(1);
Num b = new Num<world, world>(2);
a.add(b);
