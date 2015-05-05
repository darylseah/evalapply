
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

class Queue {
    rep Link<t> first;
    rep Link<t> last;

    void add(t Object value) {
        if (last == null) {
            first = last = new rep Link<t>(value);
        } else {
            last.next = new rep Link<t>(value);
            last.next.prev = last;
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
        } else {
            first.prev = null;
        }
        return value;
    }

    owner Iterator<t> iterator() {
        return new owner Iterator<t>(first);
    }
}

class Iterator<t> {
    // FAIL: Not possible to express this!
    ???? Link<t> current;
    ???? Link<t> returned;

    Iterator(???? Link<t> start) {
        current = start;
    }

    boolean hasNext() {
        return current != null;
    }

    t Object next() {
        t Object value = current.value;
        returned = current;
        current = current.next;
        return value;
    }

    void remove() {
        if (returned.prev == null) {
            first = current;
            if (current == null) {
                last = null;
            } else {
                current.prev = null;
            }
        } else {
            returned.prev.next = current;
            if (current == null) {
                last = returned.prev;
            } else {
                current.prev = returned.prev;
            }
        }
        returned = null;
    }
}

class Link<t> {
    Link<t> next;
    Link<t> prev;
    t Object value;

    Link(t Object value) {
        this.value = value;
    }
}

