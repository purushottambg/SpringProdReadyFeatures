package com.prod_ready_features.prodready.auth;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImp implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor(){
        //Actual steps to return current Auditor are
        //  1. get Security context
        //  2. get authentication
        //  3. get the principal
        //  4. get the username and then return as Optional.of(username)
        return Optional.of("Purushottam a SringBoot Developer");
    }
}
