package my.work.springbootcrudvalidation.projection;

import jakarta.validation.constraints.NotBlank;

public record DepartmentProjection(

        Integer id,

        @NotBlank(message = "Department's name can't be blank")
        String name,

        @NotBlank(message = "Department's description can't be blank")
        String description) {
}
