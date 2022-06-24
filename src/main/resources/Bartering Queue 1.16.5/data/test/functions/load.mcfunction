#execute as @p at @p if entity @p[tag=!Spawned] run tp @p 184 63 106
#tag @p add Spawned
#tag @p remove PS
scoreboard objectives add Barter dummy
scoreboard objectives add Times dummy