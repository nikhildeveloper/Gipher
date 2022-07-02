package com.stackroute.project.Repository;


import com.stackroute.project.wishlist.models.Favorite;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FavoriteRepository extends MongoRepository<Favorite, Integer> {

    @Query("{userId: ?0}")  //from  Favorites where userId = :userId
    Slice<Favorite> getWishList(Integer userId, Pageable pageable);


    @Query("{userId: ?0,url: ?1}")
    Favorite findWishlistEntityByUserIdAndUrl(Integer userId,String url);

    Optional<Favorite> findByUserIdAndUrl(Integer userId,String url);

    void deleteFavoritesById(long id);
}
