package com.example.demo.service.interfaces.base;

import com.example.demo.repository.base.BaseRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.glasnost.orika.MapperFacade;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@Data
public abstract class BaseService<T, Dto, Id, R extends BaseRepository<T, Id>>
        implements IService<Dto, Id>, GenericQuery<T> {

    private Class<T> entityClass;
    private Class<Dto> dtoClass;
    private R repository;
    private MapperFacade mapper;

    public BaseService(Class<T> entityClass, Class<Dto> dtoClass, R repository, MapperFacade mapper) {
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
        this.repository = repository;
        this.mapper = mapper;
    }

    public Optional<Dto> findById(Id id) {
        return repository.findById(id).map(e -> mapper.map(e, dtoClass));
    }

    @Override
    public List<Dto> findAll() {
        return mapper.mapAsList(repository.findAll(), dtoClass);
    }

    @Override
    public void delete(Dto t) {
        repository.delete(mapper.map(t, entityClass));
    }

    @Override
    public Dto save(Dto t) {
        T saveEntity = mapper.map(t, entityClass);
        return mapper.map(repository.save(saveEntity), dtoClass);
    }

    @Override
    public List<Dto> saveAll(Iterable<Dto> ts) {
        List<T> saveEntities = mapper.mapAsList(ts, entityClass);
        return mapper.mapAsList(repository.saveAll(saveEntities), dtoClass);
    }
}
