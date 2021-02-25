package model;


public class Person
{
    private String name;
    private String phoneNum;
    private String adress;

    public String getName() {
        return name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getAdress() {
        return adress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Person(String name, String phoneNum, String adress) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.adress = adress;
    }

    public Person()
    {
        setAdress("");
        setName("");
        setPhoneNum("");
    }


    @Override
    public String toString() {
        return name + "," + phoneNum +"," + adress;
    }
}


