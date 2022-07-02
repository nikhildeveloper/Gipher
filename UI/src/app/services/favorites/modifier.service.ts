import { Injectable } from '@angular/core';
import{HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Fav } from 'src/app/models/db';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ModifierService {

  constructor(private httpclient:HttpClient) { }
  getFavoritesgif():Observable<any>{
    return this.httpclient.get<Fav[]>(environment.apiGatewayUrl+"/wishlist-api/wishlist/getAll?userId="+localStorage.getItem("id"));
  }
  addtofavs(imgurl:Fav):Observable<any>{

    let params = {
      "userId":localStorage.getItem("id"),
      "url":imgurl.url
    };
      
    let headers = new HttpHeaders({'Content-type': 'application/json'});
    let options = ({ headers: headers });
    
    return this.httpclient.post<Fav>(environment.apiGatewayUrl+"/wishlist-api/wishlist/add",params, options);
  }
  removefromfavs(id:String):Observable<any>{
    return this.httpclient.delete<Fav>(environment.apiGatewayUrl+"/wishlist-api/wishlist/delete?id="+id);
  }
}
