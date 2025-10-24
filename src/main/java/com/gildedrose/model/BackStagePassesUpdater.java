package com.gildedrose.model;

import com.gildedrose.model.Interface.UpdateQuality;

public class BackStagePassesUpdater implements UpdateQuality {

    @Override
    public void update(Item item) {
        decreaseSellIn(item);
        if (isExpired(item)){
            item.quality = 0;
            return ;
        }
        if (item.quality < 50){
            if (item.sellIn < 5)
                addQuality(item, 3);
            else if (item.sellIn < 10)
                addQuality(item, 2);
            else
                addQuality(item, 1);
        }
    }
}
