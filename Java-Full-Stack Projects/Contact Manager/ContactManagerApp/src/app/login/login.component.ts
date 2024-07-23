import { NgIf } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { login } from '../login';
import { ContactServiceService } from '../contact-service.service';
import { HttpClientModule } from '@angular/common/http';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule,NgIf,HttpClientModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {
    ngOnInit() {
        
    }
    message:any;
    login : login = new login('', '');
    constructor(private service:ContactServiceService,private router:Router){}
    public Login(){
      this.service.dologin(this.login).subscribe((data)=> {
        this.message = data;
        if(this.message == "Welcome Back!") {
          this.router.navigate(['/']);
        } 
        console.log("login working!");
      })
    }
}
