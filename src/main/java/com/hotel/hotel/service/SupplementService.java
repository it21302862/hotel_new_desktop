package com.hotel.hotel.service;

import com.hotel.hotel.DTO.SupplementDTO;
import com.hotel.hotel.entity.Supplement;
import com.hotel.hotel.repo.SupplementRepo;
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
public class SupplementService {

    @Autowired
    private SupplementRepo supplementRepo;

    @Autowired
    private ModelMapper modelMapper;

    public String saveSupplement(SupplementDTO supplementDTO){

        if(supplementRepo.existsById(supplementDTO.getSupplementID())){

            return VarList.RSP_DUPLICATED;
        }
        else{

            supplementRepo.save(modelMapper.map(supplementDTO, Supplement.class));
            return VarList.RSP_SUCCESS;
        }
    }


    public String updateSupplement(SupplementDTO supplementDTO){

        if(supplementRepo.existsById(supplementDTO.getSupplementID())){

            supplementRepo.save(modelMapper.map(supplementDTO,Supplement.class));

            return VarList.RSP_SUCCESS;

        }
        else {

            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public List<SupplementDTO> getAllSupplement(){

        List<Supplement> SupplimentList = supplementRepo.findAll();
        return modelMapper.map(SupplimentList,new TypeToken<ArrayList<SupplementDTO>>(){

        }.getType());
    }


    public SupplementDTO searchSupplement(int supplementNo ){
        if(supplementRepo.existsById(supplementNo)){

            Supplement supplement= supplementRepo.findById(supplementNo).orElse(null);
            return modelMapper.map(supplement,SupplementDTO.class);
        }

        else{
            return  null;
        }
    }



    public String deleteSupplement(int supplementNo){
        if (supplementRepo.existsById(supplementNo)){
            supplementRepo.deleteById(supplementNo);
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

}
