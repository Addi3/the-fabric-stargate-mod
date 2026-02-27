# global function, applies to all gates

# Remove 7x7x7 area of barriers centered on gate
fill ~-3 ~0 ~-3 ~3 ~6 ~3 minecraft:air replace minecraft:barrier

# Kill the gate entity
kill @s

# checks for gate and gives placer item depending

execute if entity @e[type=the-fabric-stargate-mod:milkyway_stargate] run summon item ~ ~ ~ {Item:{id:"the-fabric-stargate-mod:milky_way_gate_placer",Count:1b}}