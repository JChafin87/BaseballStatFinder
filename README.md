**Baseball Stat Finder**


# Project Summary 


Baseball Stat Finder is an application that searches through season statistics for every current Major Leauge Baseball player. The user selects a year to search through, and up to 3 stats to filter by. The application will generate a table based on those parameters. 

**Example:**
  
  The user selects:   
  - Year = 2002
  - Games >= 50
  - Batting Avg >=.250
  - Home Runs <= 20
  
The program would return a table that only shows players that 1) played in at least 50 games, 2) had a batting average of at least .250 and 3)hit no more than 20 home runs in the 2002 season. Here is the table that would be shown: ![IMG1](http://i.imgur.com/3EY0ULt.png)
  
#Classes Documentation

BaseballStatFinder uses three created classes BaseballList, BasePlayerFinder and PlayersTable. The latter two are GUIs. 

----
###BaseballList
----

This is the class that stores the data from the input files "MasterCurrent.csv" and "BattingCurrent.csv". (For more information on these files, see the "Files" section of this README.) 

####Constructor

BaseballList()

_Creates an empty BaseballList. The attribute values will be set later via method calls._

####Attributes
| Attribute | Description|
| ------------- |:-------------:|
| public LinkedList \<String[]\> players     | A List of String Arrays, where each list entry is a player and the string array contains the player's name and unique ID. |
| public LinkedList\<String[]\> stats     | A List of String Arrays, where each String Array is a specific player's stats from a specific year.     | 

####Methods
| Returns | Method|
| ------------- |:-------------:|
| void     | **readFile()** |
|      |  _A method that reads all of the players’ name data from the input file “MasterCurrent.csv” and stores these values into the “players” attribute._  | 
| void     | **readStats**(String yearValue) |
|      |  _A method that reads the players’ stats from the input file “BattingCurrent.csv” and saves these values to the “stats” attribute. yearValue represents the year value of the stats you want to return. (i.e. if yearValue = “1997”, “stats” will be all entries where the year is 1997.)_  |
| String[]    | **findPlayer**(String playerID) |
|      |  _A method that returns a player’s name(first and last) by passing his unique playerID._  |
| LinkedList\<String[]\>     | **findPlayers**(float[] paramValues) |
|      |  _A method that returns a Linked List of player stats that match the paramValues. (See Class BasePlayerFinder for more info on “paramValues”)._  |


-----
###PlayersTable 

-----

This is the GUI that displays the players passed from BasePlayerFinder.java

####Constructor

PlayersTable(LinkedList<String[]> linkedList)

_Initializes window with a table that’s populated with a Linked List (# of rows in table) of String Arrays (stats for player)._


####Attributes

| Attribute | Description|
| ------------- |:-------------:|
| private JPanel contentPane      | The JPanel that displays the result table. |
| private JTable table1      | The JTable that displays the data of tableStats.      | 
| public LinkedList<String[]> tableStats | Contains the values to populate the resulting table.      |

####Methods

| Returns | Method|
| ------------- |:-------------:|
| void     | **opentPT**(LinkedList<String[]> playerList) |
|      |  _A method to launch a new PlayersTable window from a separate JFrame._  | 

---
###BasePlayerFinder 
---

This is the GUI where the user enters the parameters used to create the final PlayersTable. It is the main class of our application. It implements the class ActionListener.

####Constructor

public BasePlayerFinder()

Initializes our JFrame.

####Attributes

| Attribute | Description|
| ------------- |:-------------:|
| private JPanel contentPane      | The JPanel that displays the result table. |
| private JComboBox yearBox      | Selects the value of the year to populate table.      | 
| private JTextField param1Value | Gets the number value of our first stat to search.      |
| private JTextField param2Value      | Gets the number value of our second stat to search. |
| private JTextField param3Value      | Gets the number value of our third stat to search.      | 
| private JComboBox param1Index | Gets the first stat to search for (Example: Games Played)      |
| private JComboBox param2Index      | Gets the second stat to search for (Example: Games Played) |
| private JComboBox param3Index      | Gets the third stat to search for (Example: Games Played)     | 
|private JComboBox param1Compare | Gets the first operator for our serach (Example: \<= or \>=      |
| private JComboBox param2Compare     | Gets the second operator for our serach (Example: \<= or \>= |
| private JComboBox param3Compare      | Gets the third operator for our serach (Example: \<= or \>=      | 
| public float[] paramValues | An array of the values of all the other attributes. Used to find our final list.      |













