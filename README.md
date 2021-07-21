
----------------------------------------------
---- Tic Tac Toe - With MiniMax algorithm ----
----------------------------------------------

Game for two players, X and O, who take turns marking the spaces in a 3×3 grid. The player who succeeds in placing three of their marks in a diagonal,
horizontal, or vertical row is the winner. It is a solved game with a forced draw assuming best play from both players.


About the project:

In this project you have few modes to choose.

In every mode you and your opponent starts with 0 points.
You can see them in the top - left corner.

In every mode you have two buttons:
1. Reset: 
 - Resets the current game ( clears the table ).
 - Keeps the points as it was.

2. Menu:
 - Goes back where you can choose if you want to play against other human or computer.
 - Resets all the points.

Modes:
1. Player vs Player:
 - In this mode you play against your friend.
 - Game counts points for your wins and wins of your opponent.
 - First game O's starts.
 - Player that lost the previous game starts.

2. Player vs Easy Computer:
 - In this mode you play against Easy Computer that places X's randomly on empty spots.
 - Game counts points for your wins and wins of your opponent.
 - First game O's starts.
 - Player that lost the previous game starts.

3. Player vs Hard Computer:
 - Here you can choose if you want to start with O's or let the Hard Computer start with his X's.
 - In this mode you play against Hard Computer that uses MiniMax algorytm ( about MiniMax algorithm later in the file ).
 - Game counts points for your wins and wins of your opponent.
 - When Reset button is clicked you can choose again if you want to start ( keeps all the points as it was ).


About MiniMax algorithm:

Minimax is a decision rule used in game theory for minimizing the possible loss for a worst case (maximum loss) scenario. When dealing with gains, it is referred to maximize the minimum gain. Originally formulated for n-player zero-sum game theory, covering both the cases where players take alternate moves and those where they make simultaneous moves.

Hard Computer looking for the best move for him throught all of the avaible spots on the table.
It counts all of the possibilities how the game may look in the future.
