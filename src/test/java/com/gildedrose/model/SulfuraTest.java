package com.gildedrose.model;

import com.gildedrose.GildedRose;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SulfuraTest {

    @Test
    void sulfuras_never_changes() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateQuality();

        assertThat(item.sellIn).isEqualTo(0);
        assertThat(item.quality).isEqualTo(80);
    }
}
