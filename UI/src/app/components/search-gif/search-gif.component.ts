import { Component, OnInit } from '@angular/core';
import{GiphyService}from"src/app/services/api/giphy.service";
import { Fav } from 'src/app/models/db';
import { ModifierService } from 'src/app/services/favorites/modifier.service';
@Component({
  selector: 'app-search-gif',
  templateUrl: './search-gif.component.html',
  styleUrls: ['./search-gif.component.css']
})
export class SearchGifComponent implements OnInit {
constructor(private gs:GiphyService,private ms:ModifierService) { }
gigs:any[]=[]
  ngOnInit(): void {}
  search(query:string){
    if(query!=""){
      this.gs.getGifbyparameters(query).subscribe(sata=>{
      this.gigs=sata.data;
        console.log(sata.data);
        return this.gigs;
      });
    }
  }
  addtofavs(value:string){
    // console.log(value);
    this.addtofavorites(value);
  }
  addtofavorites(value:string){
    this.ms.addtofavs(new Fav(value)).subscribe(data=>{
      console.warn(data);
    });
  }
}
