import java.util.Comparator;
//Compare songs by their name from unsorted array
public class SongComparator1 implements Comparator<String[]> {

    @Override
    public int compare(String[] song1, String[] song2) {
        return song1[1].compareTo(song2[1]);
    }
}
