public class TreeNode {
    String namaAhliWaris;
    TreeNode firstChild;
    TreeNode nextSibling;
    public TreeNode (String namaAhliwaris){
        this.namaAhliWaris = namaAhliWaris;
        this.firstChild = null;
        this.nextSibling = null;
    }
    public void addChild(TreeNode child) {
        if (this.firstChild == null) {
            this.firstChild = child;
        } else {
            TreeNode temp = this.firstChild;
            while (temp.nextSibling != null) {
                temp = temp.nextSibling;
            }
            temp.nextSibling = child;
        }
    }
    public void displayTree(int level) {
        System.out.println("  ".repeat(level) + this.namaAhliWaris);
        if (this.firstChild != null) {
            this.firstChild.displayTree(level + 1);
        }
        if (this.nextSibling != null) {
            this.nextSibling.displayTree(level);
        }
    }
}
