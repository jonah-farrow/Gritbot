import com.fazecast.jSerialComm.*;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class SensorInterface {
    static String input = "";
    static float lux;
    static float temp;
    static float humidity;

    public static void test() throws IOException {
        System.out.println(Arrays.toString(SerialPort.getCommPorts()));
        SerialPort port = SerialPort.getCommPort("COM8");

        port.addDataListener(new SerialPortDataListener() {

            private final Pattern pattern = Pattern.compile("@([\\d.]+)\\s\\s([\\d.]+)\\s\\s([\\d.]+)#(.*)");

            @Override
            public int getListeningEvents() {
                return SerialPort.LISTENING_EVENT_DATA_RECEIVED;
            }

            @Override
            public void serialEvent(SerialPortEvent event) {
                byte[] data = event.getReceivedData();
                input += new String(data);
                // System.out.println(input);
                Matcher matcher = pattern.matcher(input);
                if (matcher.find()) { // basically its not matching on the regex
                    lux = Float.parseFloat(matcher.group(1));
                    temp = Float.parseFloat(matcher.group(2));
                    humidity = Float.parseFloat(matcher.group(3));
                    input = matcher.group(4);

                    System.out.println("\nLight: " + lux + "\nTemp: " + temp + "\nHumidity: " +
                            humidity);

                    // Environment.setEnvironmentLevels(Float.parseFloat(arr[0]),
                }

            }
        });

        // port.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING, 1, 1);
        port.setBaudRate(9600);
        System.out.println("Port open?: " + port.openPort());
    }
}
