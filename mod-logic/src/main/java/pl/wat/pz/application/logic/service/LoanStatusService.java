package pl.wat.pz.application.logic.service;

import java.util.List;

/**
 * Created by DELL on 2016-12-10.
 */
public interface LoanStatusService {
    List<String> findAllLoanStatusName(String language);
}
