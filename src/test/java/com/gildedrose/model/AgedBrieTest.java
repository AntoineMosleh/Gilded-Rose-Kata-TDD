package com.gildedrose.model;

import com.gildedrose.GildedRose;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class AgedBrieTest {
    @Test
    void aged_brie_increases_by_1_before_expiry() {
        Item item = new Item("Aged Brie", 2, 10);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateQuality();

        assertThat(item.sellIn).isEqualTo(1);
        assertThat(item.quality).isEqualTo(11);
    }

    @Test
    void aged_brie_increases_by_2_after_expiry(){
        Item item = new Item("Aged Brie", 0, 10);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateQuality();

        assertThat(item.sellIn).isEqualTo(-1);
        assertThat(item.quality).isEqualTo(12);
    }

    @Test
    void aged_brie_quality_capped_at_50() {
        Item item = new Item("Aged Brie", 5, 50);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateQuality();

        assertThat(item.quality).isEqualTo(50);
    }


}
