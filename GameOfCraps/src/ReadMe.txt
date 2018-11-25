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
#add output related to when players receives awards.
#playerCurrentResult(). X

Awards class =
#Create award object. X
#Calculate what kind of awards that should be given, and to who. Y

Table class =
#welcomeToTable - welcome console-UI. Choose how many players that will play. Create array according to this. X
#welcomBackToTable - when back from game - functionality for printing results, awards, wiping results/awards, and quit game.
#importPlayer(Player player) - mock - imports player to the Table, adds into an array. X
#getPlayerArray() X
#getResultArray() 
#getAwardArray() 
#mergeArray() 
#currentResults() - loop resultArray and print players results. Y
#currentAwards() - loop awardsArray and print players awards. Y 
#wipeTable() - last
#gameFinished() - last

Game class:
#enterGame(allArraysArray(results,players,awards))
#beginRound() - the game itself - Y
- playerBet(Player player) - player places a bet for result of two dice-throws. X
- Dice should roll two times, for each player - result of dices only valid for current player.
- If player gets correct - can choose award. Also add '10' to total result. Also can place new bet, and roll dices again.
- Failing bet gives -1 result.
#rollDice() X
#checkValueOfDicesAgainstPlayerBets(). Y
#Add award object to array. Y
#Process awards for round. Y
#newPlayerJoins(Player player)
#Player leaves table - brings his/her awardsArray with him/herself. New player joins.
#ReturnToTable() - enough if one player wants to return.

Audience class =
#Audience can bet on who to win. - occurs immediately prior to round begins. 
#Audience can give Objects to the players, like awards. 

Additional implementations:
#add game version with money implementation, so players can choose to play with money. Also add currency exchange.

JustForFun class =
#Provide functionality for croupier to hack the game. The croupier pre-sets the values the dices will get. 
#If player is of age 100+ and wins three times in a row, has heartattack and dies, and is removed from game.


Gameflow - console UI =

#First welcome players to game.
-Ask how many players.
-Add the players to the Table(), one at a time.
-Start the game.

#After first round:
-Print results of round.
-Print current total results.
-Hand out awards.
-Ask if new player wants to join, or other player wants to leave.

#After round when one player wins:
-Print results.
-Hand out awards.

#When back to table:
-Provide choice for printing results/awards.
-Wipe all info, and System.out 'goodbye'.
