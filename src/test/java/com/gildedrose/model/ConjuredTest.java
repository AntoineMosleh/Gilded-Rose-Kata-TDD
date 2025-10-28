package com.gildedrose.model;

import com.gildedrose.GildedRose;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConjuredTest {
    @Test
    void conjured_degrades_twice_as_fast_before_expiry() {
        Item item = new Item("Conjured", 3, 6);
        new GildedRose(new Item[]{item}).updateQuality();
        assertThat(item.sellIn).isEqualTo(2);
        assertThat(item.quality).isEqualTo(4);
    }

    @Test
    void conjured_degrades_four_after_expiry() {
        Item it = new Item("Conjured", 0, 8);
        new GildedRose(new Item[]{it}).updateQuality();
        assertThat(it.sellIn).isEqualTo(-1);
        assertThat(it.quality).isEqualTo(4); // -4
    }

    @Test
    void conjured_never_negative() {
        Item it = new Item("Conjured", 0, 3);
        new GildedRose(new Item[]{it}).updateQuality();
        assertThat(it.quality).isZero();
    }


}
