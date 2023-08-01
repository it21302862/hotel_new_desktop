package com.hotel.hotel.controller;

import com.hotel.hotel.DTO.HotelContractDTO;
import com.hotel.hotel.DTO.HotelDTO;
import com.hotel.hotel.DTO.ResponseDTO;
import com.hotel.hotel.entity.HotelContract;
import com.hotel.hotel.service.HotelContractService;
import com.hotel.hotel.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/v1/hotels")
@CrossOrigin
public class HotelContractController {

    @Autowired
    private HotelContractService hotelContractService;
    @Autowired
    private ResponseDTO responseDTO;

    @GetMapping("/getAllHotelContracts")
    public ResponseEntity getAllHotelContracts() {
        try {
            List<HotelContractDTO> hotelContractDTOList= hotelContractService.getAllHotelContracts();
            responseDTO.setCode(VarList.RSP_SUCCESS);
            responseDTO.setMessage("Success");
            responseDTO.setContent(hotelContractDTOList);
            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @PostMapping("/saveHotelContracts")
    public ResponseEntity saveHotelContract(@RequestBody HotelContractDTO hotelContractDTO) {
        try {
            String res = hotelContractService.saveHotelContract(hotelContractDTO);
            if (res.equals("00")) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(hotelContractDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            } else if (res.equals("06")) {
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("Hotel Contract Registered");
                responseDTO.setContent(hotelContractDTO);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            } else {
                responseDTO.setCode(VarList.RSP_FAIL);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }

        } catch (Exception ex) {
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @GetMapping(value = "/searchHotelContract/{contractID}")
    public ResponseEntity searchHotel(@PathVariable int contractID) {
        try {
            HotelContractDTO hotelContractDTO= hotelContractService.searchHotelContracts(contractID);
            if(hotelContractDTO!=null) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(hotelContractDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            }
            else {
                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("No Hotel Contract Available For this hotelContractID");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }
        }
        catch (Exception ex) {
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @PutMapping(value = "/updateHotelContract")
    public ResponseEntity updateHotelContract(@RequestBody HotelContractDTO hotelContractDTO) {
        try {
            String res = hotelContractService.updateHotelContract(hotelContractDTO);
            if (res.equals("00")) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(hotelContractDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            } else if (res.equals("01")) {
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("Not a Registered Hotel Contract");
                responseDTO.setContent(hotelContractDTO);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            } else {
                responseDTO.setCode(VarList.RSP_FAIL);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }

        } catch (Exception ex) {
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @DeleteMapping("/deleteHotel/{contractID}")
    public ResponseEntity deleteHotel(@PathVariable int contractID){
        try {
            String res = hotelContractService.deleteHotelContract(contractID);
            if (res.equals("00")) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else {
                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("No Hotel Contract Available For this hotelContractID");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(e.getMessage());
            responseDTO.setContent(e);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{contractID}/hotel/{hotelID}")
    public ResponseEntity<HotelContract> assignHotelToContract(
            @PathVariable int contractID,
            @PathVariable int hotelID
    ) {
        HotelContract assignedContract = hotelContractService.assignHotelToContract(contractID, hotelID);
        if (assignedContract != null) {
            return new ResponseEntity<>(assignedContract, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
