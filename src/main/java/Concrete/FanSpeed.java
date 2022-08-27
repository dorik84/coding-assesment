package Concrete;

import Abstract.Speed;

import java.util.LinkedList;

public class FanSpeed extends Speed {

    public FanSpeed(Integer[] options) throws RuntimeException {
        super(options);
    }
    public FanSpeed() throws RuntimeException {
        super(new Integer[]{0,1,2,3});
    }

    @Override
    public void increase() {
        Integer previous = (Integer) this.options.poll();
        this.options.add(previous);
        this.current = this.options.getFirst();
        this.logCurrent();
    }

    @Override
    public void decrease() {
        Integer previous = (Integer) this.options.pollLast();
        this.options.addFirst(previous);
        this.current = this.options.getFirst();
        this.logCurrent();
    }

    @Override
    public Integer getCurrent(){
        return (Integer)this.current;
    }

    public LinkedList getOptions(){
        return this.options;
    }


    private void logCurrent() {
        System.out.println(String.format("Current speed: %s", this.getCurrent()));
    }

}
