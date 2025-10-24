package com.gildedrose.model;

import com.gildedrose.model.Interface.UpdateQuality;

public class DefaultItemUpdater implements UpdateQuality {

    @Override
    public void update(Item item) {
        decreaseSellIn(item);
        if (item.quality > 0){
            if (isExpired(item)){
                subQuality(item, 2);
            }else{
                subQuality(item, 1);
            }
        }
    }
}
