package com.loki.accounts.controller;

import com.loki.accounts.constants.AccountsConstants;
import com.loki.accounts.dto.CustomerDto;
import com.loki.accounts.dto.ResponseDto;
import com.loki.accounts.service.iAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api",produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class AccountController {

    private iAccountsService iAccountsService;


    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto){

        iAccountsService.createAccount(customerDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstants.STATUS_201,AccountsConstants.MESSAGE_201));

    }

    /**
     * Return a friendly greeting.
     * @return a greeting
     */
    @GetMapping
    public String sayHello(){
        return "Hi World";
    }
}
