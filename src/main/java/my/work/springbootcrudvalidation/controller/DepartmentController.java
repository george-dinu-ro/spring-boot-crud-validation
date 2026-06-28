package my.work.springbootcrudvalidation.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import my.work.springbootcrudvalidation.projection.DepartmentProjection;
import my.work.springbootcrudvalidation.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/departments")
@RestController
@Validated
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    DepartmentProjection create(@RequestBody @Valid DepartmentProjection projection) {
        return departmentService.create(projection);
    }

    @GetMapping
    List<DepartmentProjection> read() {
        return departmentService.read();
    }

    @GetMapping("/{id}")
    DepartmentProjection read(@PathVariable @Positive(message = "Department's id should be positive") int id) {
        return departmentService.read(id);
    }

    @PutMapping("/{id}")
    DepartmentProjection update(@RequestBody DepartmentProjection projection, @PathVariable int id) {
        return departmentService.updateEntity(projection, id);
    }

}
