package com.hg.crud.repositories;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.hg.crud.models.categorias;

public interface CategoriaRepositoryDao extends MongoRepository<categorias,String> {

}
