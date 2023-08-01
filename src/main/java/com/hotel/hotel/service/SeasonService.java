package com.hotel.hotel.service;

import com.hotel.hotel.DTO.SeasonDTO;
import com.hotel.hotel.entity.Season;
import com.hotel.hotel.repo.SeasonRepo;
import com.hotel.hotel.util.VarList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SeasonService {

    @Autowired
    private SeasonRepo seasonRepo;

    @Autowired
    private ModelMapper modelMapper;

    //save season
    public  String  saveSeason(SeasonDTO seasonDTO){

        if(seasonRepo.existsBySeasonName(String.valueOf(seasonDTO.getSeasonName()))){

            return VarList.RSP_DUPLICATED;
        }
        else{

            seasonRepo.save(modelMapper.map(seasonDTO, Season.class));
            return VarList.RSP_SUCCESS;
        }
    }


    //update season
    public String updateSeasondate(SeasonDTO seasonDTO){

        if(seasonRepo.existsBySeasonName(String.valueOf(seasonDTO.getSeasonName()))){

            seasonRepo.save(modelMapper.map(seasonDTO,Season.class));

            return VarList.RSP_SUCCESS;

        }
        else {

            return VarList.RSP_NO_DATA_FOUND;
        }
    }


    //show season list
    public List<SeasonDTO> getAllSeasons(){

        List<Season> seasonList = seasonRepo.findAll();
        return modelMapper.map(seasonList,new TypeToken<ArrayList<SeasonDTO>>(){

        }.getType());
    }
}
