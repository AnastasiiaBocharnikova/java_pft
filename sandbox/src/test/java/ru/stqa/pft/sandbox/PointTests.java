package ru.stqa.pft.sandbox;

import org.testng.annotations.Test;

public class PointTests {

    @Test
    public void testAres() {
        Strech q = new Strech(new Point(2.0, 2.0), new Point(5.0, 6.0));
        assert q.abstand() == 5;

    }
}
