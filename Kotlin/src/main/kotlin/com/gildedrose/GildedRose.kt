package com.gildedrose

class GildedRose(var items: List<Item>) {

    fun updateItems() {
        for (item in items) {
            updateItem(item)
        }
    }

    private fun updateItem(item: Item) {
        if (isItemNotLegendary(item)) {
            item.sellIn -= 1
        }

        if (isItemNormal(item)) {
            if (item.quality > 0) {
                item.quality -= 1
            }

            if (item.sellIn < 0 && item.quality > 0) {
                item.quality -= 1
            }
        }

        if (isItemSpecial(item)) {
            item.quality += 1
        }

        if (isItemBackstage(item)) {
            if (item.sellIn < 0) {
                item.quality = 0
            }else if (item.sellIn in 6..10) {
                item.quality += 1
            }else if (item.sellIn < 6) {
                item.quality += 2
            }
        }

        if (isItemNotLegendary(item)) {
            item.quality = capQuality(item)
        }

    }

    private fun isItemBackstage(item: Item) = item.name == SpecialItem.BACKSTAGE_PASSES.itemName

    private fun isItemNormal(item: Item) = !isItemSpecial(item) && isItemNotLegendary(item)

    private fun isItemNotLegendary(item: Item) = item.name != LegendaryItem.SULFURAS.itemName

    private fun isItemSpecial(item: Item): Boolean {
        return (item.name == SpecialItem.AGED_BRIE.itemName || item.name == SpecialItem.BACKSTAGE_PASSES.itemName)
    }

    private fun capQuality(item: Item, limit: Int = QUANTITY_LIMIT): Int {
        if (item.quality > limit) return limit
        return item.quality
    }
}

