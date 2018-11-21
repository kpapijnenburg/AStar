import java.lang.reflect.Array;
import java.util.ArrayList;

class AStar {
    // Number of rows and columns in the grid.
    private int columns;
    private int rows;
    private Node[][] grid;

    // OpenSet is the list of currently discovered nodes that are not evaluated.
    private ArrayList<Node> openSet = new ArrayList<Node>();
    // ClosedSet is the list of nodes already evaluated.
    private ArrayList<Node> closedSet = new ArrayList<Node>();

    private Node start;
    private Node end;

    private ArrayList<Node> path;


    AStar(int columns, int rows) {
        this.columns = columns;
        this.rows = rows;
        this.grid =   new Node[columns][rows];

        //initialize grid with node objects.
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                grid[i][j] = new Node(i, j);
            }
        }

        // Define all neigbours per Node object in the grid.
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                grid[i][j].addNeigbours(grid);
            }
        }

        // Define the starting points as the first node.
        start = grid[0][0];
        // Define the endpoint as the last node of the grid.
        end = grid[columns - 1][rows - 1];

        openSet.add(start);
    }

    public int heuristic(Node a, Node b){
        return (a.getColumnIndex() - b.getColumnIndex()) + (a.getRowIndex() + b.getRowIndex());
    }

    int calculate() {
        while (openSet.size() > 0) {
            if (openSet.size() > 0) {

                // Node to store the lowest F value.
                int lowestFIndex = 0;

                // Looping through the openset to see if there are nodes with lower F values.
                for (int i = 0; i < openSet.size(); i++) {
                    if (openSet.get(i).getF() < openSet.get(lowestFIndex).getF()) {
                        // If found the current node is set as the one with the lowest F value.
                        lowestFIndex = i;
                    }
                }

                // Find current node in openSet.
                Node current = openSet.get(lowestFIndex);

                // If the current lowest scoring node is the last node the algorithm is finished.
                if (openSet.get(lowestFIndex) == end) {
                    return current.getF();
                }

                // Add it to the closedSet.
                closedSet.add(current);

                //Remove from the openSet.
                openSet.remove(current);

                // Find nodes to evaluate
                for (Node node : current.getNeigbours()) {

                    // Check if the node is already evaluated.
                    if (!closedSet.contains(node)) {
                        // Set the cost to all previous costs plus the new cost.
                        int tempG = current.getG() + 1;

                        // Check if the node evaluated before.
                        if (openSet.contains(node)){
                            if (tempG < node.getG()){
                                node.setG(tempG);
                            }
                        } else {
                            node.setG(tempG);
                            openSet.add(node);
                        }
                    }

                    // Update values of current node.
                    node.setH(heuristic(node, end));
                    node.setF(node.getG() + node.getH());
                    node.setPrevious(current);
                }

            } else {
                System.out.println("No solution possible");
            }
        }
        return 0;
    }



}

