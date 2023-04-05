class Ship 
{
    private String name;
    private String nation;
    private int year;
    private int length;
    private int draft;
    private int beam;
    
    public Ship (String nam, String nat, int yer, int len, int dra, int bem)
    {
        name = nam;
        nation = nat;
        year = yer;
        length = len;
        draft = dra;
        beam = bem;
    }
    
    @Override
    public String toString()
    {
        return getName()+", "+getYear()+", "+getNation()+": "+getLength()+" by "+getDraft()+" by "+getBeam();
    }
    
    public int estimateDisplacement()
    {
        return getLength()*getDraft()*getBeam();
    }
    
    public boolean isOlder(Ship ship)
    {
        if(getYear() < ship.getYear())
        {
            return true;
        }
        return false;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the nation
     */
    public String getNation() {
        return nation;
    }

    /**
     * @param nation the nation to set
     */
    public void setNation(String nation) {
        this.nation = nation;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @return the length
     */
    public int getLength() {
        return length;
    }

    /**
     * @return the draft
     */
    public int getDraft() {
        return draft;
    }

    /**
     * @return the beam
     */
    public int getBeam() {
        return beam;
    }
    
}
        