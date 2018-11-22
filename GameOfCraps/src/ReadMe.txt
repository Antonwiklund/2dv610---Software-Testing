Game of Craps

Classes:

Players class = 
#create object for each player that is going to join. Insert players into array. Make sure array can be bufferoverflowed.
#add details for players - can't play unless can identify.

JustForFun class =
#Provide functionality for croupier to hack the game. The croupier pre-sets the values the dice's will get. 
#Hackers enter system to make use of weak points. Steals the awards, and afterwards freezes the system for 10 seconds to get away.
#Police chase hackers, player gets choice to roll dice and guess number. If correct number is guessed, hackers are caught and awards returned. If wrong system.exit().
#Harden the system-flaw that allows robbing to occur. Stop bufferoverflow from being possible.
#If player is of age 100+ and wins three times in a row, has heartattack and dies, and is removed from game.

Awards class =
#Award players a result after every round - which is added to Table.currentStandings().
#Give best players special prize.

Table class =
#importPlayers().
#playerTurn().
#playerBet()
#rollDice().
#currentStandings().
#wipeTable()
#gameFinished()
#printFinalResult()
#newPlayerJoins() - can be used for bufferOverFlow

Audience class =
#Audience can bet on who to win.


Additional implementations:
#Add choice for playing with Real-time betting(delay between dicethrows)
#Game is not in real life, but played via computer. Each player's input is hid from other players - encapsulate so only player can access.
