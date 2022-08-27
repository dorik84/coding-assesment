import Abstract.State;
import Concrete.ForwardState;
import Concrete.ReversedState;
import Main.Fan;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class StateTest {
    private static Fan fan;

    @BeforeAll()
    public static void setupFun(){
//        Integer[] speeds = new Integer[]{0,1,2,3};
        fan = new Fan();
    }

    @Test
    @DisplayName("ConcreteState.ForwardState.getDIRECTION should return proper value")
    void FSgetDirectionShouldReturnProperValue() {
        ForwardState fs = new ForwardState(fan);
        Assertions.assertEquals("forward", fs.getDirection());
    }

    @Test
    @DisplayName("ConcreteState.ReversedState.getDIRECTION should return proper value")
    void RSgetDirectionShouldReturnProperValue() {
        ReversedState rs = new ReversedState(fan);
        Assertions.assertEquals("reversed", rs.getDirection());
    }

    @Test
    @DisplayName("ConcreteState.ForwardState.onSpeed should switch speed forward and start over when on last speed")
    void FSOnSpeed() {
        State fs = new ForwardState(fan);
        fs.onSpeed();
        Assertions.assertEquals(1, fan.getSpeeds().getCurrent());
        fs.onSpeed();
        Assertions.assertEquals(2, fan.getSpeeds().getCurrent());
        fs.onSpeed();
        Assertions.assertEquals(3, fan.getSpeeds().getCurrent());
        fs.onSpeed();
        Assertions.assertEquals(0, fan.getSpeeds().getCurrent());
    }

    @Test
    @DisplayName("ConcreteState.ReversedState.onSpeed should switch speed backward and start over when on first speed")
    void RSOnSpeed() {
        State rs = new ReversedState(fan);
        rs.onSpeed();
        Assertions.assertEquals(3, fan.getSpeeds().getCurrent());
        rs.onSpeed();
        Assertions.assertEquals(2, fan.getSpeeds().getCurrent());
        rs.onSpeed();
        Assertions.assertEquals(1, fan.getSpeeds().getCurrent());
        rs.onSpeed();
        Assertions.assertEquals(0, fan.getSpeeds().getCurrent());
    }

    @Test
    @DisplayName("ConcreteState.ForwardState.onReverse should switch direction from forward to reversed")
    void FSOnReverse() {
        Assertions.assertEquals("forward", fan.getState().getDirection());
        fan.getState().onReverse();
        Assertions.assertEquals("reversed", fan.getState().getDirection());
    }

    @Test
    @DisplayName("ConcreteState.ReversedState.onReverse should switch direction from reversed to forward")
    void RSOnReverse() {
        Assertions.assertEquals("forward", fan.getState().getDirection());
        fan.getState().onReverse();
        Assertions.assertEquals("reversed", fan.getState().getDirection());
        fan.getState().onReverse();
        Assertions.assertEquals("forward", fan.getState().getDirection());
    }

}