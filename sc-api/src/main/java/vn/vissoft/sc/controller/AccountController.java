package vn.vissoft.sc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.vissoft.sc.dto.request.paging.PagingAndSorting;
import vn.vissoft.sc.dto.request.paging.PagingAndSortingParam;
import vn.vissoft.sc.dto.response.Response;
import vn.vissoft.sc.dto.response.ResponseBody;
import vn.vissoft.sc.service.AccountService;

@CrossOrigin("*")
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/account/page")
    public ResponseEntity<ResponseBody> listByPage(@PagingAndSortingParam PagingAndSorting pagingAndSorting) {
        return new ResponseEntity<>(new ResponseBody(Response.SUCCESS, accountService.listByPage(pagingAndSorting)), HttpStatus.OK);
    }

}
