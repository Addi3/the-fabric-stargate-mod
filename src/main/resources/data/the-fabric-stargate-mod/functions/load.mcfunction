# Create the scoreboard objectives
scoreboard objectives add stargate dummy
scoreboard objectives add gate_1 dummy
scoreboard objectives add gate_2 dummy
scoreboard objectives add gate_3 dummy
scoreboard objectives add gate_4 dummy
scoreboard objectives add gate_5 dummy
scoreboard objectives add gate_6 dummy
scoreboard objectives add gate_7 dummy

# Set the constant 36 for modulus operations
scoreboard players set #36_const stargate 36

# Place the RNG armor stand
summon armor_stand ~ ~ ~ {Tags:["rng_source"],Rotation:[0f,0f],Invisible:1b,NoGravity:1b,Persistent:1b}