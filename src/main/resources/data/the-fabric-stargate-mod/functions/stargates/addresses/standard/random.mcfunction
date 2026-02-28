# Simple number generator using an armor stand

# Rotate the armor stand to get a new seed
execute as @e[tag=rng_source,limit=1] at @s run tp @s ~ ~ ~ ~5.7 ~

# Get its yaw as a random number (0-359)
execute as @e[tag=rng_source,limit=1] store result score #random_value stargate run data get entity @s Rotation[0]

# Return the value
scoreboard players get #random_value stargate