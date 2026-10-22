import java.util.*;

/**
 * Small Java console model for the SmartFlow website simulation.
 * This demonstrates FIFO queues, emergency priority, and adaptive phase selection.
 */
public class TrafficSimulation {
    private final Map<String, Queue<String>> roadQueues = new LinkedHashMap<>();
    private final PriorityQueue<Vehicle> emergencyQueue =
        new PriorityQueue<>(Comparator.comparingInt(v -> v.priority));
    private int vehicleNumber = 1;

    private static class Vehicle {
        String type;
        int priority;
        Vehicle(String type, int priority) { this.type = type; this.priority = priority; }
    }

    public TrafficSimulation() {
        for (String road : Arrays.asList("North", "South", "East", "West")) {
            roadQueues.put(road, new LinkedList<>());
        }
        addVehicles("North", 6);
        addVehicles("South", 5);
        addVehicles("East", 7);
        addVehicles("West", 6);
    }

    private void addVehicles(String road, int count) {
        Queue<String> queue = roadQueues.get(road);
        for (int i = 0; i < count; i++) queue.offer("Vehicle-" + vehicleNumber++);
    }

    private void requestEmergency(String type, int priority) {
        emergencyQueue.offer(new Vehicle(type, priority));
    }

    private String chooseGreenPhase() {
        int northSouth = roadQueues.get("North").size() + roadQueues.get("South").size();
        int eastWest = roadQueues.get("East").size() + roadQueues.get("West").size();
        return northSouth >= eastWest ? "North/South" : "East/West";
    }

    private void processPhase(String phase) {
        List<String> roads = phase.equals("North/South")
            ? Arrays.asList("North", "South") : Arrays.asList("East", "West");
        int processed = 0;
        for (String road : roads) {
            Queue<String> queue = roadQueues.get(road);
            for (int i = 0; i < 2 && !queue.isEmpty(); i++) {
                System.out.println("  Processed " + queue.poll() + " from " + road);
                processed++;
            }
        }
        System.out.println("Vehicles processed this phase: " + processed);
    }

    private void displayQueues() {
        System.out.println("\n--- Road queues (FIFO) ---");
        roadQueues.forEach((road, queue) -> System.out.println(road + ": " + queue.size() + " waiting"));
    }

    public void runDemo() {
        System.out.println("SMART TRAFFIC SIGNAL MANAGEMENT SIMULATION");
        System.out.println("Educational prototype only; not for real traffic control.\n");
        requestEmergency("Ambulance", 1);
        if (!emergencyQueue.isEmpty()) {
            Vehicle emergency = emergencyQueue.poll();
            System.out.println("Emergency priority: " + emergency.type);
            System.out.println("Priority approach is represented in the web UI; console demo uses safe NS/EW phases.");
        }
        displayQueues();
        for (int i = 0; i < 4; i++) {
            String phase = chooseGreenPhase();
            System.out.println("\nGreen phase: " + phase);
            processPhase(phase);
            displayQueues();
        }
        System.out.println("\nDemo complete.");
    }

    public static void main(String[] args) {
        new TrafficSimulation().runDemo();
    }
}
