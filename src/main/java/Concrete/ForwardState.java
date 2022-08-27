package Concrete;

import Abstract.State;

public class ForwardState extends State {
    final String DIRECTION = "forward";

    public ForwardState(Main.Fan fan){
        super(fan);
        this.logDirection();
    }

    @Override
    public void onSpeed() {
        fan.getSpeeds().increase();
    }

    @Override
    public void onReverse() {
        fan.setState(new ReversedState(this.fan));
    }

    @Override
    public String getDirection() {
        return DIRECTION;
    }

    private void logDirection() {
        System.out.println(String.format("Current direction: %s", this.getDirection()));
    }

}
