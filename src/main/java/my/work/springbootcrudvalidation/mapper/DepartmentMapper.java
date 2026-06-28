package my.work.springbootcrudvalidation.mapper;

import my.work.springbootcrudvalidation.entity.DepartmentEntity;
import my.work.springbootcrudvalidation.projection.DepartmentProjection;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    DepartmentEntity toEntity(DepartmentProjection department);

    DepartmentProjection toProjection(DepartmentEntity department);

    List<DepartmentEntity> toEntity(List<DepartmentEntity> departments);

    List<DepartmentProjection> toProjection(List<DepartmentEntity> departments);

}
