package model.database;

//The required package in order to use such databases
import java.sql.*;
import java.util.*;

public abstract class ManageDB {

	private final static String url = "jdbc:mysql://localhost/lorannmap?autoReconnect=true&useSSL=false";
	private final static String user = "root";
	private final static String password = "";
	private static Connection connection = null;
	private static CallableStatement stmt;
	private static String theMapString;
	private static int wantedMapID = 0;
	private static int lengthMapData;
	private static int nbrLines = 1;
	private static int nbrColumns = 1;
	private static int tableLevelData[][];

	//Getters and setters
	public static Connection getterConnection(){
		return connection;
	}
	public static int getNbrLines() {
		return nbrLines;
	}
	public static int getNbrColumns() {
		return nbrColumns;
	}
	public static int[][] getTableLevelData() {
		return tableLevelData;
	}
	public static String getTheMapString(){
		return theMapString;
	}
	public static void setTheMapString(String theMapString){
		ManageDB.theMapString = theMapString;
	}

	public static void connectToDataBase(){
		
	      //Make sure that our Driver is placed properly in our Path
	      try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}

	      //Create the link between our application and database
	      System.out.println("Connecting Lorann code to DataBase...");
	      try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	
	public static String extractMapData(){
		
	      //Prepare the statement
	      System.out.println("Creating statement...");
	      try {
			stmt = connection.prepareCall("{call get_map_data(?, ?)}");

	      //Set the parameters for the statement
	      stmt.setInt(1, wantedMapID);
	      stmt.registerOutParameter(2, Types.VARCHAR);
	      
	      //Actually execute the statement, thus calling it in our DataBase
	      stmt.execute();
	      
	      //Stock the result of our procedure in a java variable
	      theMapString = stmt.getString(2);
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
	      System.out.println("\nHere's the map data : " + theMapString);
		  lengthMapData = theMapString.length();
	      return theMapString;
	}
	
	public static void closeAndCleanConnection(){
		
		try{			  
		      //Clean-up our DataBase environment to ensure future uses will run smoothly
		      stmt.close();
		      connection.close();
		      }catch(SQLException sqle){
		      //Handle errors from the Driver position
		      sqle.printStackTrace();
		   }catch(Exception e){
		      //Handle errors from Class.forName initialization
		      e.printStackTrace();
		   }finally{
		      //Final clean-up
		      try{
		         if(connection!=null)
		            connection.close();
		      }catch(SQLException sqle){
		         sqle.printStackTrace();
		      }
		   }
		   System.out.println("Cleaning the DataBase and connectors : check");
	}
	
	public static void analyzeData(){
		
		//for each character in the Map String
		for (int i = 0; i < lengthMapData; i++){
			
			//if it's a comma, it means we add another line
			if (theMapString.substring(i, i+1).equals(",")){
				nbrLines = nbrLines + 1;
			}
			else {
				nbrColumns = nbrColumns + 1;
			}
		}
	}
	
	public static void createTable(){
		
		//We divide our number of characters by the number of lines in order to get the number of columns
		nbrColumns = nbrColumns/nbrLines;
		System.out.println("Number lines : " + nbrLines + "\nNumber columns : " + nbrColumns);
		
		//Initializing the table with the correct values
		tableLevelData = new int[nbrLines][nbrColumns];
		
		int i = 0;
		int i2 = 0;
		int i3 = 0;
		for (i = 0; i < nbrLines; i++){
			for (i2 = 0; i2 < nbrColumns;){
				if (theMapString.substring(i3, i3 + 1).equals("O")){
					tableLevelData[i][i2] = 13;
					i2 = i2 + 1;
					i3 = i3 + 1;
				}
				else if (theMapString.substring(i3, i3 + 1).equals("S")){
					tableLevelData[i][i2] = 14;
					i2 = i2 + 1;
					i3 = i3 + 1;
				}
				else if (theMapString.substring(i3, i3 + 1).equals("Q")){
					tableLevelData[i][i2] = 2;
					i2 = i2 + 1;
					i3 = i3 + 1;
				}
				else if (theMapString.substring(i3, i3 + 1).equals("M")){
					tableLevelData[i][i2] = 8;
					i2 = i2 + 1;
					i3 = i3 + 1;
				}
				else if (theMapString.substring(i3, i3 + 1).equals("X")){
					tableLevelData[i][i2] = 0;
					i2 = i2 + 1;
					i3 = i3 + 1;
				}
				else if (theMapString.substring(i3, i3 + 1).equals("C")){
					tableLevelData[i][i2] = 22;
					i2 = i2 + 1;
					i3 = i3 + 1;
				}
				else if (theMapString.substring(i3, i3 + 1).equals("D")){
					tableLevelData[i][i2] = 23;
					i2 = i2 + 1;
					i3 = i3 + 1;
				}
				else if (theMapString.substring(i3, i3 + 1).equals("I")){
					tableLevelData[i][i2] = 12;
					i2 = i2 + 1;
					i3 = i3 + 1;
				}
				else if (theMapString.substring(i3, i3 + 1).equals("H")){
					tableLevelData[i][i2] = 51;
					i2 = i2 + 1;
					i3 = i3 + 1;
				}
				else if (theMapString.substring(i3, i3 + 1).equals("E")){
					tableLevelData[i][i2] = 52;
					i2 = i2 + 1;
					i3 = i3 + 1;
				}
				else if (theMapString.substring(i3, i3 + 1).equals("L")){
					tableLevelData[i][i2] = 53;
					i2 = i2 + 1;
					i3 = i3 + 1;
				}
				else if (theMapString.substring(i3, i3 + 1).equals("P")){
					tableLevelData[i][i2] = 54;
					i2 = i2 + 1;
					i3 = i3 + 1;
				}
				else if (theMapString.substring(i3, i3 + 1).equals("A")){
					tableLevelData[i][i2] = 55;
					i2 = i2 + 1;
					i3 = i3 + 1;
				}
				else if (theMapString.substring(i3, i3 + 1).equals("B")){
					tableLevelData[i][i2] = 56;
					i2 = i2 + 1;
					i3 = i3 + 1;
				}
				else if (theMapString.substring(i3, i3 + 1).equals("Y")){
					tableLevelData[i][i2] = 57;
					i2 = i2 + 1;
					i3 = i3 + 1;
				}
				else if (theMapString.substring(i3, i3 + 1).equals("Z")){
					tableLevelData[i][i2] = 58;
					i2 = i2 + 1;
					i3 = i3 + 1;
				}
				else if (theMapString.substring(i3, i3 + 1).equals("@")){
					tableLevelData[i][i2] = 59;
					i2 = i2 + 1;
					i3 = i3 + 1;
				}
				else if (theMapString.substring(i3, i3 + 1).equals("#")){
					tableLevelData[i][i2] = 60;
					i2 = i2 + 1;
					i3 = i3 + 1;
				}
				else {
					i3 = i3 + 1;
				}
			}
		}
	}
	
	public static void extractMapFromDataBase(int wantedID){
		
		wantedMapID = wantedID;
		connectToDataBase();
		extractMapData();
		closeAndCleanConnection();	
		analyzeData();
		createTable();
		
		
		System.out.println(Arrays.deepToString(tableLevelData));
	}
	
}
