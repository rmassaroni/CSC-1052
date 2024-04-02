/**
 * A linked list data structure. This class is based on the
 * MyCollection class in the LinkedLists topic in Rephactor.
 *
 * @author Robert Massaroni
 */
public class MyLinkedList
{
    private Node head;  // a reference to the first node in the list
    
    /**
     * Sets up an initially empty linked list.
     */
    public MyLinkedList()
    {
        head = null;
    }

    /**
     * Traverses the list, printing each element.
     * Genreates lots of output for a long list!
     */
    public void printList()
    {
        Node current = head;
        while (current != null)
        {
            System.out.println(current.elem);
            current = current.next;
        }
    }
    
    /**
     * Adds the specified element to the front of the list. 
     * @param elementToAdd generic element to be added
     */
    public void addToFront(String elementToAdd)
    {
        head = new Node(elementToAdd, head);
    }
     
    /**
     * Determines if the specified element is in the list. 
     * @param elementToFind generic element to be found
     * @return true if the list contains the element and false otherwise
     */
    public boolean contains(String elementToFind)
    {
        Node current = head;
        
        while (current != null && !current.elem.equals(elementToFind))
            current = current.next;
        
        return current != null;
    }

    /**
     * Returns the size of the linked list as a count of its nodes.
     * @return number of nodes
     */
    public int size()
    {
        int count = 0;
        Node current = head;
        
        while (current != null)
        {
            count++;
            current = current.next;
        }
        
        return count;
    }
    
    /**
     * 1. Returns a count of the number of names that start with the 
     * specified letter, matching its case exactly.
     * @param letter the first letter
     * @return count of names
     */
    public int countOfNamesStartingWith(char letter)
    {
        Node current = head;
        int count = 0;
        
        while(current!= null) {
        	if(current.elem.charAt(0) == letter) {
        		count++;
        	}
        	current = current.next;
        }
        return count;
    }
    
    /**
     * 2. Returns the average number of letters (as a floating point number) in names 
     * starting with the upper or lower case version of the specified letter.
     * @param letter the first letter
     * @return average number of letters
     */
    public double avgLettersInNamesStartingWith(char letter)
    {
    	Node current = head;
        int count = 0;
        int total = 0;
        
        while(current!= null) {
        	if(current.elem.charAt(0) == letter) {
        		count++;
        		total += current.elem.length();
        	}
        	current = current.next;
        }
        return (double)total/count;
    }
    
    /**
     * 3. Returns a count of the number of names that contain the upper
     * or lower case version of the specified letter. The letter can
     * occur anywhere in a name to match.
     * @param letter the letter to find
     * @return count of names
     */
    public int countOfNamesContaining(char letter)
    {
    	Node current = head;
        int count = 0;
        
        while(current!= null) {
        	if(current.elem.indexOf(Character.toUpperCase(letter)) != -1 || current.elem.indexOf(Character.toLowerCase(letter)) != -1) {
        		count++;
        	}
        	current = current.next;
        }
        return count;
    }
    
    /**
     * 4. Returns the alphabetically first name in the list, ignoring case.
     * @return the first name
     */
    public String alphabeticallyFirstName()
    {
    	Node current = head;
        String name = current.elem;
        
        while(current!= null) {
        	if(current.elem.compareToIgnoreCase(name) < 0) {
        		name = current.elem;
        	}
        	current = current.next;
        }
        return name;
    }
    
    /**
     * 5. Returns the alphabetically first name in the list that starts
     * with the upper or lower case version of the specified letter.
     * @return the first name
     */
    public String alphabeticallyFirstNameStartingWith(char letter)
    {
    	Node current = head;
        String name = current.elem;
        
        while(current!= null) {
        	if(current.elem.compareToIgnoreCase(name) < 0 && current.elem.charAt(0) == letter) {
        		name = current.elem;
        	}
        	current = current.next;
        }
        return name;
    	
    }
    
    /**
     * 6. Returns the alphabetically last name in the list that starts
     * with the upper or lower case version of the specified letter.
     * @return the last name
     */
    public String alphabeticallyLastNameStartingWith(char letter)
    {
    	Node current = head;
        String name = current.elem;
        
        while(current!= null) {
        	if(current.elem.compareToIgnoreCase(name) > 0 && current.elem.charAt(0) == letter) {
        		name = current.elem;
        	}
        	current = current.next;
        }
        return name;    }

    /**
     * Returns the shortest name in the list. If more than one name
     * is the same, shortest length, it returns the first one it finds.
     * @return the shortest name
     */
    public String shortestName()
    {
    	Node current = head;
        String name = current.elem;
        
        while(current!= null) {
        	if(current.elem.length() < name.length()) {
        		name = current.elem;
        	}
        	current = current.next;
        }
        return name;  
    }
    
    /**
     * Returns the shortest name in the list that starts with the upper
     * or lower case version of the specified letter. If more than one name
     * is the same, shortest length, it returns the first one it finds.
     * @return the shortest name
     */
    public String shortestNameStartingWith(char letter)
    {
    	Node current = head;
        String name = "JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ";
        
        while(current!= null) {
        	if(current.elem.length() < name.length() && current.elem.charAt(0) == letter) {
        		name = current.elem;
        	}
        	current = current.next;
        }
        return name;  
    }
    
    /**
     * Returns the longest name in the list. If more than one name
     * is the same, longest length, it returns the first one it finds.
     * @return the longest name
     */
    public String longestName()
    {
    	Node current = head;
        String name = current.elem;
        
        while(current!= null) {
        	if(current.elem.length() > name.length()) {
        		name = current.elem;
        	}
        	current = current.next;
        }
        return name;
    }
    
    /**
     * Returns the name at the specified position n in the list.
     * If n is after the last element, return "name not found".
     * @return the nth name if found, otherwise "name not found"
     */
    public String getNthName(int n)
    {
    	Node current = head;
        String name = current.elem;
        int count = 0;
        while(current != null) {
        	name = current.elem;
        	current = current.next;
        	if(count == n) {
        		return name;
        	}
        	count++;
        	if(current == null) {
        		 return "name not found";
        	}
        }
        return name;
        
       
    }
    
      
    /**
     * A private inner class that represents a node in the linked list.
     */
    private class Node
    {
        private String elem; // the element stored in the node
        private Node next; // the reference to the next node in the list
        
        /**
         * Stores the element and sets the next reference to null.
         * @param element string element to be stored
         */
        public Node(String element)
        {
            this(element, null);
        }
        
        /**
         * Stores the element and sets the next reference to the node specified.
         * @param element string element to be stored
         * @param next node that will follow this node in the list
         */
        public Node(String element, Node next)
        {
            this.elem = element;
            this.next = next;
        }
    }
}