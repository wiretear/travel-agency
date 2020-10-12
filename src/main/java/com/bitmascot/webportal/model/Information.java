package com.bitmascot.webportal.model;

import javax.persistence.*;

@Entity
@Table(name="information")
public class Information {
    @Column(name="privacytype")
    private String privacytype="";
    @Column(name="checkInPlace")
    private String checkinPlace="";
    @Column(name="status")
    private String status="";
    @Column(name="user_name")
    private String user_name="";

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    @Override
    public String toString() {
        return "Information{" +
                "id=" + id +
                ", privacytype='" + privacytype + '\'' +
                ", checkinPlace='" + checkinPlace + '\'' +
                ", status='" + status + '\'' +
                ", flag='" + flag + '\'' +
                ", mailId='" + mailId + '\'' +
                '}';
    }
    public String getPrivacyType() {
        return privacytype;
    }

    public void setPrivacyType(String privacyType) {
        this.privacytype = privacyType;
    }

    public String getCheckInPlace() {
        return checkinPlace;
    }

    public void setCheckInPlace(String checkInPlace) {
        this.checkinPlace = checkInPlace;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    @Column(name="flag")
    private String flag="";

    @Column(name="mailid")
    private String mailId="";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
