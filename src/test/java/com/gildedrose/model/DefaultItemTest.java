package com.gildedrose.model;

import com.gildedrose.GildedRose;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class DefaultItemTest {

    @Test
    void default_item_decreases_sellIn_and_quality_by_one_before_expiry(){
        Item item = new Item("Bento poulet frit", 10, 20);
        GildedRose app = new GildedRose(new Item[]{item});
        app.updateQuality();

        assertThat(item.sellIn).isEqualTo(9);
        assertThat(item.quality).isEqualTo(19);

    }

    @Test
    void default_item_also_decreases_with_other_values(){
        Item item = new Item("Pinte de blonde", 5, 7);
        GildedRose app = new GildedRose(new Item[]{item});
        app.updateQuality();

        assertThat(item.sellIn).isEqualTo(4);
        assertThat(item.quality).isEqualTo(6);

    }

    @Test
    void default_item_degrades_twice_as_fast_after_expiry(){
        Item item = new Item("Verre de vin rouge", 0, 7);
        GildedRose app = new GildedRose(new Item[]{item});
        app.updateQuality();

        assertThat(item.sellIn).isEqualTo(-1);
        assertThat(item.quality).isEqualTo(5);
    }
}
