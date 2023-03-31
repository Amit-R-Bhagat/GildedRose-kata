package com.gildedrose.updatableitem;

import com.gildedrose.Item;

public class CommonItem extends UpdatableItem {
    public CommonItem(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        decreaseQuality();
        if (getSellIn() < 0) {
            decreaseQuality();
        }
    }

    @Override
    protected void updateSellIn() {
        decreaseSellIn();
    }

    @Override
    protected void updateExpired() {
        decreaseQuality();
    }
}