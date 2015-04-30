
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

class Queue<t> {
    Link<this, t> first;
    Link<this, t> last;

    void add(Object<t> value) {
        if (last == null) {
            first = last = new Link<this, t>(value);
        } else {
            last.next = new Link<this, t>(value);
            last.next.prev = last;
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
        } else {
            first.prev = null;
        }
        return value;
    }

    Iterator<io, t> iterator<io>() {
        return new Iterator<io, t>(first);
    }

    class Iterator<io, t> {
        Link<Queue.this, t> current;
        Link<Queue.this, t> returned;

        Iterator(Link<Queue.this, t> start) {
            current = start;
        }

        boolean hasNext() {
            return current != null;
        }

        Object<t> next() {
            Object<t> value = current.value;
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
}

class Link<o, t> {
    Link<o, t> next;
    Link<o, t> prev;
    Object<t> value;

    Link(Object<t> value) {
        this.value = value;
    }
}
