package vn.vissoft.sc.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class AccountFilter {
    private String username;
    private String fullName;
    private Integer accountType;
    private Date lastLoginTime;
    private Date createdTime;
    private Integer status;
}
