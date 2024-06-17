// =========================================================
// Do NOT modify this file 
// =========================================================

class Animal {
    String name;
    int price,amount;
    
    // Default constructure
    Animal () {}
    
    // Constructor with full parameter
    Animal (String xName, int xPrice, int xAmount) {
        this.name = xName;
        this.price = xPrice; 
        this.amount = xAmount;
    }
    
    @Override
    public String toString(){
        return "(" +name+","+price + "," + amount + ")";
    }

    public int getPrice() {
        return this.price;
    }
    public int getAmount() {
        return this.amount;
    }
    public String getName() {
        return this.name;
    }
    public void setAmount(int inAmount) {
        this.amount = inAmount;
    }
    public void setPrice(int inPrice) {
        this.price = inPrice;
    }
    public void setName(String inName) {
        this.name = inName;
    }
}
