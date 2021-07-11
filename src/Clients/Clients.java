package Clients;

import java.util.ArrayList;

public class Clients {

    public String getType() {
        return type;
    }

    private String type;

    public Double getcCash() {
        return cCash;
    }

    public void setcCash(Double cCash) {
        this.cCash = cCash;
    }

    private Double cCash;

    public String getiMark1() {
        return iMark1;
    }

    private String iMark1;

    public String getiMark2() {
        return iMark2;
    }

    private String iMark2;

    public Boolean getBroken() {
        return broken;
    }

    private Boolean broken;

    public Boolean getBrokenS() {
        return brokenS;
    }

    private Boolean brokenS;

    public Clients(String type,Double cCash,String iMark1,String iMark2,Boolean broken,Boolean brokenS) {
        this.type = type;
        this.cCash = cCash;
        this.iMark1 = iMark1;
        this.iMark2 = iMark2;
        this.broken = broken;
        this.brokenS = brokenS;
    }
}
