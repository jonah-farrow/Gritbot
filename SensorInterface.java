import com.fazecast.jSerialComm.*;
import java.util.Arrays;
import java.io.IOException;

public class SensorInterface {
    static String input = "";
    static String lightOutput = "";
    static String tempOutput = "";
    static String humidityOutput = "";

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
                if (input.contains("\n")) {
                    String[] arr = (input.split("\n")); // arr[0] contains string to manipulate and send to game
                    System.out.println("first reading: " + arr[0]);
                    input = arr[1];
                    // regex pattern match
                    // send off to be read
                }
            }
        });
        port.setBaudRate(115200);
        System.out.println("Port open?: " + port.openPort());
        port.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING, 0, 0);
        // System.out.println(new String(port.getInputStream().readNBytes(100)));
        // System.out.println(new String(port.getInputStream().readAllBytes()));
    }
}
