package order;

public class Package implements Comparable<Package>{
    private String packageID;
    private String desc;
    private char packageSize;
    private Double price;
    private String[] food;

    public Package(String packageID, String desc, char packageSize, Double price, String[] food) {
        this.packageID = packageID;
        this.desc = desc;
        this.packageSize = packageSize;
        this.price = price;
        this.food = food;
    }

    public String getPackageID() {
        return packageID;
    }

    public void setPackageID(String packageID) {
        this.packageID = packageID;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public char getPackageSize() {
        return packageSize;
    }

    public void setPackageSize(char packageSize) {
        this.packageSize = packageSize;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String[] getFood() {
        return food;
    }

    public void setFood(String[] food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "Package{" + "packageID=" + packageID + ", desc=" + desc + ", packageSize=" + packageSize + ", price=" + price + ", food=" + food + '}';
    }

    @Override
    public int compareTo(Package p) {
        int id = Integer.parseInt(this.packageID.replaceAll("[a-zA-Z]", ""));
        int pID = Integer.parseInt(p.packageID.replaceAll("[a-zA-Z]", ""));
        
        return(id- pID);
    }
    
    
}
