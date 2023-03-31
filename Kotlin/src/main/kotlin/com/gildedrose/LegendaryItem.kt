package com.gildedrose

class LegendaryItem(name: String, sellIn: Int, quality: Int): Item(name, sellIn, quality) {
    override fun updateWith(itemQualityUpdater: ItemQualityUpdater) {
    }

}