package vn.vissoft.sc.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "tbl_account")
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Integer accountId;

    private String username;

    private String password;

    @Column(name = "full_name")
    private String fullName;

    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "description")
    private String description;

    @Column(name = "account_type")
    private Integer accountType;

    @Column(name = "created_time")
    private Date createdTime;

    @Column(name = "updated_time")
    private Date updatedTime;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "login_failure_count")
    private Integer loginFailureCount;

    @Column(name = "first_login")
    private boolean firstLogin;

    @Column(name = "last_login_time")
    private Date lastLoginTime;

    @Column(name = "last_change_pass")
    private Date lastChangePass;

    @Column(name = "locked_time")
    private Date lockedTime;

    @Column(name = "auto_password")
    private Integer autoPassword;

    private Integer status;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account() {

    }

    public Account(Integer accountId, String username) {
        this.accountId = accountId;
        this.username = username;
    }
}
