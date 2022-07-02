package com.stackroute.project.controller;

import com.stackroute.project.common.messages.BaseResponse;
import com.stackroute.project.dto.WishListDTO;
import com.stackroute.project.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {

    @Autowired
    WishlistService wishlistService;

    @PostMapping(value = { "/add" })
    public ResponseEntity<BaseResponse> createWishList( @RequestBody WishListDTO wishListDTO) {
        BaseResponse response = wishlistService.createWishList(wishListDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value = { "/delete" })
    public ResponseEntity<BaseResponse> deleteWishList( @RequestParam int id) {
        BaseResponse response = wishlistService.deleteWishList(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = { "/getAll" })
    public ResponseEntity<List<WishListDTO>> getWishListById( @RequestParam int userId) {
        List<WishListDTO> response = wishlistService.getWishList(userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
