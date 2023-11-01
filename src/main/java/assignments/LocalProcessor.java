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
    private StringBuilder processorName;
    private Long period = 10_000_000_000_000L;
    private StringBuilder processorVersion;
    private Integer valueOfCheap;
    private Scanner informationScanner;
    private List<String> stringArrayList = new ArrayList<>();

    public LocalProcessor() {
    }

    public LocalProcessor(String processorName, Long period, String processorVersion, Integer valueOfCheap,
                          Scanner informationScanner, List<String> stringArrayList) {
        this.processorName = new StringBuilder(processorName);
        this.period = period;
        this.processorVersion = new StringBuilder(processorVersion);
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        this.stringArrayList = new ArrayList<>(stringArrayList);
    }

    @ListIteratorAnnotation
    public void iterateList(List<String> stringList) {
        stringArrayList = new ArrayList<>(stringList);
        for (int i = 0; i < period && i < stringArrayList.size(); i++) {
            String s = stringArrayList.get(i);
            if (s != null) {
                System.out.println(s.hashCode());
            }
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String generateProcessorFullName(List<String> stringList) {
        for (String s : stringList) {
            processorName.append(s).append(' ');
        }
        return processorName.toString();
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                processorVersion.append(scanner.nextLine());
            }
            informationScanner = scanner;
        }
    }
}
