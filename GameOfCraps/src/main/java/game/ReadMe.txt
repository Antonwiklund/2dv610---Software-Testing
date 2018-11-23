'X' after a class or method, means that this functionality has now been implemented.
'x' after a class or method, means that this functionality is now the next to be implemented.

Classes:

Players class = 
#create object for each player that is going to join. X
#add output related to when players receives awards.
#playerCurrentResult(). X

Awards class =
#Award players a result after every round - which is added to Table.currentStandings().
#Give best players special prize(should be some kind of object).

Table class =
#welcomeToTable x - welcome console-UI. Choose how many players that will play. Create array according to this.
#importPlayer(Player player) x - mock - imports player to the Table, adds into an array.
#playerTurn() 
#playerBet() - player places a bet for result of two dice-throws. 
#rollDice() X
#currentStandings() - loop array and print players results.
#wipeTable() - last
#gameFinished() - last
#printFinalResult() - last
#newPlayerJoins(Player player) - can be used for bufferOverFlow

Audience class =
#Audience can bet on who to win.

Additional implementations:
#Add choice for playing with Real-time betting(freeze game until bet entered for player who wants to)
#Various multipliers - add money implementation, so players can choose to play with money. Also add currency exchange.
#If player gets certain result, player's turn is extended.

JustForFun class =
#Provide functionality for croupier to hack the game. The croupier pre-sets the values the dices will get. 
#Hackers enter system to make use of weak points. Steals the awards, and afterwards freezes the system for 10 seconds to get away.
#Police chase hackers, player gets choice to roll dice and guess number. If correct number is guessed, hackers are caught and awards returned. If wrong system.exit().
#Harden the system-flaw that allows robbing to occur. Stop bufferoverflow from being possible.
#If player is of age 100+ and wins three times in a row, has heartattack and dies, and is removed from game.


Gameflow - console UI =

#First welcome players to game.
-Ask how many players.
-Add the players to the Table(), one at a time.

#After first round:
-Print results of round.
-Print current total results.
-Hand out awards.
-Ask if new player wants to join, or other player wants to leave.

#After round when one player wins:
-Print results.
-Hand out awards.
-Wipe all info, and System.out 'goodbye'.
