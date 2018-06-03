import java.util.EmptyStackException;

public class Stack<E> {

    private LList<E> list;

    public Stack() {
        this.empty();
    }

    public void empty() {
        list = new LList<>();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public E peek() {
        list.reset();
        return list.current();
    }

    public void push(E o) {
        list.addFirst(o);
    }

    public void pop()throws StackUnderflow{
        if(list.isEmpty()) throw new StackUnderflow();
        list.reset();
        list.remove();
    }

    @Override
    public String toString() {
        return list.printList();
    }

    public void print(){
        System.out.println(this.toString());
    }


}

