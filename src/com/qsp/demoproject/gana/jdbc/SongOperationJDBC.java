package com.qsp.demoproject.gana.jdbc;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;

public class SongOperationJDBC {
	static Connection connection;
	static String driverPath = "com.mysql.cj.jdbc.Driver";
	static PreparedStatement preparedStatement;
	static ResultSet resultSet;
	static int resultInt;
	static Properties properties = new Properties();
	FileReader fileReader;
	static String query;

	Scanner sc = new Scanner(System.in);
	boolean list = false;
	String path = "C:\\Users\\DELL\\eclipse-workspace\\Project_1\\resources\\db_info.properties";

	public void openConnection() {

		try {
			fileReader = new FileReader(path);
			properties.load(fileReader);
			Class.forName(driverPath);
			connection = DriverManager.getConnection(properties.getProperty("dbPath"), properties);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void addSongs() {
		try {
			openConnection();
			query = "select count(*) from song";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			int count = 0;
			while (resultSet.next()) {
				count = resultSet.getInt(1);
			}
			System.out.println("Enter No to Add Songs...");
			int no = sc.nextInt();
			for (int i = count; i < count + no; i++) {
				query = "INSERT INTO musicplayer.song(id,songname) VALUES(?,?)";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, i + 1);
				System.out.println("Enter Song Name :");
				preparedStatement.setString(2, sc.next());
				resultInt = preparedStatement.executeUpdate();
				System.out.println("Song Added Successfully...");
			}
			closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void displaylistOfSongs() {
		try {
			openConnection();
			System.out.println("Enter no to add songs");
			query = "select * from song";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + "|" + resultSet.getString(2) + "|" + resultSet.getString(3)
						+ "|" + resultSet.getString(4) + "|" + resultSet.getString(5) + "|" + resultSet.getDouble(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void removeSong() {
		try {
			openConnection();
			displaylistOfSongs();
			System.out.println("Enter no to remove song");
			int j = sc.nextInt();
			query = "DELETE FORM song WHERE id=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, j);
			resultInt = preparedStatement.executeUpdate();
			System.out.println("update...");
			query = "select count(*) from song";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			int count = 0;
			while (resultSet.next()) {
				count = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void ChooseSongPlay() {

		try {
			openConnection();
			this.displaylistOfSongs();
			System.out.println("enter song no");
			int no = sc.nextInt();
			query = "select songname from song where id=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, no);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + " played");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void PlayAllSong() {

		try {
			openConnection();
			query = "select songname from song";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + " played");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void PlayRandom() {

		try {
			query = "select count(*) from song";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			int count = 0;
			while (resultSet.next()) {
				count = resultSet.getInt(1);
			}
			double a = (Math.random() * (count - 0 + 1)) + 0;
			int b = (int) a;
			query = "select songname from song where id=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, b);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + " played");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void update() {
		displaylistOfSongs();
		System.out.println("choose song id no");
		int n = sc.nextInt();
		System.out.println("1.id /n 2.song name/n 3.movie name /n 4.composer /n 5.length /n 6 back");
		int key = sc.nextInt();
		switch (key) {
		case 1:
			System.out.println("not possible to change...!!");
			break;
		case 2:
			System.out.println("enter modified song name");

			try {
				openConnection();
				query = "UPDATE song SET songname= ? WHERE id = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(2, n);
				preparedStatement.setString(1, sc.next());
				resultInt = preparedStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InputMismatchException e) {
				System.out.println("Song name mismatch..!");

			}

			break;

		case 3:
			System.out.println("enter modified movie name");

			try {
				openConnection();
				query = "UPDATE song SET moviename= ? WHERE id = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(2, n);
				preparedStatement.setString(1, sc.next());
				resultInt = preparedStatement.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		case 4:
			System.out.println("enter song by composer");

			try {
				openConnection();
				query = "UPDATE song SET composername= ? WHERE id = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(2, n);
				preparedStatement.setString(1, sc.next());
				resultInt = preparedStatement.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 5:
			System.out.println("enter modified song length");

			try {
				openConnection();
				query = "UPDATE song SET length= ? WHERE id = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(2, n);
				preparedStatement.setDouble(1, sc.nextDouble());
				resultInt = preparedStatement.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 6:
			break;
		}
	}

}
