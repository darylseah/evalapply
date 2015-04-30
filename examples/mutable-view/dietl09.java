
//////////////////////////////////////////////////////////////////////////////
///////////////////////////////// DIETL '09 //////////////////////////////////
//////////////////////////////////////////////////////////////////////////////

class Main {
    void main() {
        rep Queue q = new rep Queue();
        q.add("Hello");
        q.add("World");

        // If the elements in the container need to be mutated, it's a hassle
        // for the user (in Universes)
        rep Iterator i = q.iterator();
        while (i.hasNext()) {
            if ("World".equals(i.next())) {
                i.remove();
            }
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
            last.next.prev = last;
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
        } else {
            first.prev = null;
        }
        return value;
    }

    pure peer Iterator iterator() {
        return new peer Iterator(this, first);
        // self -> peer : peer, rep -> peer : rep
    }

    impure void __remove(any Link link) {
        // Required for an iterator removal. Problem is we cannot declare the
        // link as 'rep' without a runtime cast. Which makes this highly
        // inefficient.
    }
}

class Iterator {
    peer Queue parent;
    any Link current;
    any Link returned;

    pure Iterator(peer Queue parent, any Link start) {
        this.parent = parent;
        current = start;
    }

    pure boolean hasNext() {
        return current != null;
    }

    impure any Object next() {
        any Object value = current.value;
        returned = current;
        current = current.next;
        return value;
    }

    impure void remove() {
        // FAIL: this fails in Universes because we do not have access to the
        // reps of the parent queue. What we CAN do is invoke a method on the
        // parent queue, e.g. parent.__remove(returned)

        if (returned.prev == null) {
            parent.first = current;
            if (current == null) {
                parent.last = null;
            } else {
                current.prev = null;
            }
        } else {
            returned.prev.next = current;
            if (current == null) {
                parent.last = returned.prev;
            } else {
                current.prev = returned.prev;
            }
        }
        returned = null;
    }
}

class Link {
    peer Link next;
    peer Link prev;
    any Object value;

    pure Link(any Object value) {
        this.value = value;
    }
}
