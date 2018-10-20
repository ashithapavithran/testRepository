package connection;
public class User {
public User(String state_name,int male,int female,int tot,String unit_name,String reg,String mrd,String rel,String father_name,String address,String mob,String regd)
{
this.setState(state_name);
this.setMale(male);
this.setFemale(female);
this.setTot(tot);
this.setState(unit_name);
this.setState(reg);
this.setState(mrd);
this.setState(rel);
this.setState(father_name);
this.setState(address);
this.setState(mob);
this.setState(regd);
}

public User() {

}
private String state_name;
private int male;
private int female;
private int tot;
private String unit_name;
private String reg;
private String mrd;
private String rel;
private String father_name;
private String address;
private String mob;
private String regd;
public void setState(String state_name) {
this.state_name = state_name;
}
public String getState() {
return state_name;
}

public void setReg(String reg) {
this.reg = reg;
}
public String getReg() {
return reg;
}

public void setMrd(String mrd) {
this.mrd = mrd;
}
public String getMrd() {
return mrd;
}

public void setRel(String rel) {
this.rel = rel;
}
public String getRel() {
return rel;
}
public void setFat(String father_name) {
this.father_name = father_name;
}
public String getFat() {
return father_name;
}
public void setAddress(String address) {
this.address = address;
}
public String getAddress() {
return address;
}
public void setMob(String mob) {
this.mob = mob;
}
public String getMob() {
return mob;
}
public void setRegd(String regd) {
this.regd = regd;
}
public String getRegd() {
return regd;
}

public void setUnit(String unit_name) {
this.unit_name = unit_name;
}
public String getUnit() {
return unit_name;
}
public void setMale(int male) {
this.male = male;
}

public int getMale() {
return male;
}
public void setFemale(int female) {
this.female = female;
}

public int getFemale() {
return female;
}
public void setTot(int tot) {
this.tot = tot;
}

public int getTot() {
return tot;
}
}