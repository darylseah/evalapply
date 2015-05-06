class Link<X> {
	X next;
}

class Node<K,V> extends Link<peer Node<K,V>> {
	K key; V value;
}

class Iterator<X extends any Link<X>> {
	X current;

	Iterator(X first) {
		current = first;
	}

	pure boolean hasNext() {
		return current != null;
	}

	impure X next() {
		X result = current;
		current = current.next;
		return result;
	}
}

class Map<K,V> {
	rep Node<K,V> first;

	impure peer Iterator<rep Node<K,V>> iterator() {
		return new peer Iterator<rep Node<K,V>>(first);
	}
}