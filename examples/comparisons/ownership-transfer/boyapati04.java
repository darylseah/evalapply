
class TStackClient<clientOwner> {
    void test() writes(world) {
        TStack<this, this> s1;
        TStack<this, world> s2;
        TStack<world, world> s3;
        /* TStack<world, this> s4; illegal! implicit assumption that first parameter is <= others */

        TStack<unique:this, this> u1, v1;
        TStack<unique:this, world> u2, v2;
        TStack<unique, world> u3, v3; // Equivalent to: TStack<unique:world, world> u3, v3;
        /* TStack<unique, this> u4, v4; illegal! similar violation of constraint */
        v1 = u1--; v2 = u2--; v3 = u3--; v2 = u3--;
        s1 = u1--; s2 = u2--; s3 = u3--; s2 = u3--;

        // TODO same variables transferred twice?
        // TODO isn't u1 null here?

        borrow (TStack<f, this> x1 = u1) {
            // x1 = u1--;
            x1.push(...);
            x1.pop();
        }

        TStack<f, this> x2 = x1;
        x2.push(...);
        x1.pop();
    } // u1 = x1--;
}

class TStack<stackOwner, TOwner> {
    TNode<this, TOwner> head = null;
    void push(T<TOwner> value) writes(this) {
        TNode<this, TOwner> newNode = new TNode<this, TOwner>(value, head);
        head = newNode;
    }
    T<TOwner> pop() writes(this) {
        if (head == null) return null;
        T<TOwner> value = head.value();
        head = head.next();
        return value;
    }
}

class TNode<nodeOwner, TOwner> {
    TNode<nodeOwner, TOwner> next; T<TOwner> value;
    TNode(T<TOwner> v, TNode<nodeOwner, TOwner> n) writes(this) {
        this.value = v; this.next = n;
    }
    T<TOwner> value() reads (this) {
        return value;
    }
    TNode<nodeOwner, TOwner> next() writes(this) {
        return next;
    }
}

class T<TOwner> { }
