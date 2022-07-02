import { Component, OnInit } from '@angular/core';
import { Userinfo } from 'src/app/models/Userinfo';
import { RegisterLoginService } from 'src/app/services/login-register/register-login.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  message='';
  user=new Userinfo();
  constructor(private rls:RegisterLoginService,private router:Router) { }

  ngOnInit(): void {}
  registeruser(){
    this.rls.registerUserfromBackend(this.user).subscribe(
      response=>{
        console.log(response);
        this.message="Registered Successfully";
        console.log(this.message);
        this.router.navigate(['/login']);
      },
      error=>{
        console.log(error);
        this.message="User Already Exists"; 
      }
    )
  }
}
