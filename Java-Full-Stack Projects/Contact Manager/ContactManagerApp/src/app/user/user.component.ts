import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { ContactServiceService } from '../contact-service.service';
import { FormsModule } from '@angular/forms';
import { NgIf } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-user',
  standalone: true,
  imports: [FormsModule,NgIf,HttpClientModule],
  templateUrl: './user.component.html',
  styleUrl: './user.component.css'
})
export class UserComponent implements OnInit {
    ngOnInit(): void {
      console.log("oninit");
      throw new Error('Method not implemented.');
    }

    constructor(private contactService: ContactServiceService) {}
    user:User = new User('', '', '', '');

    message: any;
    public signup() {
      this.contactService.dosignUp(this.user).subscribe((data) => {
        this.message = data;
      });
    }
}

