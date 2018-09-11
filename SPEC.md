# Realm of the Mad Tom - Spec Writeup

## Objectives and story
The ultimate objective of the game is to find Tom Kelliher, a poor computer science teacher from a small liberal arts college that was trying to live his totally normal life with his weird sense of humor, and defeat him with a level of `42` or higher and with a `Chocolate` class weapon (bar, stick, kiss, bunny, etc). The story says that Tom was possessed by the greater Mad God and gave him unimaginable powers which Tom uses just to force college students to endure his low level  of humor (`-42`).

## Basic dungeon gameplay
The player spawns in the dungeon (a 3 x 3 grid) and placed in the upper left-hand corner. Monsters will randomly generate in other areas of the grid ("rooms") and transfer locations at any given point. Rooms will contain doors that allow access to other rooms based upon their position in the dungeon. Loot will also randomly generate in the rooms; items can include weapons, healing potions, etc.

## Main classes
- `Player`
- `Item`
- `Dungeon`
- `Room`
- `Mob`