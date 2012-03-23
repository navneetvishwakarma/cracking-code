package tarang.datastructures;

import java.util.ArrayList;
import java.util.List;


/**
 * Graph node object
 *
 * @author tdesai
 */
public class GNode {

    private int value;
    private boolean discovered;
    private List<GNode> adj;

    public GNode(int value) {
        this.value = value;
        this.adj = new ArrayList<GNode>();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<GNode> getAdj() {
        return adj;
    }

    public void setAdj(List<GNode> adj) {
        this.adj = adj;
    }

    public boolean isDiscovered() {
        return discovered;
    }

    public void setDiscovered(boolean discovered) {
        this.discovered = discovered;
    }

    public void connect(GNode node) {
        this.adj.add(node);
    }

    @Override
    public String toString() {
        return value + "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        GNode gNode = (GNode) o;

        if (value != gNode.value) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
