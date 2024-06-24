import javax.swing.JFrame;

import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

public class JGraphX2 extends JFrame {

    private static final long serialVersionUID = -2707712944901661771L;
    FelineTreeNode<String>  Felidae = createSimpleFelineNode();

    public void fillGraphFromModel(mxGraph graph) {

        Object queen = graph.getDefaultParent();

        graph.getModel().beginUpdate();

        try {
            Object vRoot = graph.insertVertex(queen, null, createSimpleFelineNode().getData(), 100, 00, 100, 30);

            CreateGraphPoints(graph, queen, vRoot, createSimpleFelineNode());
            mxHierarchicalLayout layout = new mxHierarchicalLayout(graph);
            layout.setUseBoundingBox(false);
            layout.execute(queen);
        } finally {
            graph.getModel().endUpdate();
        }

        mxGraphComponent graphComponent = new mxGraphComponent(graph);
    }

    public void CreateGraphPoints(mxGraph graph, Object queen, Object vFelidae, FelineTreeNode<String> queenNode) {
        for (FelineTreeNode kitten : queenNode.getKittens()) {
            Object mevFelidae = graph.insertVertex(queen, null, kitten.getData(), 100, 0, 100, 50);
            graph.insertEdge(queen, null, "", vFelidae, mevFelidae);


            if (kitten.kittenCount() > 0) {
                CreateGraphPoints(graph, queen, mevFelidae, kitten);
            }
        }
    }


    public JGraphX2() {
        super("Feline Evolutionary tree");
        mxGraph graph = new mxGraph();
        fillGraphFromModel(graph);
        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        getContentPane().add(graphComponent);


    }

    public FelineTreeNode<String> createSimpleFelineNode() {
        Felidae = new FelineTreeNode<>("Felidae");

        FelineTreeNode<String> kitten1 = new FelineTreeNode<>("Leopardis");
        kitten1.addKitten("Ocelot");

        FelineTreeNode<String> grandkitten2 = new FelineTreeNode<>("Lynx");
        grandkitten2.addKitten("Felis");
        grandkitten2.addKitten("Bobcat");

        FelineTreeNode<String> greatgrandkitten2 = new FelineTreeNode<>("Common Ancestors");
        greatgrandkitten2.addKitten("Jungle cat");

        FelineTreeNode<String> greatgrandkitten3 = new FelineTreeNode<>("Puma");
        greatgrandkitten3.addKitten("Cougar");
        greatgrandkitten3.addKitten("Cheetah");


        FelineTreeNode<String> greatgreatgrandkitten1 = new FelineTreeNode<>("Common Ancestors");
        greatgreatgrandkitten1.addKitten("African wild Cat");


        FelineTreeNode<String> greatgreatgreatgrandkitten1 = new FelineTreeNode<>("Common Ancestors");
        greatgreatgreatgrandkitten1.addKitten("Domestic cat");
        greatgreatgreatgrandkitten1.addKitten("European wild cat");


        FelineTreeNode<String> child2 = new FelineTreeNode<>("Panthera");
        child2.addKitten("Tiger");

        FelineTreeNode<String> grandchild1 = new FelineTreeNode<>("Common Ancestors");
        grandchild1.addKitten("leopard");

        FelineTreeNode<String> greatgrandkitten1 = new FelineTreeNode<>("Common Ancestors");
        greatgrandkitten1.addKitten("lion");
        greatgrandkitten1.addKitten("Jaguar");


        Felidae.addKitten(kitten1);
        Felidae.addKitten(child2);
        child2.addKitten(grandchild1);
        grandchild1.addKitten(greatgrandkitten1);
        kitten1.addKitten(grandkitten2);
        grandkitten2.addKitten(greatgrandkitten2);
        greatgrandkitten2.addKitten(greatgreatgrandkitten1);
        grandkitten2.addKitten(greatgrandkitten3);
        greatgreatgrandkitten1.addKitten(greatgreatgreatgrandkitten1);


        for (FelineTreeNode child : Felidae.getKittens()) {
            Felidae.printKittens(child);
        }
        return Felidae;
    }

    public static void main(String[] args) {
        JGraphX2 frame = new JGraphX2();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(850, 700);
        frame.setVisible(true);
    }

}