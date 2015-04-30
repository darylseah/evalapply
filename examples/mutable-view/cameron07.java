
//////////////////////////////////////////////////////////////////////////////
///////////////////////////////// CAMERON '07 ////////////////////////////////
//////////////////////////////////////////////////////////////////////////////

// Requires multiple ownership features
// Changed to doubly-linked list to support removal

class List<owner, dataOwner> {
    // Nodes are owned by the list as well as the iterator
    // Wildcard used because there can be any number of owning iterators
    Node<this & ?, dataOwner> head;

    Iterator<this, dataOwner> makeIterator() {
        new Iterator<this, dataOwner>.next = head;
    }
}

// Node implementation does not need to change
class Node<owner, dataOwner> {
    Data<dataOwner> data;
    Node<owner, dataOwner> next;
    Node<owner, dataOwner> prev;
}

class Iterator<list, dataOwner> {
    // Intersection constraint added
    // Nodes are jointly owned by the list and this iterator
    nodeOwner intersects this;
    Node<list & this, dataOwner> next;

    // We ignore problems with having multiple iterators having
    // pointers to removed nodes
    void remove() {
        // We're allowed to modify nodes because
        // the iterator is in their owner boxes
        next.prev.next = next.next;
        next.next.prev = next.prev;
        next = next.next;
    }
}

final List<listOwner, dataOwner> list;
Iterator<list, dataOwner> iter = list.makeIterator();

