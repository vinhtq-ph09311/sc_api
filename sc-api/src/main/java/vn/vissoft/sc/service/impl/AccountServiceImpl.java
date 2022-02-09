package vn.vissoft.sc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.vissoft.sc.dto.AccountDTO;
import vn.vissoft.sc.dto.request.paging.PagingAndSorting;
import vn.vissoft.sc.dto.response.PageResponse;

import vn.vissoft.sc.repository.AccountRepository;
import vn.vissoft.sc.service.AccountService;

@Service
@Transactional(readOnly = true)
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepo;

    @Override
    public PageResponse<AccountDTO> listByPage(PagingAndSorting pagingAndSorting) {
        Page<AccountDTO> page;
        Pageable pageable = pagingAndSorting.createPageable();

        if (pagingAndSorting.getKeyword() == null) {
            page = accountRepo.getByPage(pageable);
        } else {
            page = accountRepo.getByPage(pagingAndSorting.getKeyword(), pageable);
        }

        return new PageResponse<>(page);
    }


}
