import Main.Fan;

public class Runner {
    public static void main (String[] args) throws RuntimeException {
        Fan fan = new Fan();
        fan.getState().onSpeed();
        fan.getState().onSpeed();
        fan.getState().onSpeed();
        fan.getState().onSpeed();
        fan.getState().onReverse();
        fan.getState().onSpeed();
        fan.getState().onSpeed();
        fan.getState().onSpeed();
        fan.getState().onReverse();
        fan.getState().onSpeed();
        fan.getState().onSpeed();
        fan.getState().onSpeed();
        fan.getState().onSpeed();

    }
}
