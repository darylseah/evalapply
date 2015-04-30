
class Main {
    void main() {
        Queue q = new Queue();
        q.add("Hello");
        q.add("World");

        Iterator i = q.iterator();
        while (i.hasNext()) {
            if ("World".equals(i.next())) {
                i.remove();
            }
        }
    }
}

class Queue {
    Link first;
    Link last;

    void add(Object value) {
        if (last == null) {
            first = last = new Link(value);
        } else {
            last.next = new Link(value);
            last.next.prev = last;
            last = last.next;
        }
    }

    Object remove() {
        if (first == null) {
            return null;
        }
        Object value = first.value;
        first = first.next;
        if (first == null) {
            last = null;
        } else {
            first.prev = null;
        }
        return value;
    }

    Iterator iterator() {
        return new Iterator(this, first);
    }
}

class Iterator {
    Queue parent;
    Link current;
    Link returned;

    Iterator(Queue parent, Link start) {
        this.parent = parent;
        current = start;
    }

    boolean hasNext() {
        return current != null;
    }

    Object next() {
        Object value = current.value;
        returned = current;
        current = current.next;
        return value;
    }

    void remove() {
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
    Link next;
    Link prev;
    Object value;

    Link(Object value) {
        this.value = value;
    }
}
