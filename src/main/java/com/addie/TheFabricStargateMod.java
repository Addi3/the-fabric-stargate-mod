package com.addie;

import com.addie.core.TheFabricStargateModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;

import static com.addie.core.TheFabricStargateModItems.MILKY_WAY_GATE_PLACER;

public class TheFabricStargateMod implements ModInitializer {
	public static final String MOD_ID = "the-fabric-stargate-mod";


	@Override
	public void onInitialize() {
		TheFabricStargateModItems.registerModItems();

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
			entries.add(MILKY_WAY_GATE_PLACER);
		});
	}
}