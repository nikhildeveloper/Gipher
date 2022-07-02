package com.stackroute.project.service;

import com.stackroute.project.Repository.FavoriteRepository;
import com.stackroute.project.Repository.SequenceDao;
import com.stackroute.project.common.messages.BaseResponse;
import com.stackroute.project.common.messages.CustomMessage;
import com.stackroute.project.dto.Topic;
import com.stackroute.project.dto.WishListDTO;
import com.stackroute.project.wishlist.models.Favorite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//https://media2.giphy.com/media/R6gvnAxj2ISzJdbA63/giphy.gif?cid=0722c355utpo4ofiyvdtriu10wvlp9wlqv73v2pv1wyisjs8&rid=giphy.gif&ct=g

@Service
@Transactional
public class WishlistService {

    private static final String HOSTING_SEQ_KEY = "counting";

    @Autowired
    FavoriteRepository favoriteRepository;

    @Autowired
    SequenceDao sequenceDao;

    public BaseResponse createWishList(WishListDTO wishListDTO){
        //Favorite checkDuplicate=favoriteRepository.findWishListByUrlAndId(wishListDTO.getUrl().toLowerCase(),wishListDTO.getUserId());
        Optional<Favorite> checkDuplicate=favoriteRepository.findByUserIdAndUrl(wishListDTO.getUserId(),wishListDTO.getUrl());
        if(checkDuplicate.isPresent()){
            return new BaseResponse( CustomMessage.RECOURD_FOUND_WISHLISH, HttpStatus.CREATED.value());
        }else {
            Favorite favorite = new Favorite();
            favorite.setUrl(wishListDTO.getUrl());
            favorite.setUserId(wishListDTO.getUserId());
            try{
                favorite.setId(sequenceDao.getNextSequenceId(HOSTING_SEQ_KEY));
            }catch(Exception e){
                new BaseResponse("addition to database failed due to error in sequence generation",HttpStatus.INTERNAL_SERVER_ERROR.value());
            }

            favoriteRepository.save(favorite);
            return new BaseResponse(Topic.WishList.getName() + CustomMessage.SAVE_SUCCESS_MESSAGE, HttpStatus.CREATED.value());
        }
    }

    public BaseResponse deleteWishList(long id){
        favoriteRepository.deleteFavoritesById(id);
        return new BaseResponse(Topic.WishList.getName() + CustomMessage.DELETE_SUCCESS_MESSAGE, HttpStatus.CREATED.value());
    }

    public List<WishListDTO> getWishList(int  userId){
        Pageable pageable = PageRequest.of(0, 25, Sort.by(Sort.Order.desc("id")));
        List<Favorite> wishListEntityList=favoriteRepository.getWishList(userId,pageable).getContent();
        List<WishListDTO> copy = new ArrayList<>();
        WishListDTO wishList=null;
        for(Favorite wishListEntity:wishListEntityList){
            wishList=new WishListDTO();
            wishList.setId(wishListEntity.getId());
            wishList.setUserId(wishListEntity.getUserId());
            wishList.setUrl(wishListEntity.getUrl());
            copy.add(wishList);
        }
        return copy;
    }
}
