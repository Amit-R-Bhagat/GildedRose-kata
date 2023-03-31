package com.gildedrose.updatableitem;

import com.gildedrose.Item;

public class AgedBrie extends UpdatableItem {
    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        increaseQuality();
    }

    @Override
    protected void updateSellIn() {
        decreaseSellIn();
    }

    @Override
    protected void updateExpired() {
        increaseQuality();
    }
}