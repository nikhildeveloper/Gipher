import { Injectable } from '@angular/core';
import{HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Userinfo } from 'src/app/models/Userinfo';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RegisterLoginService {

  constructor(private http:HttpClient) { }

  public loginUserfromBackend(user:Userinfo):Observable<any>{
    return this.http.post(environment.apiGatewayUrl+"/user-api/authenticate/v1/loginuser",user);
  }
  public registerUserfromBackend(user:Userinfo):Observable<any>{
    return this.http.post(environment.apiGatewayUrl+"/user-api/authenticate/v1/registeruser",user);
  }
  public changepasswordfromBackend(user:Userinfo):Observable<any>{
    return this.http.post(environment.apiGatewayUrl+"/user-api/authenticate/v1/password",user);
  }
  //save token in local storage
  saveToken(response:any)
  {
    localStorage.setItem("token",response.token);
    localStorage.setItem("id",response.id);
    return true;
  }
  //check whether token is available in local storage
  isLoggedIn()
  {
    let token=localStorage.getItem("token");
    if(token==undefined || token==='' || token==null)
    {
      return false;
    }
    else
  {
    return true;
  }
  //to logout user
  }
  logout()
  {
    localStorage.removeItem("token");
    localStorage.removeItem("id");
    return true;
  }
  //to get token from local storage
  getToken()
  {
    return localStorage.getItem("token");
  }
}  
