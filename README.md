# Krogg The DESTROYER
**The contributors of this project are:**

_Etienne Caronan_ - https://github.com/etienne6 - Battle Simulation

_Stefan Cross_ - https://github.com/sheldoncross - Battle Simulation and Refactoring

_Mir Afgan Talpur_ - https://github.com/MirAfganTalpur - UI & File I/O

_Rolando Agullano_ - https://github.com/agullanojr - Networking and File I/O


This is a turn based game application that features 3 - main characters that the player can use: Krogg, Linda, and Glen.

There is only one gameplay option which is single player where the player faces a wave of bosses.
The game is over once the player defeats the final boss.

#Characters

Each character is classified into one of the 3 classes: Knight, Healer, and Tank.

Krogg is a Knight that has high damage and speed but has low defense.

Linda is a Healer that has low damage and medium defense but has a high HP and the best healing potions

Glen is a Tank, he has the highest defense and health but this is offset by his low speed and attack

Also, each character has 4 attributes that define them:

1. Speed - How fast a character is, in gameplay, speed helps determine which character moves first.
2. HP - How much health a character has, basically their lifeline.
3. Dodge - Is an attribute that calculates of a character avoiding an attack.
4. Defense - Is an attribute correlated to HP, it is essentially another health bar for a character.
#Items and Moves

Items - each character has 3 item attributes that pertain to their classes. The items that each
character has helps the player regain their health or defense.

Moves - each character has 3 moves in their movesets. The strength of each moveset is based
on the character's class.

#Gameplay

The game is turn-based. However, whoever makes the move is based on a character's speed. We made it so
that we calculated the probability of character making a turn based on their speed. The higher the speed, the
higher the chance of making the first move. If speed is the same, then the next turn is based solely on a randomizer.

In a battle, each character has 2 options when it's their turn: either attack the enemy or use an item to restore
health or defense. The battle ends once one of the character's HP drops to zero.

#Login / Save and Open

This game supports this functionality. It lets the user login with their respective username and password.
Each login information is stored in a directory. Also, under each user login, a directory is made
to store the user's files.

The user can save and open their game files. Each game file contains the information of the user's last (saved) battle, it contains the user's character stats and even their enemy's stats. All save files are stored
under their login directory.

# Recommendations
It's highly recommended that you play this game with sound and also, download the font file in order to get the most out of this game! (available in the src/fonts/ folder!)

# How to Run
In order to run, pull repository, open files on IntelliJ. Run MainServer (under src/sample/network). Click the start button on the server. Then, run the Main java file (under src/sample). 
You can save the current status of the game as you go along under the file menu while playing a game. You can leave and pick back up here
or if you die/want to go back to this save point, just use the Open option under the file menu in game. This will restore that game completely. However, you
must be logged into the same account that that save file was created under in order to access that saved game.

Have fun! 
