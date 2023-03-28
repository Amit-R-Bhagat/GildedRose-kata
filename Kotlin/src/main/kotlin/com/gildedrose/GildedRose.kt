package com.gildedrose

class GildedRose(var items: List<Item>) {

    fun update() {
        for (currItem in items) {
            if (isItemSpecial(currItem)) {
                if (currItem.quality > 0) {
                    if (isItemLegendary(currItem)) {
                        currItem.quality = currItem.quality - 1
                    }
                }
            } else {
                if (currItem.quality < 50) {
                    currItem.quality = currItem.quality + 1

                    if (currItem.name == SpecialItem.BACKSTAGE_PASSES.itemName) {
                        if (currItem.sellIn < 11) {
                            if (currItem.quality < 50) {
                                currItem.quality = currItem.quality + 1
                            }
                        }

                        if (currItem.sellIn < 6) {
                            if (currItem.quality < 50) {
                                currItem.quality = currItem.quality + 1
                            }
                        }
                    }
                }
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
                    if (currItem.quality < 50) {
                        currItem.quality = currItem.quality + 1
                    }
                }
            }
        }
    }

    private fun updateSellIn(currItem: Item) {
        if (currItem.name != "Sulfuras") {
            currItem.sellIn = currItem.sellIn - 1
        }
    }

    private fun isItemLegendary(currItem: Item) = currItem.name != LegendaryItem.SULFURAS.itemName

    private fun isItemSpecial(currItem: Item): Boolean{
        return (currItem.name != SpecialItem.AGED_BRIE.itemName && currItem.name != SpecialItem.BACKSTAGE_PASSES.itemName)
    }
}

