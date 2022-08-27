package Main;

import Abstract.Speed;
import Abstract.State;
import Concrete.FanSpeed;
import Concrete.ForwardState;

public class Fan {
    private State state;
    private Speed speeds;

    public Fan() throws RuntimeException {
        this.state = new ForwardState(this);
        this.speeds = new FanSpeed();
    }

    public Speed getSpeeds() {
        return speeds;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

}
