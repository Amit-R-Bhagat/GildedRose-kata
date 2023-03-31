package com.gildedrose.updatableitem;

import com.gildedrose.Item;

public class BackstagePass extends UpdatableItem {
    public BackstagePass(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        if (getSellIn() <= 0) {
            setQuality(0);
        } else if (getSellIn() <= 5) {
            increaseQuality(3);
        } else if (getSellIn() <= 10) {
            increaseQuality(2);
        } else {
            increaseQuality();
        }
    }

    @Override
    protected void updateSellIn() {
        decreaseSellIn();
    }

    @Override
    protected void updateExpired() {
        setQuality(0);
    }
}