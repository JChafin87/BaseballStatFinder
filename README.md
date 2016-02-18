**Baseball Stat Finder**


# Project Summary 


Baseball Stat Finder is an application that searches through season statistics for every current Major League Baseball player. The user selects a year to search through, and up to 3 stats to filter by. The application will generate a table based on those parameters. 

**Example:**
  
  The user selects:   
  - Year = 2002
  - Games >= 50
  - Batting Avg >=.250
  - Home Runs <= 20
  
The program would return a table that only shows players that 1) played in at least 50 games, 2) had a batting average of at least .250 and 3)hit no more than 20 home runs in the 2002 season. Here is the table that would be shown: 

![IMG1](http://i.imgur.com/3EY0ULt.png)
 
.

#Running the Program
There are multiple ways to access this program. It can be compiled and ran with any Java IDE, but since I created the project using Eclipse, I will explain how to run the program through Eclipse. Feel free to use any Java IDE or compiler you wish.

1. [Download Eclipse](http://www.eclipse.org/downloads/packages/release/Kepler/SR2) and install it.

2. Download the git repository as a .zip file and extract it to your system.

3. Open Eclipse and select File-\>Import-\>General-\>Existing Projects into WorkSpace. Click Next, then click Browse for root directory and locate your extracted BaseballStatFinder-master. Click Next and then Finish. 

4. Click 'Run' on the toolbar to launch the application.

.

#Classes Documentation#

BaseballStatFinder uses three created classes: BaseballList, BasePlayerFinder and PlayersTable. The latter two are GUIs. 

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
|      |  _A method that reads the players’ stats from the input file “BattingCurrent.csv” and saves these values to the “stats” attribute. yearValue represents the year of the stats you want to return. (i.e. if yearValue = “1997”, “stats” will be all entries where the year is 1997.)_  |
| String[]    | **findPlayer**(String playerID) |
|      |  _A method that returns a player’s name(first and last) by passing his unique playerID._  |
| LinkedList\<String[]\>     | **findPlayers**(float[] paramValues) |
|      |  _A method that returns a Linked List of player stats that match the paramValues. (See Class BasePlayerFinder for more info on “paramValues”)._  |

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
| private JPanel contentPane      | The JPanel that allows the user to select the parameters for the final table . |
| private JComboBox yearBox      | Selects the year to search values from.      | 
| private JTextField param1Value | Gets the number value of our first stat to search.      |
| private JTextField param2Value      | Gets the number value of our second stat to search. |
| private JTextField param3Value      | Gets the number value of our third stat to search.      | 
| private JComboBox param1Index | Gets the first stat to search for (Example: Games Played).      |
| private JComboBox param2Index      | Gets the second stat to search for (Example: Games Played). |
| private JComboBox param3Index      | Gets the third stat to search for (Example: Games Played).     | 
|private JComboBox param1Compare | Gets the first operator for our search (Example: \<= or \>= ).     |
| private JComboBox param2Compare     | Gets the second operator for our search (Example: \<= or \>=). |
| private JComboBox param3Compare      | Gets the third operator for our search (Example: \<= or \>= ) .    | 
| public float[] paramValues | An array of the values of all the JComboBoxes. Passed to BaseballList's findPlayers() function to generate our final dataset.      |
| private JButton generateButton | Button that passes the yearBox value into a new BaseballList(yearBox). Creates a LinkedList\<String[]\> that utilizes BaseballList.findPlayers() and creates a PlayersTable from the created LinkedList.      |

####Methods

| Returns | Method|
| ------------- |:-------------:|
| void     | **actionPerformed**(ActionEvent e) |
|      |  _Overrides method from ActionListener. Captures user's action on the frame's components and saves the values they choose into paramValues._ | 

-----
###PlayersTable 

-----

This is the GUI that displays the players passed from BasePlayerFinder.

####Constructor

PlayersTable(LinkedList<String[]> linkedList)

_Initializes window with a table that’s populated with a LinkedList (number of rows in table) of String Arrays (stats for player/number of columns)._


####Attributes

| Attribute | Description|
| ------------- |:-------------:|
| private JPanel contentPane      | The JPanel that displays the result table. |
| private JTable table1      | The JTable that displays the data of tableStats.      | 
| public LinkedList<String[]> tableStats | Contains the values to populate the resulting table.      |

####Methods

| Returns | Method|
| ------------- |:-------------:|
| void     | **opentPT**(LinkedList/<String[]/> playerList) |
|      |  _A method to launch a new PlayersTable window from a separate JFrame._  | 



.

#Files

Baseball Stat Finder uses two input files, "MasterCurrent.csv" and "MasterBatting.csv".
These files are raw data of player information and batting statistics respectively.  This section will give an explanation of what data is contained.

---
###MasterCurrent
---
There is some data in this file that isn't accessed by this application. It is retained in case it is implemented at a later date.

| Attribute | Description|
| ------------- |:-------------:|
| playerID    | A unique value for each player. Is used as our primary key. |
| birthYear     |  Player's year of birth. (not used) | 
| nameFirst     | Player's first name. |
| nameLast     |  Player's last name. | 
| weight     | Player's weight. (not used) |
| height     |  Player's height. (not used) | 
| bats     | Side of the plate that the player bats from. (not used) |
| throws     |  Player's throwing hand. (not used)| 
| debut     | Date of player's first MLB game. (not used)|
| finalGame     |  Date of player's final MLB game. (not used) | 

---
###BattingCurrent
---

| Attribute | Description|
| ------------- |:-------------:|
| playerID    | A unique value for each player. Is used as our primary key. |
| yearID     |  The year that the stats occurred. | 
| stint    | A Number representing how many times a player has been traded and traded back to this teamID. (not used/to delete)|
| teamID     |  ID of the player's team. | 
| lgID     | ID of the player's league. |
| G    |  Number of games played in this season. | 
| AB     | Number of At Bats in this season. |
| R     |  Number of Runs scored in this season. | 
| H     | Number of Hits recorded in this season. |
| 2B    |  Number of Doubles recorded in this season. | 
| 3B   | Number of Triples recorded in this season. |
| HR     |  Number of Home Runs hit in this season. | 
| RBI     | Number of Runs Batted In for this season. |
| SB    |  Number of Stolen Bases recorded in this season. | 
| CS     | Number of times Caught Stealing in this season. |
| BB    |  Number of walks recorded in this season. | 
| SO    | Number of Strike Outs suffered in this season. |
| IBB     |  Number of intentional walks recorded in this season.  | 
| HBP    | Number of times a player was Hit By a Pitch in this season. |
| SH    |  Number of Sacrifice Hits recorded in this season. |
| SF    |  Number of Sacrifice Flies recorded in this season. |
| GIDP   | Number of double plays grounded into this season. |
| BA   |  Total Batting Average recorded in this season. |
| SLG   |  Total Slugging Percentage recorded this season. |	

#Challenges

The major design challenge for this application was dealing with the user's operator choice (\<= or \>=). Since operators aren't data types in Java, a bit of creativity was needed. With three paramater options and two options for each operator, "/<=" was stored as "0" and "\>=" was stored as "1". A switch case was then used to obtain the correct data, such as "000" if all operators were "\<=" or "111" if all operators were "\>=".

#Current Problems/Future Implementation

The data from the input files is currently being read as String Arrays. This creates problems when sorting the final table by integer values. A new class needs to be created to hold the varying types of data received from the input files.

The data in the input file is a subset of data of every MLB player in history. "Current Players" was defined by players who's "finalGame" occurred in 2014. However, this doesn't take into account current players who missed the 2014 season due to injury/suspension. Unfortunately, there doesn't appear to be any attribute in the dataset that could alleviate this problem.

#Credits

Thank you to Sean Lahman for supplying the amazing data. The dataset used in this application is a subset of data that can be found by [visiting Sean Lahman's site](http://www.seanlahman.com/baseball-archive/statistics/).
