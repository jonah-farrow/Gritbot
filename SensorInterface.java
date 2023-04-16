import com.fazecast.jSerialComm.*;
import java.util.Arrays;
import java.io.*;

public class SensorInterface {
    static String input = "";
    static String lightOutput = "";
    static String tempOutput = "";
    static String humidityOutput = "";
    static String[] arr;

    public static void test() throws IOException {
        System.out.println(Arrays.toString(SerialPort.getCommPorts()));
        SerialPort port = SerialPort.getCommPort("COM8");

        port.addDataListener(new SerialPortDataListener() {

            @Override
            public int getListeningEvents() {
                return SerialPort.LISTENING_EVENT_DATA_RECEIVED;
            }

            @Override
            public void serialEvent(SerialPortEvent event) {
                byte[] data = event.getReceivedData();
                // System.out.printf("Rec: %s\n", Arrays.toString(data));
                input += new String(data);
                if (input.contains("  ")) {
                    arr = (input.split("  ")); // arr[0] contains string to manipulate and send to game
                    System.out.println("Readings: " + arr[0] + " " + arr[1] + " " + arr[2]);
                    // input = arr[1]; // arr[1] == "", stops reading input from here

                    World.setEnvironmentLevels(Float.parseFloat(arr[0]), Integer.parseInt(arr[1]),
                            Integer.parseInt(arr[2]));

                }
            }
        });

        // port.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING, 1, 1);
        // System.out.println(new String(port.getInputStream().readNBytes(100)));
        // System.out.println(new String(port.getInputStream().readAllBytes()));
        // System.out.println(input);
        port.setBaudRate(115200);
        System.out.println("Port open?: " + port.openPort());
    }
}
