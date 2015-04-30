
// Multiple ownership: immutable iterator

// Does not need multiple ownership features,
// just owners-as-modifiers discipline

class List<owner, dataOwner> {
    Node<this, dataOwner> head;

    Iterator<this, dataOwner> makeIterator() {
        new Iterator<this, dataOwner>.next = head;
    }
}

class Node<owner, dataOwner> {
    Data<dataOwner> data;
    Node<owner, dataOwner> next;
}

class Iterator<nodeOwner, dataOwner>{
    Node<nodeOwner, dataOwner> next;
}

final List<listOwner, dataOwner> list;
Iterator<list, dataOwner> iter = list.makeIterator();
