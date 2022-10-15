package com.qsp.demoproject.gana;

import java.util.Scanner;

public class Multiplayer {

	static boolean loop = true;
	static SongOperation operation = new SongOperation();

	public static void main(String[] args) {

		menu();
		while (loop) {
			menu();
		}
	}

	public static void menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1.Play \n 2.Add / Remove \n 3.Edit \n 4.Exit");
		int key = sc.nextInt();
		switch (key) {
		case 1: {
			System.out.println("Choose : \n 1.play song \n 2.Play all songs \n 3.Random");
			int key1 = sc.nextInt();
			switch (key1) {
			case 1: {
				operation.playSong();
				break;
			}
			case 2: {
				operation.allSongs();
				break;
			}
			case 3: {
				operation.playRandomSong();
				break;
			}
			case 4: {

				break;
			}
			}
			loop = false;
			menu();
			break;
		}
		case 2: {
			System.out.println("1.Add song \n 2.Remove song");
			int key2 = sc.nextInt();
			switch (key2) {
			case 1: {
				operation.addSong();
				break;
			}
			case 2: {
				operation.removeSong();
				break;
			}
			}
			loop = false;
			menu();
			break;
		}

		case 3: {
			operation.updateSong();
			loop = false;
			menu();
			break;
		}
		case 4: {
			loop = false;
			menu();
			break;

		}

		}
	}

}