package vn.vissoft.sc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AccountDTO implements Serializable {
    @JsonProperty("account_id")
    private Integer accountId;
    private String username;
    @JsonProperty("full_name")
    private String fullName;
    @JsonProperty("account_type")
    private Integer accountType;
    @JsonProperty("login_failure_count")
    private Integer loginFailureCount;
    @JsonProperty("last_login_time")
    private Date lastLoginTime;
    @JsonProperty("create_time")
    private Date createdTime;
    private Integer status;

    public AccountDTO(Integer accountId, String username, String fullName, Integer accountType, Integer loginFailureCount, Date lastLoginTime, Date createdTime, Integer status) {
        this.accountId = accountId;
        this.username = username;
        this.fullName = fullName;
        this.accountType = accountType;
        this.loginFailureCount = loginFailureCount;
        this.lastLoginTime = lastLoginTime;
        this.createdTime = createdTime;
        this.status = status;
    }
}
