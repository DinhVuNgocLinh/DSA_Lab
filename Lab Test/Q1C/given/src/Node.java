// =========================================================
// Do NOT modify this file 
// =========================================================

class Node{
    private Animal info;
    Node next;
    
    // Default constructor (no parameter)
    Node () {}
    
    // Constructor for a typical node
    Node (Animal x, Node p) {
        this.info = x; // data stored inside the node
        this.next = p; // link to the next node
    }
    
    //Copy constructor
    Node (Animal x) {
        this(x,null);
    }
    
    public Animal getInfo() {
        return this.info;
    }
    
    public void setInfo(Animal inAnimal) {
        this.info = inAnimal;
    }
 }

