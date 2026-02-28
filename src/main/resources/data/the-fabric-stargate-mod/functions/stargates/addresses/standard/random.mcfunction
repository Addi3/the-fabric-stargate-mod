# Simple pseudo-random number generator using an armor stand
# You need to place this armor stand once in your world:
# summon armor_stand ~ ~ ~ {Tags:["rng_source"],Rotation:[0f,0f],Invisible:1b,NoGravity:1b,Persistent:1b}

# Rotate the armor stand to get a new seed
execute as @e[tag=rng_source,limit=1] at @s run tp @s ~ ~ ~ ~5.7 ~

# Get its yaw as a random number (0-359)
execute as @e[tag=rng_source,limit=1] store result score #random_value stargate run data get entity @s Rotation[0]

# Return the value
scoreboard players get #random_value stargate