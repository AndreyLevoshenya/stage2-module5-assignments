package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private String processorName;
    private long period = 10_000_000_000_000L;
    private String processorVersion;
    private int valueOfCheap;
    private Scanner informationScanner;
    private static List<String> stringLinkedList = new LinkedList<>();
    private StringBuilder builder;

    public LocalProcessor(String processorName, long period, String processorVersion, int valueOfCheap,
                          Scanner informationScanner, List<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        stringLinkedList = new LinkedList<>(stringArrayList);
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(List<String> stringList) {
        for (String s : stringList) {
            if(s != null) {
                System.out.println(s.hashCode());
            }
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(List<String> stringList) {
        builder = new StringBuilder(processorName);
        for(String string : stringList) {
            if(string != null) {
                builder.append(string).append(" ");
            }
        }
        processorName = builder.toString();
        return processorName;
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) {
        try {
            informationScanner = new Scanner(file);
            builder = new StringBuilder(processorVersion);
            while (informationScanner.hasNext()) {
                builder.append(informationScanner.nextLine());
            }
            processorVersion = builder.toString();
        } catch (FileNotFoundException e) {
            System.err.println("file not found");
        } finally {
            informationScanner.close();
        }
    }
}
