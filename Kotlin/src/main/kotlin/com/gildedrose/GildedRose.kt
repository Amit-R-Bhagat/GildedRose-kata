package com.gildedrose

class GildedRose(var items: List<Item>) {

    fun update() {
        for (currItem in items) {
            if (isItemNormal(currItem)) {
                if (currItem.quality > 0) {
                    currItem.quality = currItem.quality - 1
                }
            }

            if(isItemSpecial(currItem)){
                currItem.quality = currItem.quality + 1
                if (currItem.name == SpecialItem.BACKSTAGE_PASSES.itemName) {
                    if (currItem.sellIn < 11) {
                        currItem.quality = currItem.quality + 1
                    }

                    if (currItem.sellIn < 6) {
                        currItem.quality = currItem.quality + 1
                    }

                }
                currItem.quality = capQuantityAt(currItem.quality, 50)
            }



            updateSellIn(currItem)

            if (currItem.sellIn < 0) {
                if (currItem.name != SpecialItem.AGED_BRIE.itemName) {
                    if (currItem.name != SpecialItem.BACKSTAGE_PASSES.itemName) {
                        if (currItem.quality > 0) {
                            if (currItem.name != "Sulfuras") {
                                currItem.quality = currItem.quality - 1
                            }
                        }
                    } else {
                        currItem.quality = 0
                    }
                } else {
                    if (currItem.name != LegendaryItem.SULFURAS.itemName) {
                        currItem.quality = currItem.quality + 1
                    }
                    currItem.quality = capQuantityAt(currItem.quality, 50)
                }
            }
        }
    }

    private fun isItemNormal(currItem: Item) = !isItemSpecial(currItem) && !isItemLegendary(currItem)

    private fun updateSellIn(currItem: Item) {
        if (currItem.name != "Sulfuras") {
            currItem.sellIn = currItem.sellIn - 1
        }
    }

    private fun isItemLegendary(currItem: Item) = currItem.name == LegendaryItem.SULFURAS.itemName

    private fun isItemSpecial(currItem: Item): Boolean {
        return (currItem.name == SpecialItem.AGED_BRIE.itemName || currItem.name == SpecialItem.BACKSTAGE_PASSES.itemName)
    }

    private fun capQuantityAt(value: Int, limit: Int): Int {
        if (value > limit) return limit
        return value
    }
}

