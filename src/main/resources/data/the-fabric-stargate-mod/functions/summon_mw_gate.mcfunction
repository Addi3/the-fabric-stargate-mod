# Summon targate centered on the block the player is standing on
execute at @p align xyz run summon the-fabric-stargate-mod:milkyway_stargate ~0.5 ~ ~0.5

# Rotate North (yaw 135..-135)
execute as @e[type=the-fabric-stargate-mod:milkyway_stargate,sort=nearest,limit=1] at @p if entity @p[y_rotation=135..-135] align xyz run tp @s ~0.5 ~ ~0.5 0 0

# Rotate East (yaw -45..-134)
execute as @e[type=the-fabric-stargate-mod:milkyway_stargate,sort=nearest,limit=1] at @p align xyz run tp @s ~0.5 ~ ~0.5 90 0

# Rotate South (yaw -44..44)
execute as @e[type=the-fabric-stargate-mod:milkyway_stargate,sort=nearest,limit=1] at @p if entity @p[y_rotation=-44..44] align xyz run tp @s ~0.5 ~ ~0.5 -180 0

# Rotate West (yaw 45..134)
execute as @e[type=the-fabric-stargate-mod:milkyway_stargate,sort=nearest,limit=1] at @p if entity @p[y_rotation=45..134] align xyz run tp @s ~0.5 ~ ~0.5 -90 0

# TODO: add summon item and spawn it at that facing the player and add "block collision" (use barriers that place only if air)