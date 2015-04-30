
//////////////////////////////////////////////////////////////////////////////
///////////////////////////////// CLARKE '98 /////////////////////////////////
//////////////////////////////////////////////////////////////////////////////

class Main {
    void main() {
        rep Queue<rep> q = new rep Queue<rep>();
        q.add("Hello");
        q.add("World");

        rep Iterator<rep> i = q.iterator();
        while (i.hasNext()) {
            println(i.next());
        }
    }
}

class Queue<t> {
    rep Link<t> first;
    rep Link<t> last;

    void add(t Object value) {
        if (last == null) {
            first = last = new rep Link<t>(value);
        } else {
            last.next = new rep Link<t>(value);
            last = last.next;
        }
    }

    t Object remove() {
        if (first == null) {
            return null;
        }
        t Object value = first.value;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return value;
    }

    owner Iterator<t> iterator() {
        return new owner Iterator<t>(first);
    }
}

class Iterator<t> {
    // FAIL: Not possible to express this
    rep Link<t> current;

    Iterator(rep Link<t> start) {
        current = start;
    }

    boolean hasNext() {
        return current != null;
    }

    t Object next() {
        t Object value = current.value;
        current = current.next;
        return value;
    }
}

class Link<t> {
    Link<t> next;
    t Object value;

    Link(t Object value) {
        this.value = value;
    }
}
