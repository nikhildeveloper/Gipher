import { Component, OnInit } from '@angular/core';
import { ModifierService } from 'src/app/services/favorites/modifier.service';
import{ Fav } from 'src/app/models/db';
@Component({
  selector: 'app-favorites',
  templateUrl: './favorites.component.html',
  styleUrls: ['./favorites.component.css']
})
export class FavoritesComponent implements OnInit {
  favorites:Fav[]=[];

  constructor(private ms:ModifierService) { }
  ngOnInit(): void {
    this.ms.getFavoritesgif().subscribe(sata=>{
      this.favorites=sata;
      console.log(sata);   
      console.warn(this.favorites);
    });
  }
  removeFromFavorites(id:string){
    this.ms.removefromfavs(id).subscribe(data=>{
      this.ms.getFavoritesgif().subscribe(sata=>{
        this.favorites=sata;
      })
    });
  }
}
