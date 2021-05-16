package jpm.model;



public class Shipping {

    private String firstname;
    private String lastname;
    private String adress;
    private String postalcode;

    public Shipping() {}
    public Shipping(String firstname, String lastname, String adress, String postalCode) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.adress = adress;
        this.postalcode = postalCode;
    }
    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public String getAdress() {
        return adress;
    }
    public String getPostalCode() {
        return postalcode;
    }
    public void setFirstname(String a) {
        firstname=a;
    }
    public void setLastname(String a) {
        lastname=a;
    }
    public void  setAdress(String a) {
        adress=a;
    }
    public void setPostalCode(String a) {
        postalcode=a;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shipping info = (Shipping) o;

        if (!firstname.equals(info.firstname)) return false;
        if (!lastname.equals(info.lastname)) return false;
        if (!adress.equals(info.adress)) return false;
        return postalcode.equals(info.postalcode);
    }


    @Override
    public String toString() {
        return "UserDTO{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", adress='" + adress + '\'' +
                ", postalCode='" + postalcode + '\'' +
                '}';
    }
}
