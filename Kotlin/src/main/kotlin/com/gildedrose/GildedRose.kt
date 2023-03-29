package com.gildedrose

class GildedRose(var items: List<Item>) {

    fun updateItems() {
        for (item in items) {
            updateItem(item)
        }
    }

    private fun updateItem(item: Item) {
        if (!isItemLegendary(item)) {
            item.sellIn = item.sellIn - 1
        }

        if (isItemNormal(item)) {
            if (item.quality > 0) {
                item.quality = item.quality - 1
            }

            if (item.sellIn < 0 && item.quality > 0) {
                item.quality = item.quality - 1
            }
        }

        if (isItemSpecial(item)) {
            item.quality = item.quality + 1
        }

        if (isItemBackstage(item)) {
            if (item.sellIn < 11) {
                item.quality = item.quality + 1
            }

            if (item.sellIn < 6) {
                item.quality = item.quality + 1
            }

            if (item.sellIn < 0) {
                item.quality = 0
            }

        }

        if (!isItemLegendary(item)) {
            item.quality = capQuantityAt(item.quality, 50)
        }

    }

    private fun isItemBackstage(item: Item) = item.name == SpecialItem.BACKSTAGE_PASSES.itemName

    private fun isItemNormal(item: Item) = !isItemSpecial(item) && !isItemLegendary(item)

    private fun isItemLegendary(item: Item) = item.name == LegendaryItem.SULFURAS.itemName

    private fun isItemSpecial(item: Item): Boolean {
        return (item.name == SpecialItem.AGED_BRIE.itemName || item.name == SpecialItem.BACKSTAGE_PASSES.itemName)
    }

    private fun capQuantityAt(value: Int, limit: Int): Int {
        if (value > limit) return limit
        return value
    }
}

