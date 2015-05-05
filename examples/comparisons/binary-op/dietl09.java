class Num {
    int value;
    void add(any Num other) {
        // Just works because UT/GUT uses owners-as-modifiers;
        // Perfectly legal to read the representation of another instance
        value += other.value;
    }
}

rep Num a = new rep Num(1);
rep Num b = new rep Num(2);
a.add(b);
