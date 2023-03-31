package com.gildedrose;

import com.gildedrose.updatableitem.*;

public class GildedRose {
    private final UpdatableItem[] items;

    public GildedRose(Item[] items) {
        this.items = createUpdatableItems(items);
    }

    private UpdatableItem[] createUpdatableItems(Item[] items) {
        return java.util.Arrays.stream(items)
                .map(this::createUpdatableItem)
                .toArray(UpdatableItem[]::new);
    }

    private UpdatableItem createUpdatableItem(Item item) {
        switch (item.getName().toLowerCase()) {
            case "aged brie":
                return new AgedBrie(item);
            case "backstage passes to a tafkal80etc concert":
                return new BackstagePass(item);
            case "sulfuras, hand of ragnaros":
                return new Sulfuras(item);
            default:
                return new CommonItem(item);
        }
    }

    public void updateQuality() {
        for (UpdatableItem item : items) {
            item.update();
        }
    }
}