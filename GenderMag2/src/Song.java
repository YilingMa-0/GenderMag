import java.io.*;
import java.util.*;
public class Song<T> {
    /**Data Field**/
    private T id;
    private T name;
    private T artist;
    private T year;

    /**Constructors*/
    public Song(){
    }

    public Song(T id, T name, T artist, T year) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", name=" + name +
                ", artist=" + artist +
                ", year=" + year +
                '}';
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public T getArtist() {
        return artist;
    }

    public void setArtist(T artist) {
        this.artist = artist;
    }

    public T getYear() {
        return year;
    }

    public void setYear(T year) {
        this.year = year;
    }

    //displayAllSongs Method: print first 3 songData of all songs in the list
    public static void displayAllSongs(LinkedList<Song> songs) {
        int count = 0;
        for (Song song : songs) {
            if(count>=3)
                break;
            System.out.println("The "+count+" music information: " + song.toString());
        }
    }

    //readSongs() method: return an array of Song objects from the .txt
    public static Song[] readSongs(String filename) throws IOException {
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(filename)
                    ));
            String linestr;
            int numLines = 0;
            while ((linestr = br.readLine()) != null) {
                numLines++;
            }
            br.close();

            br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(filename)));
            Song[] songs = new Song[numLines - 1];
            int i = 0;
            while ((linestr = br.readLine()) != null) {
                if (linestr.startsWith("ID")) {
                    continue;
                }
                String[] parts = linestr.split("\\s{1,}");
                String id = parts[0].trim();
                String name = parts[1].trim();
                String artist = parts[2].trim();
                String year = parts[4].trim();
                songs[i] = new Song(id, name, artist, year);
                i++;
            }
            br.close();

            return songs;
        }
        catch (Exception e) {
            System.out.println("File Fail!");
            e.printStackTrace();
        }
        return new Song[0];
    }

    //readSongs_link(): return a LinkedList of Song objects from the .txt
    public static LinkedList<Song> readSongs_link(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        LinkedList<Song> songs = new LinkedList<>();
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split("\\s{1,}");
            String id = parts[0].trim();
            String name = parts[1].trim();
            String artist = parts[2].trim();
            String year = parts[4].trim();
            Song song = new Song(id, name, artist, year);
            songs.add(song);
        }
        br.close();
        return songs;
    }
}


























