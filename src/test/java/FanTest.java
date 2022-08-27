import Abstract.State;
import Concrete.FanSpeed;
import Concrete.ForwardState;
import Concrete.ReversedState;
import Main.Fan;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class FanTest {
    Integer[] options;

    @BeforeEach
    public void setup(){
        options = new Integer[]{0,1,2,3};
    }

    @Test
    @DisplayName("Should create Main.Fan Class instance with different options")
    void shouldCreateSpeed() {
        Assertions.assertDoesNotThrow(()-> new Fan());
    }


    @Test
    @DisplayName("Should return Abstract.Speed class instance based on options")
    void shouldGetSpeed() {

        Fan f = new Fan();
        Assertions.assertInstanceOf(FanSpeed.class, f.getSpeeds());
        Assertions.assertEquals(0, f.getSpeeds().getCurrent());
    }

    @Test
    @DisplayName("Should return Abstract.State class instance")
    void shouldGetState() {
        Fan f = new Fan();
        Assertions.assertInstanceOf(State.class, f.getState());
        Assertions.assertTrue("forward" == f.getState().getDirection() || "reversed" == f.getState().getDirection());
    }

    @Test
    @DisplayName("Should set different Abstract.State")
    void shouldSetState() {
        Fan f = new Fan();
        f.setState(new ReversedState(f));
        Assertions.assertInstanceOf(ReversedState.class, f.getState());
        Assertions.assertEquals("reversed", f.getState().getDirection() );
        f.setState(new ForwardState(f));
        Assertions.assertInstanceOf(ForwardState.class, f.getState());
        Assertions.assertEquals("forward", f.getState().getDirection() );
    }
}