package com.gildedrose

class ItemQualityUpdater {
    fun update(item: NormalItem) {
        if (item.quality > 0) {
            item.quality -= 1
        }

        if (item.sellIn < 0 && item.quality > 0) {
            item.quality -= 1
        }
    }

    fun update(item: LegendaryItem) {

    }

    fun update(item: SpecialItem) {
        item.quality += 1

        if (item.name == "Backstage passes") {
            if (item.sellIn < 0) {
                item.quality = 0
            } else if (item.sellIn in 6..10) {
                item.quality += 1
            } else if (item.sellIn < 6) {
                item.quality += 2
            }
        }
    }
}