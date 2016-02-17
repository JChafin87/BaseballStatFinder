##Baseball Stat Finder

## Project Summary

Baseball Stat Finder is an application that searches through season statistics for every current Major Leauge Baseball player. The user selects a year to search through, and up to 3 stats to filter by. The application will generate a table based on those parameters. 

### Example:
  
  The user selects: 
  - Year = 2002
  - Games >= 50
  - Batting Avg >=.250
  - Home Runs <= 20
  
The program would return a table that only shows players that 1) played in at least 50 games, 2) had a batting average of at least .250 and 3)hit no more than 20 home runs in the 2002 season. Here is the table that would be shown: ![IMG1](http://i.imgur.com/3EY0ULt.png)




##Classes Documentation
BaseballStatFinder uses 3 created classes (2 GUIs and 1 logical). 
###PlayersTable
This is the GUI that displays the players passed from BasePlayerFinder.java


####Constructor

 	 PlayersTable(LinkedList<String[]> linkedList)
  
  Initializes window with a table that’s populated with a Linked List (# of rows in table) of String Arrays (stats for player)

####Attributes

private JPanel contentPane;

The JPanel that displays the result table.

private JTable table1;

the JTable that displays the data of tableStats.

public LinkedList<String[]> tableStats;

Contains the values to populate the resulting table.


Methods

Returns				Method Name

Void				opentPT(LinkedList<String[]> playerList)

A method to launch a new PlayersTable window from a separate JFrame.







