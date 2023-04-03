import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestMethods {
    public static void main(String[] args) throws IOException {
        //Test generic class Song
        //creating at least 3 instances with parameters of different data types
        //and applying to methods
        Song song1 = new Song(1000000,"Wonderful",2.22,2019);
        song1.setId(8473242);
        song1.setName("Wonderful U");
        song1.setArtist("AGA");
        System.out.println(song1.toString());
        System.out.println("The song id is: "+song1.getId()+" artist is: "+song1.getArtist()+"the year is: "+song1.getYear());
        Song song2 = new Song(7417018,1,"Temptations",2020);
        System.out.println("The id 7417018 get the wrong name of the song: "+song2.getName());
        Song song3 = new Song(1000000,1,1,1);
        System.out.println(song3.toString());

        //Test the readSongs method:return an array of Song objects
        Song[] songs = Song.readSongs("/Users/apple/Desktop/2023Spring/CPS2232/CPS2232/song_table.txt");
        for (Song song : songs) {
            System.out.println(song);
        }
        System.out.println("_______________");
        //Test the readSongs_link method:return a LinkedList of Song objects
        LinkedList<Song> songsList = Song.readSongs_link("/Users/apple/Desktop/2023Spring/CPS2232/CPS2232/song_table.txt");
        for (Song song : songsList) {
            System.out.println(song);
        }

        //Test for searchSongs method: search Songs by their name from unsorted array
        Song[] songs1 = new Song[5];
        songs1[0] = new Song("1", "Bohemian Rhapsody", "Queen", "1975");
        songs1[1] = new Song("2", "Hotel California", "Eagles", "1976");
        songs1[2] = new Song("3", "Wonderwall", "Oasis", "2020");
        songs1[3] = new Song("4", "My Heart Will Go On", "Celine Dion", "1997");
        songs1[4] = new Song("5", "Another Brick in the Wall", "Pink Floyd", "1979");

        Song[] songByName = SearchSongs.searchSongsByName(songs, "Wonderwall");


        if (songByName != null && songByName.length > 0) {
            System.out.println("Song(s) found by name: ");
            for (Song song : songByName) {
                System.out.println(song.getName());
            }
        } else {
            System.out.println("Song not found by name");
        }

        //Test searchSongByYearAndName method: search Songs by year first and then by name
        List<Song> songs2 = new ArrayList<>();
        songs2.add(new Song("1", "Bohemian Rhapsody", "Queen", "1975"));
        songs2.add(new Song("2", "Hotel California", "Eagles", "1976"));
        songs2.add(new Song("3", "Wonderwall", "Oasis", "2020"));
        songs2.add(new Song("4", "My Heart Will Go On", "Celine Dion", "1997"));
        songs2.add(new Song("5", "Another Brick in the Wall", "Pink Floyd", "1979"));

        List<Song> matchingSongs = SearchSongs.searchSongsByYearAndName(songs2, "1975", "Bohemian Rhapsody");
        System.out.println("Songs found by year and name: ");
        for (Song song : matchingSongs) {
            System.out.println(song.getName());
        }
    }
}
