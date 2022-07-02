import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { GiphyService } from 'src/app/services/api/giphy.service';
import { RegisterLoginService } from 'src/app/services/login-register/register-login.service';
@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  constructor(private gs:GiphyService, private loginService:RegisterLoginService,private router: Router) { }

  ngOnInit(): void {
  }

gigs:any[]=[];
// this.sg.search(query:string){}
// gifs:any[]

search(query:string){
  if(query!=""){
    this.gs.getGifbyparameters(query).subscribe(sata=>{
    this.gigs=sata.data;
      console.log(sata.data);
      return this.gigs;
    });
  }
}
logout()
{
  this.loginService.logout();
  this.router.navigate(['/login']);


}

}

