package com.algo.config;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class DistributerIdGenerator implements IdentifierGenerator, Serializable {

	private static final long serialVersionUID = 1L;

	private static ThreadLocal<String> tableNameThreadLocal = new ThreadLocal<>();

	public static void setTableName(String tableName) {
		try {
			tableNameThreadLocal.set(tableName);
			System.out.println("Table: " + tableName);
		} catch (Exception e) {
			// Handle the exception if needed
			e.printStackTrace();
		}
		// Do NOT clear the ThreadLocal here; clear it at an appropriate place in your
		// code
	}

	public static void clearTableName() {
		tableNameThreadLocal.remove();
	}

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		try {
			String tableName = tableNameThreadLocal.get();
			System.out.println("Table Name: " + tableName);
			if (tableName == null || tableName.trim().isEmpty()) {
				throw new HibernateException("Invalid table name");
			}

			String prefix = getPrefix(tableName);

			String sequenceQuery = "SELECT MAX(ID) FROM " + tableName;
			try (Connection connection = session.getJdbcConnectionAccess().obtainConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(sequenceQuery);
					ResultSet resultSet = preparedStatement.executeQuery()) {

				if (resultSet.next()) {
					String maxIdString = resultSet.getString(1);
					int maxId = extractNumericPart(maxIdString);

					if (maxId > 0) {
						return prefix + String.format("%04d", maxId + 1);
					} else {
						return prefix + "0001";
					}
				} else {
					throw new HibernateException("Unable to fetch sequence value");
				}
			}
		} catch (SQLException e) {
			throw new HibernateException("Unable to generate ID", e);
		} catch (NumberFormatException e) {
			throw new HibernateException("Error parsing ID", e);
		}catch (Exception e) {
	        throw new HibernateException("Unexpected error during ID generation.", e);
	    }
	}

	private String getPrefix(String tableName) {
		System.out.println("Table Name: " + tableName);
		if ("Distributer".equalsIgnoreCase(tableName)) {
			return "D";
		} else if ("master_distributer".equalsIgnoreCase(tableName)) {
			return "MD";
		} else if ("sales_admin".equalsIgnoreCase(tableName)) {
			return "SA";
		}
		else if("master_admin".equalsIgnoreCase(tableName)){
			return "MA";
		}

		else {
			System.out.println("Invalid table name. Using default prefix.");
			return "DefaultPrefix"; // Provide a default prefix or handle it according to your requirements
		}
	}

	private int extractNumericPart(String maxIdString) {
		String tableName = tableNameThreadLocal.get();
		int prefixLength = getPrefix(tableName).length();

		// Make sure maxIdString is not null and has enough characters
		if (maxIdString != null && maxIdString.length() > prefixLength) {
			return Integer.parseInt(maxIdString.substring(prefixLength));
		} else {
			return 0;
		}
	}
}
