import { Component, OnInit } from '@angular/core';
import { RegisterLoginService } from 'src/app/services/login-register/register-login.service';
import { Userinfo } from 'src/app/models/Userinfo';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user=new Userinfo();
  message="";
  constructor(private rls:RegisterLoginService,private router:Router) { }
  ngOnInit(): void {
  }
  loginUser()
  {
    this.rls.loginUserfromBackend(this.user).subscribe(
    response=>{
      console.log(response);
      this.rls.saveToken(response);
      this.router.navigate(['/Trending']);
      console.log(this.rls.getToken());
    },
    error=>{
      console.log(error);
      this.message="Invalid Credentials Try Again";
    }
    );
  }
}
