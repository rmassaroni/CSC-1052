/**
 * A sorted "collection" that uses an underlying binary search tree to store the elements.
 * Various operations are defined to demonstrate the management of a BST.
 *
 * @author Rephactor Java
 * @version 1.0
 */
public class MyBST<T extends Comparable<T>>
{
    private BTNode root;  // a reference to the root node in the tree
    
    /**
     * Sets up an initially empty tree.
     */
    public MyBST()
    {
        root = null;
    }

    /**
     * Makes the initial call to the recursive method that adds the specified element
     * to the tree. 
     * @param elementToAdd generic element to be added
     */
    public void add(T elementToAdd)
    {
        root = add(elementToAdd, root);
    }

    /**
     * Recursively determines the proper location in the tree, then adds a new node
     * containing the new element. 
     * @param elementToAdd generic element to be added
     * @param node root node of the subtree in which the element will be added
     * @return the root node of this subtree (unmodified), or the new node
     */
    private BTNode add(T elementToAdd, BTNode node)
    {
        if (node == null)
            node = new BTNode(elementToAdd);
        else if (elementToAdd.compareTo(node.elem) <= 0)
            node.left = add(elementToAdd, node.left);
        else
            node.right = add(elementToAdd, node.right);
        return node;
    }

    /**
     * Makes the initial call to the recursive method that determines how many elements
     * are stored in the BST.
     * @return the number of elements in the tree
     */
    public int size()
    {
        return size(root);
    }

    /**
     * Recursively determines how many elements are in the tree with the specified
     * root node.
     * @param node root node of the subtree being counted
     * @return the number of elements in the subtree with root node
     */
    private int size(BTNode node)
    {
        if (node == null)
            return 0;
        else
            return size(node.left) + size(node.right) + 1;
    }

    /**
     * Returns true if the tree is empty and false otherwise.
     * @return true if there are no elements in the tree
     */
    public boolean isEmpty()
    {
        return root == null;
    }

    /**
     * Makes the initial call to the recursive method that gets the specified element.
     * @return the element or null if not found
     */
    public T get(T elementToGet)
    {
        return get(elementToGet, root);
    }

    /**
     * Recursively searches the tree for the specified element.
     * @return the element or null if not found
     */
    private T get(T elementToGet, BTNode node)
    {
        if (node == null)  // element is not in tree
            return null;
        else if (elementToGet.compareTo(node.elem) == 0)  // element found
            return node.elem;
        else if (elementToGet.compareTo(node.elem) < 0)
            return get(elementToGet, node.left);
        else
            return get(elementToGet, node.right);
    }

    /**
     * Determines if the specified element is in the tree.
     * @param elementToFind the element to look for
     * @return true if the element is in the tree and false otherwise
     */
    public boolean contains(T elementToFind)
    {
        return get(elementToFind) != null;
    }
    
    /**
     * Makes the initial call to the recursive method that removes the specified element
     * from the tree. 
     * @param elementToRemove generic element to be removed
     */
    public void remove(T elementToRemove)
    {
        root = remove(elementToRemove, root);
    }

    /**
     * Recursively searches for the element to remove. When found, the private removeNode
     * method is called. If not found, the tree is unchanged.
     * @param elementToRemove generic element to be removed
     * @param node root node of the subtree from which the element will be removed
     * @return the new root node of this subtree (possibly unmodified)
     */
    private BTNode remove(T elementToRemove, BTNode node)
    {
        if (node != null)  // element is not in tree
        {
            if (elementToRemove.compareTo(node.elem) == 0)  // element found
                node = removeNode(node);
            else if (elementToRemove.compareTo(node.elem) < 0)
                node.left = remove(elementToRemove, node.left);
            else
                node.right = remove(elementToRemove, node.right);
        }
        return node;
    }
    
    /**
     * Removes the specified node, considering three possibilities: the node to be removed
     * (1) is a leaf, (2) has one child, or (3) has two children. If either child is null,
     * it replaces the node with the other child -- this takes care of situations (1) and (2).
     * Otherwise, the element in this node is replaced with its inorder predecessor (the
     * largest element in the left subtree), then the predecessor node is removed.
     * @param node the node to be removed from the BST
     * @return the node replacing the one removed
     */
    private BTNode removeNode(BTNode node)
    {
        if (node.left == null)
            return node.right;
        else if (node.right == null)
            return node.left;
        else 
        {
            T predecessor = getLargestElement(node.left);
            node.elem = predecessor;
            node.left = remove(predecessor, node.left);
            return node;
        }
    }

    /**
     * Gets the largest element in the subtree with the specified root node. Used by the
     * removeNode method to get the inorder predecessor of an element.
     * @param node root node of the subtree from which the largest element will be obtained
     * @return the largest element in the subtree
     */
    private T getLargestElement(BTNode node)
    {
        while (node.right != null)
            node = node.right;
        return node.elem;
    }

    /**
     * Makes the initial call to the recursive method that prints
     * each tree element followed by the default newline separator.
     */
    public void printInOrder()
    {
        printInOrder(root, "\n");
    }

    /**
     * Makes the initial call to the recursive method that prints
     * each tree element followed by the specified separator.
     */
    public void printInOrder(String separator)
    {
        printInOrder(root, separator);
    }

    /**
     * Recursively performs an inorder traversal of the tree from
     * the specified node, printing each element followed by the
     * specified separator.
     * @param node root node of the subtree to be traversed
     * @param separator the string used to separate the tree elements
     */
    private void printInOrder(BTNode node, String separator)
    {
        if (node != null)
        {
            printInOrder(node.left, separator);
            System.out.print(node.elem + separator);
            printInOrder(node.right, separator);            
        }
    }
        
    /**
     * A private inner class that represents a binary tree node.
     */
    private class BTNode
    {
        private T elem;        // the element stored in the node
        private BTNode left;   // the reference to the left child of this node
        private BTNode right;  // the reference to the right child of this node
        
        /**
         * Stores the element and sets the child references to null.
         * @param element generic element to be stored
         */
        public BTNode(T element)
        {
            this(element, null, null);
        }
        
        /**
         * Stores the element and sets the child references to the nodes specified.
         * @param element generic element to be stored
         * @param left node that will become the left child of this node
         * @param right node that will become the right child of this node
         */
        public BTNode(T element, BTNode left, BTNode right)
        {
            this.elem = element;
            this.left = left;
            this.right = right;
        }
    }
}
