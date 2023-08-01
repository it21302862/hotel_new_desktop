package com.hotel.hotel.service;


import com.hotel.hotel.DTO.MarkupDTO;
import com.hotel.hotel.entity.Markup;
import com.hotel.hotel.repo.MarkupRepo;
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
public class MarkupService {

    @Autowired
    private MarkupRepo markupRepo;

    @Autowired
    private ModelMapper modelMapper;


    //save Markup
    public String saveMarkup(MarkupDTO markupDTO){

        if(markupRepo.existsById(markupDTO.getMarkupID())){

            return VarList.RSP_DUPLICATED;
        }
        else{

            markupRepo.save(modelMapper.map(markupDTO, Markup.class));
            return VarList.RSP_SUCCESS;
        }
    }


    //update markup

    public String updateMarkup(MarkupDTO markupDTO){

        if(markupRepo.existsById(markupDTO.getMarkupID())){

            markupRepo.save(modelMapper.map(markupDTO,Markup.class));

            return VarList.RSP_SUCCESS;

        }
        else {

            return VarList.RSP_NO_DATA_FOUND;
        }
    }


    // view all markup
    public List<MarkupDTO> getAllMarkup(){

        List<Markup> MarkupList = markupRepo.findAll();
        return modelMapper.map(MarkupList,new TypeToken<ArrayList<MarkupDTO>>(){

        }.getType());
    }



    //Delete markup
    public String deleteMarkup(int markupID){
        if (markupRepo.existsById(markupID)){
            markupRepo.deleteById(markupID);
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }


}
