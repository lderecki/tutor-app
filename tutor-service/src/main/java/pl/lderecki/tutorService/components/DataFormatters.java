package pl.lderecki.tutorService.components;

import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class DataFormatters {

    public DateTimeFormatter getDateTimeFormatter() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
    }
}
