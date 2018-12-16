package model;

/**
 *
 * @author John
 */
public class City {

    private String name;
    private int positionX;
    private int positionY;

    public City() {
       
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPositionX(int x) {
        this.positionX = x;
    }

    public int getPositionX() {
        return this.positionX;
    }

    public void setPositionY(int y) {
        this.positionY = y;
    }

    public int getPositionY() {
        return this.positionY;
    }
    
    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj){
        if(obj instanceof City){
            City city = (City) obj;
            return city.getName().equals(this.name);
        }
        return false;
    }
}
