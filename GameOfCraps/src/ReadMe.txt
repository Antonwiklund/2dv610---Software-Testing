'X' after a class or method, means that this functionality has now been implemented.
'Y' after a class or method, means that this functionality is currently being worked on/planned, in order to be implemented.

Before program complete(finish last):
-Separate test-program from real program. Real program should have private methods.
-Add complete javaDoc.
-Make sure that various encapsulation is ok.
-Make sure that absolutely no dependencies exists between classes while they are being tested.
-Add main method for the real game.
-Add smoke-tests, and also other kinds of tests.

Classes:

Players class = 
#create object for each player that is going to join. X
#add output related to when players receives awards. Y
#playerCurrentResult(). X
#class for adding the awards objects to an array which each player has.
#Player leaves table - brings awards with him/herself. New player joins.

Awards class =
#Create award object. Y
#Add award object to array. Y
#Calculate what kind of awards that should be given, and to who.

Table class =
#welcomeToTable - welcome console-UI. Choose how many players that will play. Create array according to this. X
#importPlayer(Player player) - mock - imports player to the Table, adds into an array. X
#getPlayerArray() X
#beginTurn() - the game itself - Y
#playerBet(Player player) - player places a bet for result of two dice-throws. X
#rollDice() X
#Provide players with a result after every round - which is added to a resultArray.
#currentStandings() - loop resultArray and print players results. Y
#process awards for round.
#newPlayerJoins(Player player) 
#wipeTable() - last
#gameFinished() - last
#printFinalResult() - last

Audience class =
#Audience can bet on who to win. - occurs immediately prior to round begins. 
#Audience can give Objects to the players, like awards. 

Additional implementations:
#Add choice for playing with Real-time betting(freeze game until bet entered for player who wants to)
#Various multipliers - add money implementation, so players can choose to play with money. Also add currency exchange.
#If player gets certain result, player's turn is extended.

JustForFun class =
#Provide functionality for croupier to hack the game. The croupier pre-sets the values the dices will get. 
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
