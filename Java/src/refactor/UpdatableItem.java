package com.gildedrose.updatableitem;

import com.gildedrose.Item;

public abstract class UpdatableItem {
    private final Item item;

    public UpdatableItem(Item item) {
        this.item = item;
    }

    public void update() {
        updateQuality();
        updateSellIn();
        if (getSellIn() < 0) {
            updateExpired();
        }
    }

    protected abstract void updateQuality();

    protected abstract void updateSellIn();

    protected abstract void updateExpired();

    protected int getQuality() {
        return item.getQuality();
    }

    protected void setQuality(int quality) {
        item.setQuality(quality);
    }

    protected void increaseQuality() {
        if (getQuality() < 50) {
            setQuality(getQuality() + 1);
        }
    }

    protected void increaseQuality(int amount) {
        if (getQuality() + amount <= 50) {
            setQuality(getQuality() + amount);
        } else {
            setQuality(50);
        }
    }

    protected void decreaseQuality() {
        if (getQuality() > 0) {
            setQuality(getQuality() - 1);
        }
    }

    protected void decreaseSellIn() {
        item.sellIn--;
    }

    protected int getSellIn() {
        return item.getSellIn();
    }
}