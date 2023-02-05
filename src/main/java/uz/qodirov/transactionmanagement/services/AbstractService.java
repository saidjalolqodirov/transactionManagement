package uz.qodirov.transactionmanagement.services;

import uz.qodirov.transactionmanagement.mapper.Mapper;
import uz.qodirov.transactionmanagement.repository.BaseRepository;

/**
 * @author: Saidjalol Qodirov 2/4/2023 11:31 PM
 */
public abstract class AbstractService<
        R extends BaseRepository,
        M extends Mapper> implements BaseService {

    protected R repository;
    protected M mapper;

    protected AbstractService(R repository, M mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
}
