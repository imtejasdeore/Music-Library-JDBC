package com.tejas.project_1.music_player;

import java.util.Scanner;

public class MusicPlayer {
	static boolean loop = true;
	static SongOperation operation = new SongOperation();

	public static void main(String[] args) {
		musicMenu();
		while (loop) {
			musicMenu();
		}
	}

	public static void musicMenu() {
	Scanner sc = new Scanner(System.in);
	System.out.println("Options:"+"\n 1.Play \n 2.Add / Remove \n 3.Edit \n 4.Exit");
	int option = sc.nextInt();
	switch (option) {
	case 1: {
		System.out.println("options: "+"\n 1.Choose song \n 2.All songs \n 3.Random song \n 4.Go back");
		System.out.println("choose option:");
		int option1 = sc.nextInt();
		switch (option1) {
		case 1: {
			operation.ChooseSongPlay();
			break;
		}case 2:{
			operation.PlayAllSong();
			break;
		}case 3:{
			operation.PlayRandom();
			break;
		}case 4:{
			break;
		}
	}
		break;
	
	}
	case 2:{
		System.out.println("1.Add song \n 2.Remove song");
		System.err.println("choose option:-");
		int option2 = sc.nextInt();
		switch(option2) {
		case 1:{
			operation.addSong();
			break;
		}
		case 2:{
			operation.removeSong();
			break;
		}
		case 3:{
			break;
		}
		}
		loop =false;
		musicMenu();
		break;
	}
	case 3:{
		operation.update();
		loop = false;
		musicMenu();
		break;
		
	}
	case 4:{
		loop = false;
		musicMenu();
		break;
	}
	
	}

}
