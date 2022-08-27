package Abstract;
import Main.Fan;

public abstract class State {
    protected Fan fan;

    public State(Fan fan){
        this.fan = fan;
    }

    public abstract void onSpeed();
    public abstract void onReverse();
    public abstract String getDirection();

}
