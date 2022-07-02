import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Userinfo } from 'src/app/models/Userinfo';
import { RegisterLoginService } from 'src/app/services/login-register/register-login.service';

@Component({
  selector: 'app-forget-password',
  templateUrl: './forget-password.component.html',
  styleUrls: ['./forget-password.component.css']
})
export class ForgetPasswordComponent implements OnInit {
  message='';
  user=new Userinfo();
  constructor(private rls:RegisterLoginService,private router:Router) { }

  ngOnInit(): void {
  }
  changepassword()
  {
    this.rls.changepasswordfromBackend(this.user).subscribe(response=>{
      console.log(response);
      this.message="Password Changed Successfully";
      console.log(this.message);
      this.router.navigate(['/login']);
    });
  }

}
