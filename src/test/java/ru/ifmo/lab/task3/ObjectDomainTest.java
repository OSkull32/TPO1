package ru.ifmo.lab.task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ObjectDomainTest {

    @Nested
    class HumanTest {
        private Human human;

        @BeforeEach
        void init() {
            human = new Human(Name.ARTHUR, Feeling.LOST);
        }

        @Test
        @DisplayName("Check holding an item")
        void checkHoldingItem() {
            human.hold(Item.GLASS_BOTTLE);
            assertEquals(Feeling.LOST, human.getFeeling());
        }

        @Test
        @DisplayName("Check looking at another human")
        void checkLookingAt() {
            human.lookAt(Name.FORD);
            assertEquals(Feeling.LOST, human.getFeeling());
        }

        @Test
        @DisplayName("Check blinking")
        void checkBlinking() {
            human.blink();
            assertEquals(Feeling.LOST, human.getFeeling());
        }

        @Test
        @DisplayName("Check changing feelings")
        void checkFeelingChange() {
            human.feel(Feeling.CONFIDENT);
            assertEquals(Feeling.CONFIDENT, human.getFeeling());
        }
    }

    @Nested
    class FishTest {
        private Fish fish;

        @BeforeEach
        void init() {
            fish = new Fish(Color.YELLOW, Size.SMALL);
        }

        @Test
        @DisplayName("Check shimmering")
        void checkShimmering() {
            fish.shimmer();
            assertEquals(Color.YELLOW, fish.getColor());
        }

        @Test
        @DisplayName("Check swimming")
        void checkSwimming() {
            fish.swim();
            assertEquals(Size.SMALL, fish.getSize());
        }
    }

    @Nested
    class BottleTest {
        private Bottle bottle;

        @BeforeEach
        void init() {
            bottle = new Bottle(new Fish(Color.YELLOW, Size.SMALL));
        }

        @Test
        @DisplayName("Check shaking the bottle")
        void checkShaking() {
            bottle.shake();
            assertNotNull(bottle.getFish());
        }
    }
}
