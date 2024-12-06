# RetroSpaceGamev2 - README

## Description

**RetroSpaceGamev2** is a retro-style space shooter game inspired by the classics of the 1980s. Players control a spaceship (represented by `P`) and must move left (`a`), right (`d`), or shoot (`w`) to destroy enemy ships (`E`) that move downward towards the player. The game ends when an enemy reaches the player’s row.

## Game Features
- **Player movement**: The player spaceship can move left and right using `a` and `d` keys.
- **Shooting**: The player can shoot upwards to destroy enemies with the `w` key.
- **Enemy movement**: Enemies randomly spawn at the top and move downwards each turn.
- **Win/Lose condition**: The game ends when the player destroys all enemies or when an enemy reaches the player.

---

## Technical Choices

1. **Grid Representation**:
   - A 2D array `g` of size `10x10` represents the game grid. Each element in the array can either contain a `.` (empty space), `P` (player), or `E` (enemy). The grid is initialized with empty spaces and then the player and enemies are placed in specific locations.
   
   ```java
   static String[][] g = new String[10][10]; // 10x10 grid for the game
   ```

2. **Player Positioning**:
   - The player's position is controlled by the variable `p`, which holds the current column of the player (`P`). Initially, the player starts in the middle of the grid (`p = 5`).
   - The player can move left or right by updating `p` with `a` (left) and `d` (right) keys. Movement is constrained within the grid bounds.
   
   ```java
   static int p = 5;  // Initial position of the player
   ```

3. **Enemy Placement**:
   - Enemies (`E`) are randomly placed at the top 5 rows of the grid when the game starts. The number of enemies is fixed at 3.
   - Each enemy is assigned a random position in the first 5 rows (`new Random().nextInt(5)`).
   
   ```java
   for (int i = 0; i < 3; i++) 
       g[new Random().nextInt(5)][new Random().nextInt(10)] = "E";
   ```

4. **Movement and Shooting**:
   - The player moves by updating `p` and modifying the grid to reflect the new player position. If the player moves left (`a`) or right (`d`), the grid is updated with the new position.
   - Shooting is handled by the `shoOt()` method, which checks all positions above the player for an enemy (`E`). If an enemy is found, it is destroyed by setting the grid position to `.` and a message is printed.
   
   ```java
   static void shoOt() {
       for (int i = 8; i >= 0; i--) {
           if (g[i][p] == "E") {
               g[i][p] = ".";
               System.out.println("ENEMY HIT!!!");
               return;
           }
       }
       System.out.println("NO HIT TRY AGAIN XD");
   }
   ```

5. **Enemy Movement**:
   - The enemies move down each turn by shifting their position one row downward. The grid is updated in the `enMove()` method.
   
   ```java
   static void enMove() {
       for (int i = 8; i >= 0; i--) {
           for (int j = 0; j < 10; j++) {
               if (g[i][j] == "E") {
                   g[i][j] = ".";
                   if (i + 1 < 10) {
                       g[i + 1][j] = "E";
                   }
               }
           }
       }
   }
   ```

6. **Game Over Check**:
   - The game checks if any enemy has reached the bottom row (row 9). If so, the game ends and the player loses. This check is performed by the `chk()` method.
   
   ```java
   static void chk() {
       for (int j = 0; j < 10; j++) {
           if (g[9][j] == "E") {
               go = false;
               System.out.println("YOU LOSE - BIG SAD");
               return;
           }
       }
   }
   ```

7. **Game Interface**:
   - The game interface is purely text-based, with ASCII art used to give the game a retro look and feel. The game prompts the player with instructions at the start and continuously updates the grid on each turn.
   - The game’s instructions and the initial ASCII art are printed in the console.

---

## How to Play

1. Run the program in a Java environment.
2. Use the following keys to control the game:
   - `a`: Move left
   - `d`: Move right
   - `w`: Shoot upward
3. Destroy all enemies before they reach your row (row 9). If an enemy reaches your row, you lose.

---

## Code Improvements and Limitations

### Improvements:
- The game could benefit from better enemy AI, like shooting back or varying their movement patterns.
- Implementing a score system and allowing the player to play multiple rounds would enhance the experience.
- Adding levels with increasing difficulty (more enemies, faster movements) would also be a nice touch.

### Limitations:
- The game is entirely text-based, with no graphics or sound.
- No clear indication of the number of enemies or player health.
- The game doesn't have a pause feature or difficulty settings.

---

## Conclusion

**RetroSpaceGamev2** is a fun, simple, and retro-style space shooter game implemented in Java. It serves as a good example of basic game logic, including player movement, enemy movement, shooting mechanics, and win/lose conditions using a text-based grid. Although it’s basic, it captures the spirit of old-school arcade games.

---
