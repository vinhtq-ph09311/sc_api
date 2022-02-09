package vn.vissoft.sc.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import vn.vissoft.sc.dto.AccountDTO;
import vn.vissoft.sc.entity.Account;

import java.util.Date;

public interface AccountRepository extends PagingAndSortingRepository<Account, Integer>, AccountRepositoryCustom {

    @Query("SELECT NEW vn.vissoft.sc.dto.AccountDTO(a.accountId, a.username, a.fullName, a.accountType, a.loginFailureCount, a.lastLoginTime, a.createdTime, a.status) FROM Account a")
    Page<AccountDTO> getByPage(Pageable pageable);

    @Query("SELECT NEW vn.vissoft.sc.dto.AccountDTO(a.accountId, a.username, a.fullName, a.accountType, a.loginFailureCount, a.lastLoginTime, a.createdTime, a.status) FROM Account a" +
            " WHERE LOWER(a.username) LIKE LOWER(CONCAT('%', :keyword, '%'))" +
            " OR LOWER(a.fullName) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    Page<AccountDTO> getByPage(String keyword, Pageable pageable);

    @Query("SELECT NEW vn.vissoft.sc.dto.AccountDTO(a.accountId, a.username, a.fullName, a.accountType, a.loginFailureCount, a.lastLoginTime, a.createdTime, a.status) FROM Account a" +
            " WHERE (:username IS NULL OR LOWER(a.username) LIKE LOWER(CONCAT('%', :username, '%')))" +
            " AND (:fullName IS NULL OR LOWER(a.fullName) LIKE LOWER(CONCAT('%', :fullName, '%')))" +
            " AND (:accountType IS NULL OR a.accountType = :accountType)" +
            " AND (:lastLoginTime IS NULL OR a.lastLoginTime = :lastLoginTime)" +
            " AND (:createdTime IS NULL OR a.createdTime = :createdTime)" +
            " AND (:status IS NULL OR a.status = :status)")
    Page<AccountDTO> getByPage(@Param("username") String username,
                               @Param("fullName") String fullName,
                               @Param("accountType") Integer accountType,
                               @Param("lastLoginTime") Date lastLoginTime,
                               @Param("createdTime") Date createdTime,
                               @Param("status") Integer status,
                               Pageable pageable);

}
