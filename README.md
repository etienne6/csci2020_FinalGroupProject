# Model Branch:

Worked on by:

* Etienne Caronan
* Stefan Cross

# Update (Mar 31)

Updates:

1. +chooseFirst() - decides player's turn based on speed and probability
2. -Attack attribute - deleted that because redundant
3. +Attack(player1, player2) - lets user decide what attack to use
4. +rando_attack(player1, player2) - randomly decides the attack for the user
5. Added some other accessor methods under Base.java file for HP and Defense
6. +Damage(Move move, Player player) - calculates damage done on player based on move


So, Battle simulation is getting close to being finished. Character
models and their respective moves still need to be rebalanced.

Still need to add dodge function