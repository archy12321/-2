
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

public class ToyProject {
    private String id;
    private String name;
    private int frequency;

    public ToyProject(String id, String name, int frequency) {
        this.id = id;
        this.name = name;
        this.frequency = frequency;
    }

    public static void main(String[] args) {
        PriorityQueue<ToyProject> toyQueue = new PriorityQueue<>((t1, t2) -> t2.frequency - t1.frequency);

        ToyProject toy1 = new ToyProject("1", "Doll", 5);
        ToyProject toy2 = new ToyProject("2", "Car", 3);
        ToyProject toy3 = new ToyProject("3", "Teddy Bear", 7);

        toyQueue.offer(toy1);
        toyQueue.offer(toy2);
        toyQueue.offer(toy3);

        try (FileWriter writer = new FileWriter("output.txt")) {
            for (int i = 0; i < 10; i++) {
                ToyProject toy = toyQueue.poll();
                writer.write("Toy ID: " + toy.id + ", Name: " + toy.name + "\n");
                toyQueue.offer(toy);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
