import java.util.ArrayList;
import java.util.List;

public class Node {
    private int columnIndex;
    private int rowIndex;
    private int f;
    private int g;
    private int h;
    private List<Node> neigbours;
    private Node previous;

    int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public List<Node> getNeigbours() {
        return neigbours;
    }

    public void setNeigbours(List<Node> neigbours) {
        this.neigbours = neigbours;
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public void setColumnIndex(int columnIndex) {
        this.columnIndex = columnIndex;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    Node(int i, int j) {
        this.rowIndex = i;
        this.columnIndex = j;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.neigbours = new ArrayList<Node>();
    }

    void addNeigbours(Node[][] grid){
        int i = this.columnIndex;
        int j = this.rowIndex;
        if (i < grid.length -1) {
            this.neigbours.add(grid[i + 1][j]);
        }
        if (i > 0) {
            this.neigbours.add(grid[i - 1][j]);
        }
        if (j < grid.length - 1) {
            this.neigbours.add(grid[i][j + 1]);
        }
        if (j > 0) {
            this.neigbours.add(grid[i][j - 1]);
        }
    }
}
