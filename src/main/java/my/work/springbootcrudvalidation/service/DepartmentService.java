package my.work.springbootcrudvalidation.service;

import lombok.RequiredArgsConstructor;
import my.work.springbootcrudvalidation.entity.DepartmentEntity;
import my.work.springbootcrudvalidation.exception.ResourceNotFoundException;
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

    public DepartmentProjection read(int id) {
        var entity = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Department with id %d doesn't exist on database", id)));

        return departmentMapper.toProjection(entity);
    }

    public DepartmentProjection updateEntity(DepartmentProjection projection, int id) {
        var entity = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Department with id %d doesn't exist on database", id)));

        updateEntity(entity, projection);
        entity = departmentRepository.save(entity);

        return departmentMapper.toProjection(entity);
    }

    private static void updateEntity(DepartmentEntity entity, DepartmentProjection projection) {
        entity.setName(projection.name());
        entity.setDescription(projection.description());
    }

}
