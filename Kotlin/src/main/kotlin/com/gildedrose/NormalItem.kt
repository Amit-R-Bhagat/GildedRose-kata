package com.gildedrose

class NormalItem(name: String, sellIn: Int, quality: Int): Item(name, sellIn, quality) {
    override fun accept(itemQualityUpdater: ItemQualityUpdater) {
        itemQualityUpdater.update(this)
    }

}