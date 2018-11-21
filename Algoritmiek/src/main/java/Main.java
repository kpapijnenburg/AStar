public class Main {


    public static void main(String[] args) {

        for (int i = 1; i < 1000; i = i + 100) {
            long startTime = System.nanoTime();

            final AStar astar = new AStar(i,i);
            int higestF = astar.calculate();

            long estimatedTime = System.nanoTime() - startTime;
            System.out.println("Highest calulated value: " + higestF + " Time to calculate: " + estimatedTime/1000000 + ". Amount of squares in grid:"  + i*i);
        }

        System.out.println("Finished calculating.");
    }
}
