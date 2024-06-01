package ch.donkeycode;

import jssc.SerialPort;
import jssc.SerialPortException;

import java.util.Optional;

public class Connection {

    public static void main(String[] args) {
        // Seriellen Port auswählen (angepasst für dein System)
        String portName = "COM3"; // Passe dies an den tatsächlichen Port an
        SerialPort serialPort = new SerialPort(portName);

        try {
            // Port öffnen und konfigurieren
            serialPort.openPort();
            serialPort.setParams(SerialPort.BAUDRATE_38400,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);

            // Initialisierung des ELM327
            sendCommand(serialPort, "AT Z\r");  // Reset
            System.out.println("Antwort: " + readResponse(serialPort));

            sendCommand(serialPort, "AT SP 0\r");  // Auto-Protokoll
            System.out.println("Antwort: " + readResponse(serialPort));

            // Tankfüllung abfragen (PID 2F)
            sendCommand(serialPort, "012F\r");
            String response = readResponse(serialPort);
            System.out.println("Tankfüllung Antwort: " + response);

            // Antwort parsen (Beispiel für PID 2F: Tankfüllung)
            if (response.startsWith("41 2F")) {
                String hexLevel = response.substring(6, 8);
                int level = Integer.parseInt(hexLevel, 16);
                double fuelLevel = (level * 100.0) / 255.0;
                System.out.println("Tankfüllung: " + fuelLevel + "%");
            }

            // Port schließen
            serialPort.closePort();
            System.out.println("Port geschlossen");
        } catch (SerialPortException e) {
            e.printStackTrace();
        }
    }

    // Hilfsmethode zum Senden von Befehlen
    private static void sendCommand(SerialPort serialPort, String command) throws SerialPortException {
        serialPort.writeString(command);
        System.out.println("Befehl gesendet: " + command);
    }

    // Hilfsmethode zum Lesen der Antwort
    private static String readResponse(SerialPort serialPort) throws SerialPortException {
        try {
            Thread.sleep(2000); // Warte etwas, um sicherzustellen, dass die Antwort vollständig ist
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(serialPort.readString())
                .map(String::trim)
                .orElse("n/a");
    }
}
