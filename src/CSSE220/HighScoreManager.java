package CSSE220;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Manages a persistent top-10 high score list stored in a text file.
 */
public class HighScoreManager {
	private static final String FILE_NAME = "highscores.txt";
    private static final int MAX_ENTRIES = 10;

    public static class Entry implements Comparable<Entry> {
        public final String initials;
        public final int score;

        /*
         * A single high score entry: initials and numeric score
         */
        public Entry(String initials, int score) {
            this.initials = initials;
            this.score = score;
        }

        @Override
        public int compareTo(Entry o) {
            // sort descending
            return Integer.compare(o.score, this.score);
        }

        @Override
        public String toString() {
            return initials + "," + score;
        }
    }
    
    /*
     * Loads the high score list . If it doesn't exist it returns an empty list
     */
    public List<Entry> load() {
        List<Entry> list = new ArrayList<>();
        File f = new File(FILE_NAME);
        if (!f.exists()) {
            return list;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String ini = parts[0];
                    int sc = Integer.parseInt(parts[1]);
                    list.add(new Entry(ini, sc));
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        Collections.sort(list);
        return list;
    }
    
    public void save(List<Entry> list) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            int count = 0;
            for (Entry e : list) {
                if (count++ >= MAX_ENTRIES) break;
                writer.println(e.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /*
     * Adds a new score (initials + score) and also resorts the list
     */
    public void add(String initials, int score) {
        List<Entry> list = load();
        list.add(new Entry(initials, score));
        Collections.sort(list);
        save(list);
    }
    
    /*
     * Returns the current top scores in memory
     */
    public List<Entry> getTopScores() {
        return load();
    }
}
