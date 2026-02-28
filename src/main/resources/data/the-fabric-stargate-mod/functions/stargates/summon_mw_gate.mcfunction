# Summon stargate centered on the block the player is standing on
execute at @p align xyz run summon the-fabric-stargate-mod:milkyway_stargate ~0.5 ~ ~0.5

# Generate and assign a random 7-character address to the newly spawned gate
execute as @e[type=the-fabric-stargate-mod:milkyway_stargate,sort=nearest,limit=1] run function the-fabric-stargate-mod:stargates/addresses/standard/assign_address

# No North cus of default spawn rotation

# Rotate East
execute as @e[type=the-fabric-stargate-mod:milkyway_stargate,sort=nearest,limit=1] at @p if entity @p[y_rotation=-134..-45] align xyz run tp @s ~0.5 ~ ~0.5 90 0

# Rotate South
execute as @e[type=the-fabric-stargate-mod:milkyway_stargate,sort=nearest,limit=1] at @p if entity @p[y_rotation=-44..44] align xyz run tp @s ~0.5 ~ ~0.5 -180 0

# Rotate West
execute as @e[type=the-fabric-stargate-mod:milkyway_stargate,sort=nearest,limit=1] at @p if entity @p[y_rotation=45..134] align xyz run tp @s ~0.5 ~ ~0.5 -90 0

# North/South Orientation
execute as @e[type=the-fabric-stargate-mod:milkyway_stargate,sort=nearest,limit=1] at @s if data entity @s {Yaw:0.0f} run place template the-fabric-stargate-mod:ns_hitbox ~-3 ~ ~
execute as @e[type=the-fabric-stargate-mod:milkyway_stargate,sort=nearest,limit=1] at @s if data entity @s {Yaw:-180.0f} run place template the-fabric-stargate-mod:ns_hitbox ~-3 ~ ~

# East/West Orientation
execute as @e[type=the-fabric-stargate-mod:milkyway_stargate,sort=nearest,limit=1] at @s if data entity @s {Yaw:90.0f} run place template the-fabric-stargate-mod:ew_hitbox ~ ~ ~-3
execute as @e[type=the-fabric-stargate-mod:milkyway_stargate,sort=nearest,limit=1] at @s if data entity @s {Yaw:-90.0f} run place template the-fabric-stargate-mod:ew_hitbox ~ ~ ~-3
