package com.addie.core.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class MilkyWayGatePlacerItem extends Item {

    public MilkyWayGatePlacerItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        if (!world.isClient && user instanceof ServerPlayerEntity serverPlayer) {

            MinecraftServer server = serverPlayer.getServer();
            if (server != null) {

                ServerCommandSource source = serverPlayer.getCommandSource()
                        .withSilent()
                        .withLevel(4);

                server.getCommandManager().executeWithPrefix(
                        source,
                        "execute at @s run function the-fabric-stargate-mod:summon_mw_gate"
                );
            }
        }

        return TypedActionResult.success(user.getStackInHand(hand), world.isClient());
    }
}