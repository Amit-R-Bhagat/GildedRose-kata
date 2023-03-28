package com.gildedrose

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        for (currItem in items) {
            if (currItem.name != "Aged Brie" && currItem.name != "Backstage passes") {
                if (currItem.quality > 0) {
                    if (currItem.name != "Sulfuras") {
                        currItem.quality = currItem.quality - 1
                    }
                }
            } else {
                if (currItem.quality < 50) {
                    currItem.quality = currItem.quality + 1

                    if (currItem.name == "Backstage passes") {
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

            if (currItem.name != "Sulfuras") {
                currItem.sellIn = currItem.sellIn - 1
            }

            if (currItem.sellIn < 0) {
                if (currItem.name != "Aged Brie") {
                    if (currItem.name != "Backstage passes") {
                        if (currItem.quality > 0) {
                            if (currItem.name != "Sulfuras") {
                                currItem.quality = currItem.quality - 1
                            }
                        }
                    } else {
                        currItem.quality = currItem.quality - currItem.quality
                    }
                } else {
                    if (currItem.quality < 50) {
                        currItem.quality = currItem.quality + 1
                    }
                }
            }
        }
    }

}

