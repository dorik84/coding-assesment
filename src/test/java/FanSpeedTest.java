import Concrete.FanSpeed;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.LinkedList;

class FanSpeedTest {

    @Test
    @DisplayName("Should NOT create FanSpeed Class instance with empty options")
    void shouldNotCreateFanSpeedWithEmptyOptions() {
        Integer[] options = new Integer[]{};
        Assertions.assertThrows(RuntimeException.class, () -> {new FanSpeed(options);
        });
    }

    @Test
    @DisplayName("Should create FanSpeed with specified options")
    void shouldCreateFanSpeed() {
        Integer [] options = new Integer[]{0,1,2,3,4,5};
        FanSpeed s = new FanSpeed(options);
        Assertions.assertEquals(new LinkedList<>(Arrays.asList(options)), s.getOptions());
    }


    @Nested
    class withCommonOptions {
        FanSpeed s;

        @BeforeEach
        public void setup(){
            s = new FanSpeed();
        }

        @Test
        @DisplayName("Should create FanSpeed with default options")
        void shouldCreateFanSpeedWithDefaultOptions() {
            Integer[] options = new Integer[]{0,1,2,3};
            Assertions.assertEquals(new LinkedList<>(Arrays.asList(options)), s.getOptions());
        }


        @Test
        @DisplayName("Should decrease and return correct current value")
        void shouldDecreaseAndGetCurrentValue() {

            Assertions.assertEquals(0, s.getCurrent());
            s.decrease();
            Assertions.assertEquals(3, s.getCurrent());
            s.decrease();
            s.decrease();
            Assertions.assertEquals(1, s.getCurrent());
            s.decrease();
            s.decrease();
            Assertions.assertEquals(3, s.getCurrent());
        }

        @Test
        @DisplayName("Should Increase and return correct current value")
        void shouldIncreaseAndGetCurrentValue() {
            Assertions.assertEquals(0, s.getCurrent());
            s.increase();
            Assertions.assertEquals(1, s.getCurrent());
            s.increase();
            s.increase();
            Assertions.assertEquals(3, s.getCurrent());
            s.increase();
            s.increase();
            Assertions.assertEquals(1, s.getCurrent());
        }
    }

}