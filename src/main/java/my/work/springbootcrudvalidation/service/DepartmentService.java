package my.work.springbootcrudvalidation.service;

import lombok.RequiredArgsConstructor;
import my.work.springbootcrudvalidation.mapper.DepartmentMapper;
import my.work.springbootcrudvalidation.projection.DepartmentProjection;
import my.work.springbootcrudvalidation.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    private final DepartmentMapper departmentMapper;

    public DepartmentProjection create(DepartmentProjection projection) {
        var entity = departmentMapper.toEntity(projection);
        entity = departmentRepository.save(entity);

        return departmentMapper.toProjection(entity);
    }

    public List<DepartmentProjection> read() {
        var entities = departmentRepository.findAll();
        return departmentMapper.toProjection(entities);
    }

}
