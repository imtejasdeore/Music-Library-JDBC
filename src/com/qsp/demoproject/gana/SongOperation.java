package com.qsp.demoproject.gana;

import java.util.ArrayList;
import java.util.Scanner;

public class SongOperation {
	Scanner sc = new Scanner(System.in);
	ArrayList<Song> music = new ArrayList<Song>();

	public void playSong() {
		try {
			displayAllSongs();
			System.out.println("Enter song no to play");
			int play = sc.nextInt();
			System.out.println(music.get(play - 1).getSongName() + "is now playing");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Song not found");
		}

	}

	public void allSongs() {
		for (int i = 0; i < music.size(); i++) {
			System.out.println(music.get(i).getSongName() + music.get(i).getSongName() + music.get(i).getSingerName()
					+ music.get(i).getLength() + "is now playing");
		}

	}

	public void playRandomSong() {
		double d = (Math.random() * (music.size() - 0 + 1)) + 0;
		System.out.println(music.get((int) d).getSongName() + "now playing");
	}

	public void addSong() {
		System.out.println("Enter how many songs to add");
		int add = sc.nextInt();
		for (int i = 0; i < add; i++) {
			music.add(i, new Song());
			music.get(i).setId(i + 1);
			System.out.println("Enter song name to add");
			music.get(i).setSongName(sc.next());
			System.out.println("Enter singer name to add");
			music.get(i).setSingerName(sc.next());
			System.out.println("Enter movie name to add");
			music.get(i).setMovieName(sc.next());
			System.out.println("Enter composer name to add");
			music.get(i).setComposerName(sc.next());
			System.out.println("Enter lyricist name to add");
			music.get(i).setLyricist(sc.next());
			System.out.println("Enter length name to add");
			music.get(i).setLength(sc.nextDouble());
		}

	}

	public void removeSong() {
		try {
			displayAllSongs();
			System.out.println("Enter no to remove song");
			music.remove(sc.nextInt() + 1);
		} catch (Exception e) {
			System.out.println(" song removed");
		}

	}

	public void updateSong() {

		System.out.println(music);
		System.out.println("add songs to update");
		int update = sc.nextInt();
		System.out.println(
				"1.Id \n 2.song name \n 3.singer name \n 4.movie name \n 5.composer name \n 6.lyricist \n 7.lenght \n 8.go back");
		int key = sc.nextInt();
		switch (key) {
		case 1: {
			System.out.println("enter new id");
			music.get(update - 1).setId(sc.nextInt());
			break;
		}
		case 2: {
			System.out.println("enter song name");
			music.get(update - 1).setSongName(sc.next());
			break;
		}
		case 3: {
			System.out.println("enter singer name");
			music.get(update - 1).setSingerName(sc.next());
			break;
		}
		case 4: {
			System.out.println("enter movie name");
			music.get(update - 1).setMovieName(sc.next());
			break;
		}
		case 5: {
			System.out.println("enter composer name");
			music.get(update - 1).setSongName(sc.next());
			break;
		}
		case 6: {
			System.out.println("enter lyricist name");
			music.get(update - 1).setLyricist(sc.next());
			break;
		}
		case 7: {
			System.out.println("enter length");
			music.get(update - 1).setLength(sc.nextDouble());
			break;
		}
		case 8: {
			break;
		}
		}
	}

	public void displayAllSongs() {
		System.out.println(music);

	}
}