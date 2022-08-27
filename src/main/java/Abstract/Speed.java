package Abstract;

import java.util.Arrays;
import java.util.LinkedList;

public abstract class Speed<T> {

    protected LinkedList<T> options;
    protected T current;

    public Speed(T[] options) throws RuntimeException {
        if (options.length == 0) {
            throw new RuntimeException("The options must contain at least one option");
        }
        this.options = new LinkedList<>(Arrays.asList(options));
        this.current = this.options.get(0);
    }

    public abstract void increase();
    public abstract void decrease();
    public abstract T getCurrent();

}
