package my.work.springbootcrudvalidation.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import my.work.springbootcrudvalidation.projection.DepartmentProjection;
import my.work.springbootcrudvalidation.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/departments")
@RestController
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    DepartmentProjection create(@RequestBody @Valid DepartmentProjection projection) {
        return departmentService.create(projection);
    }

}
