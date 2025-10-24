package com.gildedrose.model.factory;

import com.gildedrose.model.*;
import com.gildedrose.model.Interface.UpdateQuality;

import java.util.HashMap;
import java.util.Map;

public class ItemUpdaterFactory {

    private final Map<String, UpdateQuality> registry = new HashMap<>();

    public ItemUpdaterFactory(){
        registry.put("Aged Brie", new AgedBrieUpdater());
        registry.put("Backstage passes to a TAFKAL80ETC concert", new BackStagePassesUpdater());
        registry.put("Sulfuras, Hand of Ragnaros", new SulfuraUpdater());
    }

    public UpdateQuality from (Item item){
        if (item.name.startsWith("Conjured")){
            return new ConjuredUpdater();
        }
        return registry.getOrDefault(item.name, new DefaultItemUpdater());
    }


}
