package ru.job4j.assertj;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Cube");
    }

    @Test
    void isThisUnknownObject() {
        Box box = new Box(5, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Unknown object");
    }

    @Test
    void whenTwoVerticesThenIsNegativeAndIsLessThanZero() {
        Box box = new Box(3, 10);
        int numberOfVertices = box.getNumberOfVertices();
        assertThat(numberOfVertices)
                .isEqualTo(-1)
                .isNegative()
                .isLessThan(0);
    }

    @Test
    void whenFourVerticesThenFourVerticesAndIsEvenAndIsPositive() {
        Box box = new Box(4, 10);
        int numberOfVertices = box.getNumberOfVertices();
        assertThat(numberOfVertices)
                .isEqualTo(4)
                .isEven()
                .isPositive();
    }

    @Test
    void whenMinusOneVerticesThenFalse() {
        Box box = new Box(-1, 10);
        boolean isExist = box.isExist();
        assertThat(isExist)
                .isFalse()
                .isNotEqualTo(true);
    }

    @Test
    void whenEightVerticesThenTrue() {
        Box box = new Box(8, 10);
        boolean isExist = box.isExist();
        assertThat(isExist)
                .isTrue();
    }

    @Test
    void whenEightVerticesAndEdgeEqualsToTenThenArea() {
        Box box = new Box(8, 10);
        double area = box.getArea();
        assertThat(area)
                .isEqualTo(600D)
                .isBetween(500D, 700D)
                .isGreaterThan(0D);
    }

    @Test
    void whenNineVerticesAndEdgeEqualsToSevenThenArea() {
        Box box = new Box(9, 7);
        double area = box.getArea();
        assertThat(area)
                .isEqualTo(0)
                .isLessThan(1D);
    }
}