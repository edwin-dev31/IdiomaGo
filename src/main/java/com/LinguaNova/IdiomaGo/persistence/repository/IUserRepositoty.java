package com.LinguaNova.IdiomaGo.persistence.repository;

import com.LinguaNova.IdiomaGo.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepositoty extends JpaRepository<UserEntity, Long> {

}
