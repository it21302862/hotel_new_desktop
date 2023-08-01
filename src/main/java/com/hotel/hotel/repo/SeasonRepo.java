package com.hotel.hotel.repo;

import com.hotel.hotel.entity.Season;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonRepo extends JpaRepository<Season,String > {
    boolean existsBySeasonName(String seasonName);
}
