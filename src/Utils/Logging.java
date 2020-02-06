package Utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logging {
    public enum Severity {
        Debug,
        Warning,
        Error
    }

    public static void AddLog(Severity severity, String message) throws IOException {
        /*BufferedWriter writer = new BufferedWriter(new FileWriter("logs/Logs.log", true));
        String str = "";
        switch (severity){
            case Debug:
                str += "DEBUG | ";
                break;
            case Warning:
                str += "WARN  | ";
                break;
            case Error:
                str += "ERROR | ";
                break;
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");
        LocalDateTime now = LocalDateTime.now();
        str += dtf.format(now) +" | "; //adds th time
        str += message +"\n";
        writer.append(str);
        writer.close();*/
    }
}
