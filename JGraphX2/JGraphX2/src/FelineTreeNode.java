import java.util.*;

public class FelineTreeNode<T> {
    private T data = null;  // name or other data about node
    private List<FelineTreeNode> Kittens = new ArrayList<>();
    private FelineTreeNode Queen = null;

    public FelineTreeNode(T data) {
        this.data = data;
    }

    public void addKitten(FelineTreeNode kitten) {
        kitten.setQueen(this);
        this.Kittens.add(kitten);
    }

    public void addKitten(T data) {
        FelineTreeNode<T> newKitten = new FelineTreeNode<>(data);
        this.addKitten(newKitten);
    }

    public void addKittens(List<FelineTreeNode> Kittens) {
        for (FelineTreeNode t : Kittens) {
            t.setQueen(this);
        }
        this.Kittens.addAll(Kittens);
    }

    public List<FelineTreeNode> getKittens() {
        return Kittens;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private void setQueen(FelineTreeNode queen) {
        this.Queen = queen;
    }

    public FelineTreeNode getQueen() {
        return Queen;
    }

    public String getQueens(FelineTreeNode node) {
        Deque stack = new LinkedList<FelineTreeNode>();
        String path = "";
        FelineTreeNode queenNode = node.getQueen();
        while (queenNode != null) {
            stack.push(queenNode);
            queenNode = queenNode.getQueen();
        }
        Iterator<FelineTreeNode> itr = stack.iterator();
        while (itr.hasNext()) {
            path = path + ((FelineTreeNode) itr.next()).data + ":";
        }
        return path;
    }

    public int kittenCount() {
        return (int) getKittens().stream().count();
    }

    //  Recursive methods to print multi-level tree
    public void printKittens(FelineTreeNode node) {
        if (node.Queen != null) {
            if (node.Kittens.size() == 0) {
                System.out.println(node.getQueens((FelineTreeNode) node) + ((FelineTreeNode) node).data);
            } else {
                for (Object kitten : node.getKittens()) {
                    System.out.println(node.getQueens((FelineTreeNode) kitten) + ((FelineTreeNode) kitten).data);
                    for (Object kittenofkitten : ((FelineTreeNode) kitten).getKittens())
                        printKittens((FelineTreeNode) kittenofkitten);
                }
            }
        }

    }

}