package Logic;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Artist {

    // Properties
    private String name;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // ArrayList of artists and albums
    private static ArrayList<Artist> artists = new ArrayList<>();
    private List<Album> albums;

    // Constructor methods
    public Artist(String name) {
        this.name = name;
        albums = new ArrayList<>();
    }

    public Artist() {
        albums = new ArrayList<>();
    }

    // Method to create new artist
    public void createArtist(String name) {
        Artist newArtist1 = new Artist(name);
        artists.add(newArtist1);
    }

    // Method to return list of artists
    public ArrayList<Artist> getArtistList() {
        return artists;
    }

    // Method to return specific artist
    public Artist returnArtist(String name) {
        Artist buscado = new Artist();
        ArrayList<Artist> searchList = getArtistList();
        boolean found = false;
        int index = 0;

        while (index < searchList.size() && !found) {
            buscado = searchList.get(index);
            if (buscado.getName().equals(name)) {
                found = true;
                return buscado;
            }
            index++;
        }
        JOptionPane.showMessageDialog(null, "That artist does not exist");
        return null;
    }

    // Add album to collection
    public void addCollection(String albname, String albCover) {
        Artist artista = returnArtist(name);
        if (artista != null) {
            Album album = new Album(albname, albCover);
            artista.albums.add(album);// Corrected line to add album to the specific artist
        }
    }

    // Method to get all albums
    public List<Album> getAllAlbums() {
        return albums;
    }

    // Method to return a determined album
    public Album currentAlbum(String artName, String aName) {
        Artist artist = returnArtist(artName);
        if (artist == null) {
            throw new IllegalArgumentException("Artist not found: " + artName);
        }

        List<Album> albs = artist.getAllAlbums();
        for (Album album : albs) {
            if (album.getName().equals(aName)) {
                return album;
            }
        }

        throw new IllegalArgumentException("Album not found: " + aName);
    }

    /*
     * public static void main(String[] args) {
     * Artist myArtists = new Artist();
     * 
     * // Adding artists
     * myArtists.createArtist("Gustavo Cerati");
     * myArtists.createArtist("MGMT");
     * myArtists.createArtist("Alberto Spinetta");
     * 
     * // Adding albums
     * myArtists.returnArtist("Gustavo Cerati").addCollection(
     * "Bocanada",
     * "C:\\Users\\Daniel\\Desktop\\Programming\\Java\\MusicPlayer\\src\\Resources\\Images\\gus.jpg"
     * );
     * 
     * myArtists.getArtistList().get(0).currentAlbum("Gustavo Cerati",
     * "Bocanada").addSong("Puente", 180);
     * 
     * myArtists.getArtistList().get(0).addCollection("Fuerza Natural",
     * "C:\\Users\\Daniel\\Desktop\\Programming\\Java\\MusicPlayer\\src\\Resources\\Images\\FN.jpg"
     * );
     * 
     * myArtists.getArtistList().get(0).currentAlbum("Gustavo Cerati",
     * "Fuerza Natural").addSong("Deja Vu", 180);
     * 
     * myArtists.returnArtist("Alberto Spinetta").addCollection("Almendra",
     * "C:\\Users\\Daniel\\Desktop\\Programming\\Java\\MusicPlayer\\src\\Resources\\Images\\Spinetta.jpg"
     * );
     * 
     * myArtists.currentAlbum("Alberto Spinetta",
     * "Almendra").addSong("Muchacha ojos de papel", 200);
     * 
     * System.out.println(myArtists.getArtistList().get(0).getAllAlbums().size());
     * System.out.println(myArtists.getArtistList().get(0).getAllAlbums().get(0).
     * getSongs().size());
     * 
     * System.out.println(myArtists.getArtistList().get(2).getAllAlbums().size());
     * System.out.println(myArtists.getArtistList().get(2).getAllAlbums().get(0).
     * getSongs().size());
     * 
     * }
     */

}