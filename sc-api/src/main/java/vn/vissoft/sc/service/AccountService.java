package vn.vissoft.sc.service;

import vn.vissoft.sc.dto.AccountDTO;
import vn.vissoft.sc.dto.request.paging.PagingAndSorting;
import vn.vissoft.sc.dto.response.PageResponse;

public interface AccountService {
    PageResponse<AccountDTO> listByPage(PagingAndSorting pagingAndSorting);
}
