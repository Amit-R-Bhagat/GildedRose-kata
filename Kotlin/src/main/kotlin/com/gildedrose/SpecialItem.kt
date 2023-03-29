package com.gildedrose

class SpecialItem(name: String, sellIn: Int, quality: Int): Item(name, sellIn, quality) {
    override fun accept(itemQualityUpdater: ItemQualityUpdater) {
        itemQualityUpdater.update(this)
    }

}