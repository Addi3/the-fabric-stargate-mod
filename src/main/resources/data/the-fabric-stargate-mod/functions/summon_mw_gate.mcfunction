# Summon targate centered on the block the player is standing on
execute at @p align xyz run summon the-fabric-stargate-mod:milkyway_stargate ~0.5 ~ ~0.5

# No North cus of default spawn rotation

# Rotate East (yaw -45..-134)
execute as @e[type=the-fabric-stargate-mod:milkyway_stargate,sort=nearest,limit=1] at @p if entity @p[y_rotation=-134..-45] align xyz run tp @s ~0.5 ~ ~0.5 90 0

# Rotate South (yaw -44..44)
execute as @e[type=the-fabric-stargate-mod:milkyway_stargate,sort=nearest,limit=1] at @p if entity @p[y_rotation=-44..44] align xyz run tp @s ~0.5 ~ ~0.5 -180 0

# Rotate West (yaw 45..134)
execute as @e[type=the-fabric-stargate-mod:milkyway_stargate,sort=nearest,limit=1] at @p if entity @p[y_rotation=45..134] align xyz run tp @s ~0.5 ~ ~0.5 -90 0

# TODO: add summon item and spawn it facing the player and add "block collision" (use barriers that place only if air) also need way to kill / break gate