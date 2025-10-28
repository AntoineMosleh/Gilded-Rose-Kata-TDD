package com.gildedrose.model;

import com.gildedrose.GildedRose;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BackStagePassesTest {
    private static final String PASS = "Backstage passes to a TAFKAL80ETC concert";

    @Test
    void increases_by_1_when_more_than_10_days() {
        Item item = new Item(PASS, 15, 20);
        new GildedRose(new Item[]{item}).updateQuality();
        assertThat(item.sellIn).isEqualTo(14);
        assertThat(item.quality).isEqualTo(21);
    }

    @Test
    void increases_by_2_when_10_days_or_less() {
        Item item = new Item(PASS, 10, 20);
        new GildedRose(new Item[]{item}).updateQuality();
        assertThat(item.sellIn).isEqualTo(9);
        assertThat(item.quality).isEqualTo(22);
    }

    @Test
    void increases_by_3_when_5_days_or_less() {
        Item it = new Item(PASS, 5, 20);
        new GildedRose(new Item[]{it}).updateQuality();
        assertThat(it.quality).isEqualTo(23);
    }

    @Test
    void drops_to_zero_after_concert() {
        Item it = new Item(PASS, 0, 35);
        new GildedRose(new Item[]{it}).updateQuality();
        assertThat(it.quality).isZero();
    }

}
