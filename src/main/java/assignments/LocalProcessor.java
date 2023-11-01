package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
    private Long period;
    private String processorVersion;
    private Integer valueOfCheap;
    private ArrayList<String> stringArrayList;

    public LocalProcessor() {
        period = 10_000_000_000_000L;
        stringArrayList = new ArrayList<>();
    }

    public LocalProcessor(String processorName, Long period, String processorVersion, Integer valueOfCheap,
                          List<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.stringArrayList = new ArrayList<>(stringArrayList);
    }

    @ListIteratorAnnotation
    public void iterateList(List<String> stringList) {
        stringArrayList = new ArrayList<>(stringList);
        for (int i = 0; i < period && i < stringArrayList.size(); i++) {
            System.out.println(stringArrayList.get(i).hashCode());
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String generateProcessorFullName(List<String> stringList) {
        StringBuilder result = new StringBuilder(processorName);
        for (String s : stringList) {
            result.append(' ').append(s);
        }
        processorName = result.toString();
        return processorName;
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException {
        try (Scanner informationScanner = new Scanner(file)) {
            StringBuilder result = new StringBuilder(processorVersion);
            while (informationScanner.hasNext()) {
                result.append(informationScanner.nextLine());
            }
            processorVersion = result.toString();
        }
    }
}
