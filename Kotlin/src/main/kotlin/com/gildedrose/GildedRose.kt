package com.gildedrose

class GildedRose(var items: List<Item>) {
    private val itemQualityUpdater = ItemQualityUpdater()

    fun updateItems() {
        for (item in items) {
            updateItem(item)
        }
    }

    private fun updateItem(item: Item) {
        if (item.name != "Sulfuras") {
            item.sellIn -= 1
            item.updateWith(itemQualityUpdater)
            item.quality = capQuality(item)
        }
    }

    private fun capQuality(item: Item, limit: Int = QUANTITY_LIMIT): Int {
        if (item.quality > limit) return limit
        return item.quality
    }
}

