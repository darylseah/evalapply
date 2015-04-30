
//////////////////////////////////////////////////////////////////////////////
//////////////////////////////// BOYAPATI '04 ////////////////////////////////
//////////////////////////////////////////////////////////////////////////////

class Main {
    void main() {
        Queue<this, this> q = new Queue<this, this>();
        q.add("Hello");
        q.add("World");

        Iterator<this, this> i = q.iterator();
        while (i.hasNext()) {
            println(i.next());
        }
    }
}

class Queue<o, t> {
    Link<this, t> first;
    Link<this, t> last;

    void add(Object<t> value) {
        if (last == null) {
            first = last = new Link<this, t>(value);
        } else {
            last.next = new Link<this, t>(value);
            last = last.next;
        }
    }

    Object<t> remove() {
        if (first == null) {
            return null;
        }
        Object<t> value = first.value;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return value;
    }

    Iterator<o, t> iterator() {
        return new Iterator<o, t>(first);
    }
}

class Iterator<o, t> {
    // FAIL: Not possible to express this!
    Link<????, t> current;

    Iterator(Link<????, t> start) {
        current = start;
    }

    boolean hasNext() {
        return current != null;
    }

    Object<t> next() {
        Object<t> value = current.value;
        current = current.next;
        return value;
    }
}

class Link<o, t> {
    Link<o, t> next;
    Object<t> value;

    Link(Object<t> value) {
        this.value = value;
    }
}
