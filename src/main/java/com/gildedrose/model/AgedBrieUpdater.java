package com.gildedrose.model;

import com.gildedrose.model.Interface.UpdateQuality;

public class AgedBrieUpdater implements UpdateQuality {

    @Override
    public void update(Item item) {
        decreaseSellIn(item);
        if (item.quality < 50){
            addQuality(item, 1);
            if (isExpired(item)){
                addQuality(item, 1);
            }
        }

    }
}
