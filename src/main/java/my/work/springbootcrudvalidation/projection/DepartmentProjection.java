package my.work.springbootcrudvalidation.projection;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import my.work.springbootcrudvalidation.validation.OnCreate;
import my.work.springbootcrudvalidation.validation.OnUpdate;

public record DepartmentProjection(

        @Null(message = "Department's id must be null", groups = {OnCreate.class, OnUpdate.class})
        Integer id,

        @NotBlank(message = "Department's name can't be blank", groups = {OnCreate.class, OnUpdate.class})
        String name,

        @NotBlank(message = "Department's description can't be blank", groups = {OnCreate.class, OnUpdate.class})
        String description) {
}
