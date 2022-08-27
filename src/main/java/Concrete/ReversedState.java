package Concrete;

import Abstract.State;

public class ReversedState extends State {
    final String DIRECTION = "reversed";

    public ReversedState(Main.Fan fan){
        super(fan);
        this.logDirection();
    }

    @Override
    public void onSpeed() {
        fan.getSpeeds().decrease();
    }

    @Override
    public void onReverse() {
        fan.setState(new ForwardState(this.fan));
    }

    @Override
    public String getDirection() {
        return DIRECTION;
    }

    private void logDirection() {
        System.out.println(String.format("Current direction: %s", this.getDirection()));
    }
}
