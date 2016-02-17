**PlayersTable.java**

This is the GUI that displays the players passed from
BasePlayerFinder.java

**Constructor**

PlayersTable(LinkedList&lt;String\[\]&gt; linkedList)

*Initializes window with a table that’s populated with a Linked List (\#
of rows in table) of String Arrays (stats for player)*

**Attributes**

private JPanel contentPane;

*The JPanel that displays the result table.*

private JTable table1;

*the JTable that displays the data of tableStats.*

public LinkedList&lt;String\[\]&gt; tableStats;

*Contains the values to populate the resulting table.*

**Methods**

  ------------------------------------------------------------------------------------
  **Returns**   **Method Name**
  ------------- ----------------------------------------------------------------------
  Void          **opentPT**(LinkedList&lt;String\[\]&gt; playerList)
                
                A method to launch a new PlayersTable window from a separate JFrame.
  ------------------------------------------------------------------------------------
