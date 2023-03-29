package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {
    @Test
    fun `should reduce the sellIn value by one after each day except Sulfuras`(){
        val items = listOf(NormalItem("Elixir", 5, 10))
        val app = GildedRose(items)

        app.updateItems()

        assertEquals(4, app.items[0].sellIn)
    }


    @Test
    fun `should decrease the quality by one if sellIn is positive except 'Sulfuras', 'Aged Brie' and 'Backstage passes'`(){
        val items = listOf(NormalItem("Elixir", 5, 10))
        val app = GildedRose(items)

        app.updateItems()

        assertEquals(9,app.items[0].quality)
    }

    @Test
    fun `should not decrease the quality as sellIn value decreases for Sulfuras`(){
        val items = listOf(LegendaryItem("Sulfuras", 5, 80))
        val app = GildedRose(items)

        app.updateItems()

        assertEquals(80, app.items[0].quality)
    }

    @Test
    fun `should increase the quality by one as sellIn value decrease for 'Aged Brie'`(){
        val items = listOf(SpecialItem("Aged Brie", 5, 10))
        val app = GildedRose(items)

        app.updateItems()

        assertEquals(11, app.items[0].quality)
    }

    @Test
    fun `should increase the quality by one if sellIn value is more than 10 for 'Backstage passes'`(){
        val items = listOf(SpecialItem("Backstage passes", 12, 10))
        val app = GildedRose(items)

        app.updateItems()

        assertEquals(11, app.items[0].quality)
    }

    @Test
    fun `should increase the quality by two for 'Backstage passes' when sellIn is not more than 10`(){
        val items = listOf(SpecialItem("Backstage passes", 10, 10))
        val app = GildedRose(items)

        app.updateItems()

        assertEquals(12, app.items[0].quality)
    }

    @Test
    fun `should increase the quality by three for 'Backstage passes' when sellIn is not more than 5`(){
        val items = listOf(SpecialItem("Backstage passes",5,10))
        val app = GildedRose(items)

        app.updateItems()

        assertEquals(13, app.items[0].quality)
    }

    @Test
    fun `should make the quality of 'Backstage passes' zero after the sellIn becomes zero`(){
        val items = listOf(SpecialItem("Backstage passes",0,10))
        val app = GildedRose(items)

        app.updateItems()

        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun `should never increase the quality of an item if it will go beyond 50`(){
        val items = listOf(SpecialItem("Backstage passes", 4, 48))
        val app = GildedRose(items)

        app.updateItems()

        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun `should decrease the quality of item by twice if the sellIn is less than 0`(){
        val items = listOf(NormalItem("Elixir", 0, 10))
        val app = GildedRose(items)

        app.updateItems()

        assertEquals(8, app.items[0].quality)
    }


}


