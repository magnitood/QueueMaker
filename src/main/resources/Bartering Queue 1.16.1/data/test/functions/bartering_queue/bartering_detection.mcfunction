execute as @e[predicate=test:piglin_offhand_gold,type=piglin,nbt=!{IsBaby:1b}] run scoreboard players add @s Barter 1
execute as @e[type=piglin,predicate=test:piglin_offhand_gold] if score @s Barter matches 120 run scoreboard players add @e[type=piglin] Times 1
execute as @e[type=piglin,predicate=test:piglin_offhand_gold] if score @s Barter matches 120 run scoreboard players reset @s Barter