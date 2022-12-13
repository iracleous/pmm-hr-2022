package gr.pmm.pmmhr2022.controller;

import gr.pmm.pmmhr2022.exception.EmployeeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestControllerAdvice
public class HrErrorController {

    @ExceptionHandler(EmployeeException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public void employeeError(){
        log.error("Employee not created");
    }
}
