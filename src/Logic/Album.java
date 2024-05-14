package Logic;

import java.util.ArrayList;
import java.util.List;

public class Album {

    private String name;
    private String coverPath;
    private List<Song> songs;

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
    }

    public Album() {

    }

    public Album(String name, String coverPath) {
        this.name = name;
        this.coverPath = coverPath;
        this.songs = new ArrayList<>();
    }

    public void addSong(String sName, int sDuration) {
        Song song = new Song(sName, sDuration);
        songs.add(song);
    }

    public List<Song> getSongs() {
        return songs;
    }
}
