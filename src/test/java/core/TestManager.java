package core;

import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;

/**
 * Created by Ramesh Baskarasubramanian on 6/11/15.
 */

public class TestManager {

    @BeforeSuite
    public void setUp() {
        Driver.start();
    }

    @AfterSuite
    public void tearDown() {
        Driver.close();
    }
}
