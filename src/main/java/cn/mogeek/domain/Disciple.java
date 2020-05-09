package cn.mogeek.domain;

public class Disciple {

    /**
     * 姓名 主修方向 毕业院校 师兄 来源 日报 目标
     */
    private String name, object, graduated_school,
            brother, comefrom, daily_report, aims;

    /**
     * id 为主键
     */
    private int id, qq;

    public void setName(String name) {
        this.name = name;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public void setGraduated_school(String graduated_school) {
        this.graduated_school = graduated_school;
    }

    public void setBrother(String brother) {
        this.brother = brother;
    }

    public void setComefrom(String comefrom) {
        this.comefrom = comefrom;
    }

    public void setDaily_report(String daily_report) {
        this.daily_report = daily_report;
    }

    public void setAims(String aims) {
        this.aims = aims;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQq(int qq) {
        this.qq = qq;
    }

    public String getName() {
        return name;
    }

    public String getObject() {
        return object;
    }

    public String getGraduated_school() {
        return graduated_school;
    }

    public String getBrother() {
        return brother;
    }

    public String getComefrom() {
        return comefrom;
    }

    public String getDaily_report() {
        return daily_report;
    }

    public String getAims() {
        return aims;
    }

    public int getId() {
        return id;
    }

    public int getQq() {
        return qq;
    }

    @Override
    public String toString(){
        return "id: " + id
                + ", name: " + name
                + ", object: " + object
                + ", aims: " + aims
                + ", qq: " + qq
                + ", brother: " + brother
                + ", from: " + comefrom
                + ", graduated_school: " + graduated_school
                + ", daily_report: " + daily_report;
    }
}
