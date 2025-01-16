How To Play Our Game "Lurking Below"
Copy the `project.greenfoot.md` file and rename it to `project.greenfoot`

Controls: WASD to move, mouse to click buttons, another help screen is avaliable to view in the menu screen

Project Contributors: Martin Ma, Jamie Wang, Nicholas Kulybanycz



Used Data Structures:

1. CombatScreen.java uses an Arraylist for player hearts and another Arraylist for enemy hearts
2. All Enemies (Death Knight, Slime, Skeleton and Zombie) use atleast 5 array for storing image files for animations, these four enemies also use overrides to animate themselves, as there are subclasses of enemy.java
3. Enemy.java class uses overrides as well as it is a subclass of lifeform, which controls both the player character and enmeies
4. Gamescreen uses a Hashmap and an ArrayList, the Hashmap is used for creating and saving enemy positions, the Arraylist is used for the heart counter in the bottom left
5. Our InventoryChecker class uses a list to track what items have been added to your inventory
6. Lifeform uses a List to store all active character positions
7. Player similar to that of the enemies uses different String arrays to store images for animations
8. TileWorld, uses an ArrayList to help place doors when randomly generationg the rooms
9. TreasureChest class uses List to track what items could be pulled from the chest then transfered into the player's inventory. 
