public class TreeNode {
    String namaAhliWaris;
    TreeNode firstChild; 
    TreeNode nextSibling; 


    public TreeNode(String namaAhliWaris) {
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

    public void addSibling(TreeNode sibling) {
        TreeNode temp = this;
        while (temp.nextSibling != null) {
            temp = temp.nextSibling; 
        }
        temp.nextSibling = sibling; 
    }

    public void displayTree(int level) {
        String indentation = "  ".repeat(level);
        System.out.println(indentation + "|_" + this.namaAhliWaris);

        if (this.firstChild != null) {
            this.firstChild.displayTree(level + 1); 
        }

        if (this.nextSibling != null) {
            this.nextSibling.displayTree(level); 
        }
    }   

    public TreeNode getChild() {
        return this.firstChild;
    }

    public TreeNode getSibling() {
        return this.nextSibling;
    }
}