package endava;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by tvasile on 7/20/2016.
 */
public class WordPercentage extends Thread {
    ConcurrentHashMap<String, Integer> wordHashMap;
    String words;

    public WordPercentage(String words, ConcurrentHashMap<String, Integer> wordHashMap) {
        this.words = words;
        this.wordHashMap = wordHashMap;
    }

    @Override
    public void run() {
        Integer value;
        for(String word : words.split(" ")) {
            word = word.replace(",", "");
            word = word.replace(".", "");
            if(word.isEmpty())
                continue;
            if(!wordHashMap.containsKey(word)) {
                wordHashMap.put(word, 1);
            }
            else {
                value = wordHashMap.get(word);
                wordHashMap.put(word, ++value);
            }

        }
    }

    public static void main(String[] args) {
        String text = new String();
        Integer numberOfThreads = 2;
        Integer stringStart, stringEnd, stringSize;
        ConcurrentHashMap<String, Integer> wordHashMap = new ConcurrentHashMap<>();
        WordPercentage []threads = new WordPercentage[numberOfThreads];

        try {
            text = new String(Files.readAllBytes(Paths.get("D:/java-io-files/textFile.txt")), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        long start = System.currentTimeMillis();

        stringSize = text.length()/numberOfThreads;
        stringEnd = 0;

        for(int i = 0; i < numberOfThreads; i++) {
            stringStart = stringEnd;
            stringEnd = (i+1) * stringSize;

            if(stringEnd >= text.length())
                stringEnd = text.length() - 1;
            while(text.charAt(stringEnd) != ' ' && stringEnd < text.length() - 1) {
                stringEnd++;
            }

            threads[i] = new WordPercentage(text.substring(stringStart, stringEnd), wordHashMap);
            threads[i].start();
        }

        for(int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }

        long end = System.currentTimeMillis();

        //wordHashMap.forEach((k, v) -> System.out.println("Key: " + k + " appearances: " + v));
        for(Map.Entry<String, Integer> entry: wordHashMap.entrySet()) {
            if(entry.getKey() != null && entry.getValue() != null)
                System.out.println(entry.getKey() + " : " + entry.getValue());
        }


        System.out.println("TIME: " + (end - start));
    }

}
