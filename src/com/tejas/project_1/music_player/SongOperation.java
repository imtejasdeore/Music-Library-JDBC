package com.tejas.project_1.music_player;

import java.util.ArrayList;
import java.util.Scanner;

public class SongOperation {
	Scanner sc = new Scanner(System.in);
	ArrayList<Song> music= new ArrayList<Song>();
	public void addSong() {
		System.out.println("Enter no to add song");
		int n= sc.nextInt();
		for(int i=0;i<n;i++) {
			
		}
	}
	public void displayListOfSong() {

		if (music.isEmpty() == true) {
//			System.out.println("NO Song In list...!!");
			throw new NullPointerException();
		} else
			System.out.println(music);
	}
	
	public void removeSong() {
		try {
			this.displayListOfSong();
			System.out.println("remove song no:");
			int j = sc.nextInt();
			music.remove(j - 1);
			this.displayListOfSong();
		} catch (Exception e) {
			System.out.println("No Songs in List. Add some songs first.");
		}

	}
	public void ChooseSongPlay() {
		try {
			this.displayListOfSong();
			System.out.println("enter song no");
			int no = sc.nextInt();
			try {
				System.out.println(music.get(no - 1).getSongName() + "song played");
			} catch (IndexOutOfBoundsException e) {
				System.out.println("no songs found");
			}
		} catch (Exception e) {
			System.out.println("No Songs in List. Add some songs first.");
		}
	}

	public void PlayAllSong() {
		for (int i = 0; i < music.size(); i++) {
			System.out.println(music.get(i).getSongName() + " song played");
		}
	}

	public void PlayRandom() {
		double a = (Math.random() * (music.size() - 0 + 1)) + 0;
		System.out.println(music.get((int) a).getSongName() + "song played");
	}

	public void update() {
		System.out.println(music);
		System.out.println("choose song id no");
		int n = sc.nextInt();
		System.out.println("1.id /n 2.song name/n 3.movie name /n 4.composer /n 5.length /n 6 back");
		int key = sc.nextInt();
		switch (key) {
		case 1:
			System.out.println("enter new id");
			music.get(n - 1).setId(sc.nextInt());
			break;
		case 2:
			System.out.println("enter song by song name");
			music.get(n - 1).setSongName(sc.next());
			break;
		case 3:
			System.out.println("enter song by movie name");
			music.get(n - 1).setMovieName(sc.next());
			break;
		case 4:
			System.out.println("enter song by composer");
			music.get(n - 1).setComposer(sc.next());
			break;
		case 5:
			System.out.println("enter song by song length");
			music.get(n - 1).setLength(sc.nextDouble());
			break;
		case 6:
			break;
		}
	}

}

	
	
}
