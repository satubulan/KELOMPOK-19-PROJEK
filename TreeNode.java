public class TreeNode {
    String name;                // Nama dari node (misal nama ahli waris)
    String relationship;        // Hubungan dengan jemaah utama
    TreeNode firstChild;        // Anak pertama
    TreeNode nextSibling;       // Saudara kandung berikutnya

    // Constructor
    public TreeNode(String name, String relationship) {
        this.name = name;
        this.relationship = relationship;
        this.firstChild = null;
        this.nextSibling = null;
    }

    // Menambahkan anak ke node ini
    public void addChild(String childName, String childRelationship) {
        TreeNode newChild = new TreeNode(childName, childRelationship);
        if (this.firstChild == null) {
            this.firstChild = newChild;
        } else {
            TreeNode sibling = this.firstChild;
            while (sibling.nextSibling != null) {
                sibling = sibling.nextSibling;
            }
            sibling.nextSibling = newChild;
        }
    }
    
    // Menampilkan tree (preorder traversal)
    public void displayTree(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }
        System.out.println("- " + name + " (" + relationship + ")");
        TreeNode child = firstChild;
        while (child != null) {
            child.displayTree(depth + 1);
            child = child.nextSibling;
        }
    }
    public TreeNode findFamilyRoot(String name) {
        if (this.name.equals(name)) {
            return this;
        }
        TreeNode child = firstChild;
        while (child != null) {
            TreeNode result = child.findFamilyRoot(name);
            if (result != null) {
                return result;
            }
            child = child.nextSibling;
        }
        return null;
    }
    public TreeNode getTreeNodeFromNode(Node node) {
    // Logika untuk mendapatkan TreeNode dari Node
    // Misalnya, jika Anda menyimpan TreeNode di dalam Node
    return node.child; // Asumsi child adalah TreeNode
    }
}
