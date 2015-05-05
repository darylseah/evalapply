
//////////////////////////////////////////////////////////////////////////////
///////////////////////////////// DIETL '09 //////////////////////////////////
//////////////////////////////////////////////////////////////////////////////

class Main {
    void main() {
        rep Queue q = new rep Queue();
        q.add("Hello");
        q.add("World");

        // Iterator cannot be 'any' because it modifies itself to iterate!
        rep Iterator i = q.iterator();
        while (i.hasNext()) {
            println(i.next());
        }
    }
}

class Queue {
    rep Link first;
    rep Link last;

    impure void add(any Object value) {
        if (last == null) {
            first = last = new rep Link(value);
        } else {
            last.next = new rep Link(value);
            last = last.next;
        }
    }

    impure any Object remove() {
        if (first == null) {
            return null;
        }
        any Object value = first.value;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return value;
    }

    pure peer Iterator iterator() {
        return new peer Iterator(first);
    }
}

class Iterator {
    any Link current;

    pure Iterator(any Link start) {
        current = start;
    }

    pure boolean hasNext() {
        return current != null;
    }

    impure any Object next() {
        any Object value = current.value;
        current = current.next; // results in 'lost', but 'lost' is a subtype of 'any'
        return value;
    }
}

class Link {
    peer Link next;
    any Object value;

    pure Link(any Object value) {
        this.value = value;
    }
}

