package SoftEng1;
import java.util.Scanner;

// Device interface for high-level commands
interface Device {
    void turnOn();
    void turnOff();
}

// Concrete device classes
class Light implements Device {
    // Implement methods for controlling lights
    @Override
    public void turnOn() {
        System.out.println("Light turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("Light turned off");
    }
}

class Thermostat implements Device {
    // Implement methods for controlling a thermostat
    @Override
    public void turnOn() {
        System.out.println("Thermostat turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("Thermostat turned off");
    }
}

class MusicPlayer implements Device {
    // Implement methods for controlling a music player
    @Override
    public void turnOn() {
        System.out.println("Music player turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("Music player turned off");
    }
}

// Central Controller
class CentralHub {
    private Device device;

    public CentralHub(Device device) {
        this.device = device;
    }

    public void performAction(String action) {
        switch (action) {
            case "Turn On":
                device.turnOn();
                break;
            case "Turn Off":
                device.turnOff();
                break;
            default:
                System.out.println("Unsupported action");
        }
    }
}

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Light light = new Light();
        CentralHub lightHub = new CentralHub(light);

        Thermostat thermostat = new Thermostat();
        CentralHub thermostatHub = new CentralHub(thermostat);

        MusicPlayer musicPlayer = new MusicPlayer();
        CentralHub musicPlayerHub = new CentralHub(musicPlayer);

        while (true) {
            System.out.print("[1] Light\n" +
                    "[2] Thermostat\n" +
                    "[3] Music Player\n" +
                    "[4] Exit\n" +
                    "Select Appliance: ");
            int option = sc.nextInt();

            System.out.println();

            switch (option) {
                case 1:
                    System.out.print("[1] Turn On\n" +
                            "[2] Turn Off\n");
                    int input = sc.nextInt();

                    if (input == 1 || input == 2) {
                        lightHub.performAction(input == 1 ? "Turn On" : "Turn Off");
                    } else {
                        System.out.println("Wrong Input!");
                    }
                    break;

                case 2:
                    System.out.print("[1] Turn On\n" +
                            "[2] Turn Off\n");
                    input = sc.nextInt();

                    if (input == 1 || input == 2) {
                        thermostatHub.performAction(input == 1 ? "Turn On" : "Turn Off");
                    } else {
                        System.out.println("Wrong Input!");
                    }
                    break;

                case 3:
                    System.out.print("[1] Turn On\n" +
                            "[2] Turn Off\n");
                    input = sc.nextInt();

                    if (input == 1 || input == 2) {
                        musicPlayerHub.performAction(input == 1 ? "Turn On" : "Turn Off");
                    } else {
                        System.out.println("Wrong Input!");
                    }
                    break;

                case 4:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Wrong input!");
            }
        }
    }
}

