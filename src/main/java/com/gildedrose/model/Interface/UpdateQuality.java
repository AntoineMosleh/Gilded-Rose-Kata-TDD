package com.gildedrose.model.Interface;

import com.gildedrose.model.Item;

public interface UpdateQuality {

    void update(Item item);

    default void decreaseSellIn(Item item){
        item.sellIn --;
    }

    default boolean isExpired (Item item){
        return item.sellIn < 0;
    }

    default void addQuality(Item item, int delta){
        item.quality = Math.min(50,item.quality + delta);
    }

    default void subQuality(Item item, int delta){
        item.quality = Math.max(0,item.quality - delta);
    }

}
