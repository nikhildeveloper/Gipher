import { Component, OnInit } from '@angular/core';
import { Fav } from 'src/app/models/db';
import { GiphyService } from 'src/app/services/api/giphy.service';
import { ModifierService } from 'src/app/services/favorites/modifier.service';

@Component({
  selector: 'app-sctrending',
  templateUrl: './sctrending.component.html',
  styleUrls: ['./sctrending.component.css']
})
export class SctrendingComponent implements OnInit {

  constructor(private gs:GiphyService,private ms:ModifierService) { }
  gifs:any[]=[];
  ngOnInit(): void {
    this.gs.getGif().subscribe(sata=>{
      this.gifs=sata.data;
      console.log(this.gifs);
    });
  }
  addtofavs(value:string){
    this.addtofavorites(value);
  }
  addtofavorites(value:string){
    this.ms.addtofavs(new Fav(value)).subscribe(data=>{
      console.warn(data);
    });
  }
}
