package com.asu.ser.db;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * @author akhilesh
 * @author Ashwin
 * @author Srinivasan
 */

public class TableCreationQueries {

	// Add table creation queries here.
	// Add table creation sql to tableCreationQueries list in the static block in the bottom of the class.

	private final static Logger LOGGER = Logger.getLogger(TableCreationQueries.class.getName());

	private static List<String> TABLE_CREATION_QUERIES = new ArrayList<>();

	private static final String INSERT_TEST_TABLE = "create table Test (name varchar(30) )";

	static {
		TABLE_CREATION_QUERIES.add(INSERT_TEST_TABLE);
	}

	/**
	 * Function to cold start database and execute sql queries
	 * @throws Exception
	 */
	public static void coldStart() throws Exception {
		for (String insertQuery : TABLE_CREATION_QUERIES) {
			try (Connection con = DataSourceConnector.getConnection()) {
				Statement stm = con.createStatement();
				stm.execute(insertQuery);
				LOGGER.log(Level.INFO, "Successfully created ");
			} catch (Exception e) {
				throw e;
			}
		}
	}


	/**
	 * Run this program to create all tables in the database.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			coldStart();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Failed to create tables in DB ", e);
		}
	}

}
