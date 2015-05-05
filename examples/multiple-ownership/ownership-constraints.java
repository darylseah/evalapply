class C<owner, a, b> where
	a intersects owner,
	b disjoint owner
{
	// legal: known intersection
	Object<a & owner> o1;

	// illegal: known disjointness
	Object<b & owner> o2;

	// illegal: nothing known
	Object<a & b> o3;
}

class Example {
	void method(Object a, Object b, Object c) {
		// legal
		new C<a, b, c>();
		// illegal: disjointness is irreflexive
		new C<a, b, a>();
	}
}
