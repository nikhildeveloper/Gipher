import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root',
})
export class GiphyService {
  constructor(private httpClient: HttpClient) {}

  private limit: number = 50;

  getGif(): Observable<any> {
    return this.httpClient.get(environment.apiGatewayUrl+"/gif-api/gif/trending");
  }
  getGifbyparameters(query: string): Observable<any> {
    return this.httpClient.get(environment.apiGatewayUrl+"/gif-api/gif/"+query);
  }
}