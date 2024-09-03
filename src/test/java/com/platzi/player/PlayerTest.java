package com.platzi.player;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void looses_wen_dice_number_is_low() {
        Dice mockedDice = Mockito.mock(Dice.class);
        Mockito.when(mockedDice.roll()).thenReturn(2);
        Player player = new Player(mockedDice, 3);

        assertFalse(player.play());
    }

    @Test
    void win_when_dice_number_is_high() {
        Dice mockedDice = Mockito.mock(Dice.class);
        Mockito.when(mockedDice.roll()).thenReturn(4);
        Player player = new Player(mockedDice, 3);

        assertTrue(player.play());
    }

    @Test
    void win_when_dice_number_is_equal() {
        Dice mockedDice = Mockito.mock(Dice.class);
        Mockito.when(mockedDice.roll()).thenReturn(3);
        Player player = new Player(mockedDice, 3);

        assertTrue(player.play());
    }
}