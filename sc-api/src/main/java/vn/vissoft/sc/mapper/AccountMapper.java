package vn.vissoft.sc.mapper;

import org.mapstruct.Mapper;
import vn.vissoft.sc.dto.AccountDTO;
import vn.vissoft.sc.entity.Account;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountDTO entityToDTO(Account account);

    List<AccountDTO> listEntityToDTO(List<Account> accountList);
}
