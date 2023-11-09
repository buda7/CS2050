//Name: Manoj Budathoki
//Assignment: Program8
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

class TreeNode {
    String data;
    TreeNode left, right;
    public TreeNode(String data) {
        this.data = data.toLowerCase();
        left = null;
        right = null;
    }
}

class BinarySearchTree {
    TreeNode root;
    public BinarySearchTree() {
        root = null;
    }

    public void insert(String word) {
        root = nodeInsert(root, word);
    }

    public TreeNode nodeInsert(TreeNode root, String word) {
        if (root == null) {
            root = new TreeNode(word);
            return root;
        }

        word = word.replaceAll("[^a-zA-Z]", "");
        if (word.isEmpty()) {
            return root;
        }

        word = word.toLowerCase();

        if (word.compareTo(root.data) < 0) {
            root.left = nodeInsert(root.left, word);
        } else if (word.compareTo(root.data) > 0) {
            root.right = nodeInsert(root.right, word);
        }

        return root;
    }

    public void analyzeTree(String outputFile) {
        int nodeCount = countNodes(root);
        int treeHeight = findHeight(root);
        int maxNodes = (int) Math.pow(2, treeHeight + 1) - 1;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write("Number of nodes: " + nodeCount + "\n");
            writer.write("Height of the tree: " + treeHeight + "\n");
            writer.write("Max number of nodes possible: " + maxNodes + "\n");
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public int countNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public int findHeight(TreeNode node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = findHeight(node.left);
        int rightHeight = findHeight(node.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }
    public static void main(String[] args) {
        String inputFile = "dracula.txt";
        String outputFile = "analysis.txt";
        BinarySearchTree bst = new BinarySearchTree();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                String line;
            while((line =reader.readLine())!=null){
                    String[] words = line.split("\\s+");
                    for (String word : words) {
                        bst.insert(word);
                    }
                }
            } catch(IOException e){
                System.out.println("Error");
            }
            bst.analyzeTree(outputFile);
        }
    }