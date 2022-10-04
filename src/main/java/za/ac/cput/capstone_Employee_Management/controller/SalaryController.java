package za.ac.cput.capstone_Employee_Management.controller;
/*
 Author: Taariq Khan (219231141)
 Date: September 2022
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.capstone_Employee_Management.domain.Salary;
import za.ac.cput.capstone_Employee_Management.service.impl.SalaryServiceImpl;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping ("employee-management/salary/")
public class SalaryController
{
    final SalaryServiceImpl salaryService ;

    @Autowired
    public SalaryController(SalaryServiceImpl salaryService)
    {
        this.salaryService = salaryService;
    }

    @PostMapping("save")
    public ResponseEntity<Salary> save(@RequestBody @Valid Salary salary)
    {
        Salary save = salaryService.save(salary);
        return ResponseEntity.ok(save);
    }

    @PostMapping("read/{ID}")
    public ResponseEntity<Salary> read (@PathVariable Long ID)
    {
        Salary read = salaryService.read(ID).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(read);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete (Salary salary)
    {
        this.salaryService.delete(salary);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("deleteById/{ID}")
    public ResponseEntity<Void> delete (@PathVariable Long ID)
    {
        this.salaryService.deleteByID(ID);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Salary>> findAll()
    {
        List<Salary> salaryList = salaryService.findAll();
        return ResponseEntity.ok(salaryList);

    }


}