package my.work.springbootcrudvalidation.projection;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import my.work.springbootcrudvalidation.validation.OnCreate;
import my.work.springbootcrudvalidation.validation.OnUpdate;

public record DepartmentProjection(

        @Null(message = "department.id.not.null", groups = {OnCreate.class, OnUpdate.class})
        Integer id,

        @NotBlank(message = "department.name.not.blank", groups = {OnCreate.class, OnUpdate.class})
        String name,

        @NotBlank(message = "department.description.not.blank", groups = {OnCreate.class, OnUpdate.class})
        String description) {
}
