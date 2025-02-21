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
            human = new Human(Name.ARTHUR, Feeling.LOST, Item.NONE, Action.NONE);
        }

        @Test
        @DisplayName("Check holding an item")
        void checkHoldingItem() {
            human.hold(Item.GLASS_BOTTLE);
            assertEquals(Item.GLASS_BOTTLE, human.getItem());
        }

        @Test
        @DisplayName("Check looking at another human")
        void checkLookingAt() {
            human.lookAt(Name.FORD);
            assertEquals(Action.LOOK, human.getAction());
        }

        @Test
        @DisplayName("Check blinking")
        void checkBlinking() {
            human.blink();
            assertEquals(Action.BLINK, human.getAction());
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
            fish = new Fish(Color.RED, Size.SMALL, Item.NONE);
        }

        @Test
        @DisplayName("Check shimmering")
        void checkShimmering() {
            fish.shimmer(Color.YELLOW);
            assertEquals(Color.YELLOW, fish.getColor());
        }

        @Test
        @DisplayName("Check swimming")
        void checkSwimming() {
            fish.swim(Item.GLASS_BOTTLE);
            assertEquals(Item.GLASS_BOTTLE, fish.getItem());
        }
    }

    @Nested
    class BottleTest {
        private Bottle bottle;
        private Fish fish;

        @BeforeEach
        void init() {
            bottle = new Bottle();
            fish = new Fish(Color.RED, Size.SMALL, Item.NONE);
        }

        @Test
        @DisplayName("Check shaking the bottle")
        void checkShaking() {
            bottle.shake(fish);
            assertEquals(fish, bottle.getFish());
        }
    }
}
