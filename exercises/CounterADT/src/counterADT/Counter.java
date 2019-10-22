package counterADT;

import com.sun.xml.internal.bind.v2.TODO;

public class Counter implements CounterADT {
    // Attributes
    private int count;

    // Constructors
    public Counter() {
        super();
    }

    public Counter(int count) {
        this.count = count;
    }

    // Accessors
    @Override
    public int getCounter() {
        return this.count;
    }

    // Mutators
    @Override
    public void setCounter(int count) throws InvalidCounterException {
        if (count < 0) {
            throw new InvalidCounterException("Value must be non-negative.");
        }
        this.count = count;
    }

    // Transformers
    @Override
    public void incCounter() {
        // TODO: implement incCounter method
//        this.count++;
    }

    @Override
    public void decCounter() throws InvalidCounterException {
        // TODO: implement decCounter method
//        if (this.count == 0) {
//            throw new InvalidCounterException("counterADT.Counter cannot be decremented.");
//        }
//        this.count--;
    }

    @Override
    public boolean isZero() {
        // TODO: implement isZero method
//        if (this.count == 0) {
//            return true;
//        } else {
//            return false;
//        }
        return false;
    }

    @Override
    public String toString() {
        // TODO: implement toString method
//        return "counterADT.Counter value is: " + this.count;
        return null;
    }
}
