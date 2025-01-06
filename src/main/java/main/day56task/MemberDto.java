package main.day56task;

public class MemberDto {
    private int mno;
    private String mid;
    private String mpwd;
    private String mname;
    private String mnuber;

    public MemberDto() {
    }

    public MemberDto(String mid, String mpwd) {
        this.mid = mid;
        this.mpwd = mpwd;
    }

    public MemberDto(int mno, String mid, String mpwd, String mname, String mnuber) {
        this.mno = mno;
        this.mid = mid;
        this.mpwd = mpwd;
        this.mname = mname;
        this.mnuber = mnuber;
    }

    public int getMno() {
        return mno;
    }

    public void setMno(int mno) {
        this.mno = mno;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getMpwd() {
        return mpwd;
    }

    public void setMpwd(String mpwd) {
        this.mpwd = mpwd;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMnuber() {
        return mnuber;
    }

    public void setMnuber(String mnuber) {
        this.mnuber = mnuber;
    }

    @Override
    public String toString() {
        return "MemberDto{" +
                "mno=" + mno +
                ", mid='" + mid + '\'' +
                ", mpwd='" + mpwd + '\'' +
                ", mname='" + mname + '\'' +
                ", mnuber='" + mnuber + '\'' +
                '}';
    }
}
