package com.LinguaNova.IdiomaGo.persistence.repository;

import com.LinguaNova.IdiomaGo.persistence.entity.FavoriteEntity;
import com.LinguaNova.IdiomaGo.persistence.entity.FavoriteId;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFavoriteRepository extends JpaRepository<FavoriteEntity, FavoriteId> {
	@Query("SELECT f FROM FavoriteEntity f WHERE f.user.id = :userId")
	List<FavoriteEntity> findAllByUserId(@Param("userId") Long userId);
}
