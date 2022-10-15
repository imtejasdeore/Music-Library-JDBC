package com.qsp.demoproject.gana;

public class Song {
	int Id;
	String songName;
	String singerName;
	String movieName;
	String composerName;
	String lyricist;
	double length;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getSingerName() {
		return singerName;
	}

	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getComposerName() {
		return composerName;
	}

	public void setComposerName(String composerName) {
		this.composerName = composerName;
	}

	public String getLyricist() {
		return lyricist;
	}

	public void setLyricist(String lyricist) {
		this.lyricist = lyricist;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	@Override
	public String toString() {
		return  Id + "|" + songName + "|" + singerName + "|" + movieName
				+ "|" + composerName + "|" + lyricist + "|" + length ;
	}

}
