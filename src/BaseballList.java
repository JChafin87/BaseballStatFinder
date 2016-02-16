import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;


public class BaseballList  {
	
	public LinkedList<String[]> players = null;
	public LinkedList<String[]> stats;
	public String[] headers =  {"playerID","yearID","stint","teamID","lgID","G","AB","R","H","Doubles","Triples","HR","RBI","SB","CS","BB","SO","IBB","HBP","SH","SF","GIDP"};






	public BaseballList() {
		
	}
	
	public void readFile() {
		String fileName = "MasterCurrent.csv";
        String line = null;
        String parseBy = ",";
        LinkedList<String[]> testList = new LinkedList<String[]>();
        
        try {
            // Reads from events.dat and stores to EventList
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine();
            
            while((line = bufferedReader.readLine()) != null) {
            	String[] tempPlayer = line.split(parseBy);
            	testList.add(tempPlayer);

            	
            }
        bufferedReader.close();    
        }
       catch(FileNotFoundException ex) {
           System.out.println("Unable to open file '" + fileName + "'");                
       }
       catch(IOException ex) {
           System.out.println("Error reading file '"+ fileName + "'");
       }
        players = testList;
         
	}
	


	public void readStats(String s) {
		String fileName = "BattingCurrent.csv";
        String line = null;
        String parseBy = ",";
        LinkedList<String[]> testList = new LinkedList<String[]>();
        
        try {
            // Reads from events.dat and stores to EventList
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine();
            
            while((line = bufferedReader.readLine()) != null) {
            	String[] tempPlayer = line.split(parseBy);
            	if (tempPlayer[1].equals(s)) {
            		testList.add(tempPlayer);
            	}
            	

            	
            }
        bufferedReader.close();    
        }
       catch(FileNotFoundException ex) {
           System.out.println("Unable to open file '" + fileName + "'");                
       }
       catch(IOException ex) {
           System.out.println("Error reading file '"+ fileName + "'");
       }
        stats = testList;
         
	}
	
	
	public String[] findPlayer(String playerID) {
		String firstName = null;
		String lastName = null;
		String[] returnName = new String[2];
		
		for (int i = 0; i<players.size(); i++) {
			if (players.get(i)[0].equals(playerID)) {
				firstName = players.get(i)[2];
				lastName = players.get(i)[3];
			}
			
		}
		returnName[0] = firstName;
		returnName[1] = lastName;
		return returnName;
		
	}
	
	
	public LinkedList<String[]> findPlayers(float[] s) {
		int oper1 = (int) s[2];
		int oper2 = (int) s[5];
		int oper3 = (int) s[8];
		LinkedList<String[]> display = new LinkedList<String[]>();
		String actionString = Integer.toString(oper1)+Integer.toString(oper2)+Integer.toString(oper3);
		int index1 = (int) s[1]+5;
		int index2 = (int) s[4]+5;
		int index3 = (int) s[7]+5;
		float value1 = Float.valueOf(s[3]);
		float value2 = Float.valueOf(s[6]);
		float value3 = Float.valueOf(s[9]);
		switch (actionString) {
		case "000":
			for(int i = 0; i<stats.size(); i++) {
				
				if (Float.valueOf(stats.get(i)[index1]) <= value1 && Float.valueOf(stats.get(i)[index2]) <= value2 && Float.valueOf(stats.get(i)[index3]) <= value3) {
					display.add(stats.get(i));
				}
			}
			break;
		case "001":
			for(int i = 0; i<stats.size(); i++) {
				
				if (Float.valueOf(stats.get(i)[index1]) <= value1 && Float.valueOf(stats.get(i)[index2]) <= value2 && Float.valueOf(stats.get(i)[index3]) >= value3) {
					display.add(stats.get(i));
				}
			}
			break;
		case "010":
			for(int i = 0; i<stats.size(); i++) {
				
				if (Float.valueOf(stats.get(i)[index1]) <= value1 && Float.valueOf(stats.get(i)[index2]) >= value2 && Float.valueOf(stats.get(i)[index3]) <= value3) {
					display.add(stats.get(i));
				}
			}
			break;
		
		case "011":
			for(int i = 0; i<stats.size(); i++) {
				
				if (Float.valueOf(stats.get(i)[index1]) <= value1 && Float.valueOf(stats.get(i)[index2]) >= value2 && Float.valueOf(stats.get(i)[index3]) >= value3) {
					display.add(stats.get(i));
				}
			}
			break;
		case "100":
			
			for(int i = 0; i<stats.size(); i++) {
				
				if (Float.valueOf(stats.get(i)[index1]) >= value1 && Float.valueOf(stats.get(i)[index2]) <= value2 && Float.valueOf(stats.get(i)[index3]) <= value3) {
					display.add(stats.get(i));
				}
				
			}
			
			break;
		case "101":
			for(int i = 0; i<stats.size(); i++) {
				
				if (Float.valueOf(stats.get(i)[index1]) >= value1 && Float.valueOf(stats.get(i)[index2]) <= value2 && Float.valueOf(stats.get(i)[index3]) >= value3) {
					display.add(stats.get(i));
				}
			}
			break;
		case "110":
			for(int i = 0; i<stats.size(); i++) {
				
				if (Float.valueOf(stats.get(i)[index1]) >= value1 && Float.valueOf(stats.get(i)[index2]) >= value2 && Float.valueOf(stats.get(i)[index3]) <= value3) {
					display.add(stats.get(i));
				}
			}
			break;
		case "111":
			for(int i = 0; i<stats.size(); i++) {
				
				if (Float.valueOf(stats.get(i)[index1]) >= value1 && Float.valueOf(stats.get(i)[index2]) >= value2 && Float.valueOf(stats.get(i)[index3]) >= value3) {
					display.add(stats.get(i));
				}
			}
			break;
		}
		return display;
	}
	


	
	public static void main(String[] args) {
			
	}
}
