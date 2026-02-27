package com.addie.core;

import com.addie.TheFabricStargateMod;
import com.addie.core.items.MilkyWayGatePlacerItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class TheFabricStargateModItems {

    public static Item register(Item item, String id) {
        return Registry.register(
                Registries.ITEM,
                new Identifier(TheFabricStargateMod.MOD_ID, id),
                item
        );
    }

    public static final Item MILKY_WAY_GATE_PLACER = register(
            new MilkyWayGatePlacerItem(new Item.Settings().maxCount(1)),
            "milky_way_gate_placer"
    );

    public static void registerModItems() {
    }
}