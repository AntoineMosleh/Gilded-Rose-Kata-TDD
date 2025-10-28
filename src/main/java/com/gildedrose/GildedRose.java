package com.gildedrose;

import com.gildedrose.model.Interface.UpdateQuality;
import com.gildedrose.model.Item;
import com.gildedrose.model.factory.ItemUpdaterFactory;

public class GildedRose {
    Item[] items;
    private final ItemUpdaterFactory factory = new ItemUpdaterFactory();

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items){
            UpdateQuality updater = factory.from(item);
            updater.update(item);
        }

    }
}

